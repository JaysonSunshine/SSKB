package edu.ucla.cs218.crawler;

import almonds.ParseException;
import java.util.regex.Pattern;

import edu.uci.ics.crawler4j.crawler.Page;
import edu.uci.ics.crawler4j.crawler.WebCrawler;
import edu.uci.ics.crawler4j.parser.HtmlParseData;
import edu.uci.ics.crawler4j.url.WebURL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Crawler extends WebCrawler {
	private static final boolean SPLIT_ON_PERIOD = true;
	private static Matcher matcher = new Matcher();
    private final static Pattern FILTERS = Pattern.compile(".*(\\.(css|js|bmp|gif|jpe?g" 
                                                      + "|png|tiff?|mid|mp2|mp3|mp4"
                                                      + "|wav|avi|mov|mpeg|ram|m4v|pdf" 
                                                      + "|rm|smil|wmv|swf|wma|zip|rar|gz))$");

    /**
     * You should implement this function to specify whether
     * the given url should be crawled or not (based on your
     * crawling logic).
     */
    @Override
    public boolean shouldVisit(WebURL url) {
            String href = url.getURL().toLowerCase();
            return !FILTERS.matcher(href).matches();// && href.startsWith("http://online.wsj.com/");
    }

    /**
     * This function is called when a page is fetched and ready 
     * to be processed by your program.
     */
    @Override
    public void visit(Page page) {          
//            String url = page.getWebURL().getURL();
//            System.out.println("URL: " + url);

            if (page.getParseData() instanceof HtmlParseData) {
                    HtmlParseData htmlParseData = (HtmlParseData) page.getParseData();
                    String text = htmlParseData.getText();
                    String textClean = text.trim().replaceAll(" +", " ");;
                    textClean = textClean.replace("\n", "").replace("\r", "").replace("\t", "");
                    
                  //Match phenomenons and sensors based in text from the website crawled
                    if (SPLIT_ON_PERIOD)
                    {
                    	String[] lines = textClean.split("\\.");
                        try {
                            matcher.matchPhenomenonsAndSensorsWithText(lines);
                        } catch (ParseException ex) {
                            Logger.getLogger(Crawler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }else{
                        try {
                            matcher.matchPhenomenonsAndSensorsWithText(textClean);
                        } catch (ParseException ex) {
                            Logger.getLogger(Crawler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }  
                    try {
                    	matcher.saveStatisticsToDB();
					} catch (Exception e) {
						e.printStackTrace();
					}
            }
    }
}
