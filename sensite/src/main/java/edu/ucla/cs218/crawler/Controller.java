package edu.ucla.cs218.crawler;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import edu.ucla.cs218.crawler.GoogleResults.Result;
import edu.ucla.cs218.data.DataHelper;

public class Controller {
	
	private static GoogleResults getGoogleResults(String phenomenon)
    {
    	String google = "http://ajax.googleapis.com/ajax/services/search/web?v=1.0&q=";
        String search = phenomenon;
        String charset = "UTF-8";

        URL url;
        Reader reader;
        GoogleResults results;
		try {
			url = new URL(google + URLEncoder.encode(search, charset));
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
        int numberOfCrawlers 		= 10;
        int maxDepthOfCrawling 		= 1;
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
	
    public static void main(String[] args) throws Exception {
    	
    	List<String> phenomenons = DataHelper.getList(DataHelper.PHENOMENONS_LIST);
    	for (String phenomena : phenomenons)
    	{
    		System.out.println("Phenomena: "+phenomena);
    		GoogleResults results = getGoogleResults(phenomena);
    		List<Result> resultList = results.getResponseData().getResults();
    		List<String> urlsToSearch = new ArrayList<String>();
    		
//    		String wikiURL = "http://en.wikipedia.org/wiki/" + phenomena;
//    		System.out.println("Searching URL: "+wikiURL);
//    		urlsToSearch.add(wikiURL);
    		for (Result result : resultList)
    		{
                String urlToSearch 		= result.getUrl();
                System.out.println("Searching URL: "+urlToSearch);
                urlsToSearch.add(urlToSearch);
    		}
    		
    		setCrawlerConfig(urlsToSearch);
    	}   
    }
}
