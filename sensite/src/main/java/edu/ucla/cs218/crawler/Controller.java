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
import com.mongodb.*;
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
import edu.ucla.cs218.sensite.JSONParser;
import edu.ucla.cs218.sensite.MongoConnector;

public class Controller {

    //These global variables store the lists of phenomenon and sensor names
    public static HashMap<String, String> phenomenaNames = new HashMap<String, String>();
    public static HashMap<String, String> sensorNames = new HashMap<String, String>();
    
    //Checks if a given string is in the sensor list
    public static boolean isSensor(String s)
    {
        if(sensorNames.get(s) != null)
            return true;
        return false;
    }
    
    //Checks if a given string is in the phenomenon list
    public static boolean isPhenomenon(String p)
    {
        if(phenomenaNames.get(p) != null)
            return true;
        return false;
    }
    
    //Used to get google results
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
        DB db = MongoConnector.getDatabase();
        DBCollection phenomena = db.getCollection("phenomena");
        DBCollection sensors = db.getCollection("sensors");
        DBCursor cursor;
        
        //Fill phenomenon list
        cursor = phenomena.find();
        try {
            while(cursor.hasNext()) {
                DBObject phenomenon = cursor.next();
                String name = (String) phenomenon.get("phenomena");
                phenomenaNames.put(name, name);
            }
        } finally {
            cursor.close();
        }
        
        //Fill sensor list
        cursor = sensors.find();
        try {
            while(cursor.hasNext()) {
                DBObject sensor = cursor.next();
                String name = (String) sensor.get("sensor");
                sensorNames.put(name, name);
            }
        } finally {
            cursor.close();
        }
        
        //Query for each phenomenon and get the URLs
    	for (String phenomenon : phenomenaNames.values())
    	{
            System.out.println("Phenomena: " + phenomenon);
                
            //Query for each search term
            for(String searchterm : searchTerms ){
                System.out.println("Search Term: "+searchterm.replace("?", phenomenon));
    		GoogleResults results = getGoogleResults(searchterm.replace("?", phenomenon));
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
        
    }
}
