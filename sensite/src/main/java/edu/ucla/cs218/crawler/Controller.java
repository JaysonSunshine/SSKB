package edu.ucla.cs218.crawler;

import almonds.ParseObject;
import almonds.ParseQuery;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import com.google.gson.Gson;
import database.parse.tables.ParsePhenomena;
import database.parse.tables.ParseSensor;
import database.parse.util.DBGlobals;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.ucla.cs218.crawler.GoogleResults.Result;
import edu.ucla.cs218.crawler.MatchFinder;

public class Controller {

    public static HashMap<String, String> phenomenaNames = new HashMap<String, String>();
    public static HashMap<String, String> sensorNames = new HashMap<String, String>();
    //public static ParseHandler PH = new ParseHandler();
    
    public static boolean isSensor(String s)
    {
        if(sensorNames.get(s) != null)
            return true;
        return false;
    }
    
    public static boolean isPhenomenon(String p)
    {
        if(phenomenaNames.get(p) != null)
            return true;
        return false;
    }
    
    private static GoogleResults getGoogleResults(String phenomenon)
    {
        //NOTE: &start=10 --- there's a start paramater that controls paging of search results
    	String googleURL = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
        String search = phenomenon;
        String charset = "UTF-8";

        URL url;
        Reader reader;
        GoogleResults results;
        try {
            url = new URL(googleURL + URLEncoder.encode(search, charset));
            reader = new InputStreamReader(url.openStream(), charset);
            results = new Gson().fromJson(reader, GoogleResults.class);
        return results;
        } catch (MalformedURLException e) {
                e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }
        return null;
    }
	
	private static void setCrawlerConfig(List<String> urlsToSearch) throws Exception
	{
            String crawlStorageFolder 	= "data/crawl/root";
            int numberOfCrawlers 		= 10;//Crawling 10 pages at a time cause thats how many search results return
            int maxDepthOfCrawling 		= 1;//Crawl only the top webpage
    //        int maxPagesToFetch			= 100;
        
            CrawlConfig config = new CrawlConfig();
            config.setCrawlStorageFolder(crawlStorageFolder);
            config.setMaxDepthOfCrawling(maxDepthOfCrawling);
    //        config.setMaxPagesToFetch(maxPagesToFetch);
            /*
             * Instantiate the controller for this crawl.
             */
            PageFetcher pageFetcher = new PageFetcher(config);
            RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
            RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);
            CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

            /*
             * For each crawl, you need to add some seed urls. These are the first
             * URLs that are fetched and then the crawler starts following links
             * which are found in these pages
             */
            for (String urlToSearch : urlsToSearch)
            {
                if (!urlToSearch.toLowerCase().contains("en.wikipedia.org".toLowerCase())){
                        controller.addSeed(urlToSearch);
                }else{
                        //crawler doesn't work on wikipedia
                }
            }
            /*
             * Start the crawl. This is a blocking operation, meaning that your code
             * will reach the line after this only when crawling is finished.
             */
            controller.start(Crawler.class, numberOfCrawlers); 
	}
	
    static String []searchTerms = {"? measurement instrument", "how to measure ?"};
    public static void main(String[] args) throws Exception {
    	
        /*
        PARSE HANDLER SETUP HERE
        */
        
        //THIS MUST BE CALLED ONCE in order to register the Parse objects and initialize the DB
        DBGlobals.InitializeParse();
        
        
        // GET PARSE PHENOMENA TABLE
        // PH.getPhenomenaTable(phenomenaNames);
        ParseQuery phenomenaQueryObject = new ParseQuery(DBGlobals.TABLE_PHENOMENA);
        phenomenaQueryObject.setLimit(1000);
        List<ParseObject> phenomenaList = phenomenaQueryObject.find();

        for (ParseObject phenomena : phenomenaList)
        {
            String name = phenomena.getString(ParsePhenomena.NAME);
            phenomenaNames.put(name, name);
            //System.out.println(phenomenaNames.size());
        }
        
        // END PARSE PHENOMENON TABLE
        
        // GET PARSE SENSOR TABLE
        // PH.getSensorTable(sensorNames);
        ParseQuery sensorQueryObject = new ParseQuery(DBGlobals.TABLE_SENSOR);
        sensorQueryObject.setLimit(1000);
        List<ParseObject> sensorList = sensorQueryObject.find();
        
        for (ParseObject sensor : sensorList)
        {
            String name = sensor.getString(ParseSensor.NAME);
            sensorNames.put(name, name);
            //System.out.println(sensorNames.size());
        }
        
        // END PARSE SENSOR TABLE
        
        MatchFinder match = new MatchFinder();
        List<String> possibleMatches = new ArrayList<String>();
        match.getMatches("rain", possibleMatches);
        System.out.println("Matches Found:");
        for(String poop : possibleMatches)
            System.out.println(poop);
        
        
        /*
    	for (ParseObject phenomena : phenomenaList)
    	{
            String name = phenomena.getString(ParsePhenomena.NAME);
            System.out.println("Phenomena: " + name);
                
            //Query for each search term
            for(String searchterm : searchTerms ){
                System.out.println("Search Term: "+searchterm.replace("?", name));
    		GoogleResults results = getGoogleResults(searchterm.replace("?", name));
    		List<Result> resultList = results.getResponseData().getResults();
                
    		List<String> urlsToSearch = new ArrayList<String>();
    		for (Result result : resultList)
    		{
                    String urlToSearch 	= result.getUrl();
                    System.out.println("Searching URL: "+urlToSearch);
                    urlsToSearch.add(urlToSearch);
    		}
                //Start the crawlers
                setCrawlerConfig(urlsToSearch);
            }
    		
    	}
        */
    }
}
