package edu.ucla.cs218.crawler;

import almonds.ParseException;
import almonds.ParseObject;
import almonds.ParseQuery;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.sun.org.apache.bcel.internal.generic.NEW;
import database.parse.tables.ParseSensor;
import database.parse.util.DBGlobals;

import edu.ucla.cs218.data.DataHelper;
import edu.ucla.cs218.sensite.MongoConnector;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import edu.ucla.cs218.crawler.MatchFinder;

public class Matcher {
    
	private HashMap<String, Integer> matches 		= new HashMap<String, Integer>();
	
	public void matchPhenomenonsAndSensorsWithText(String text) throws ParseException, IOException
	{
		System.out.print(".");
		analyze(text);
	}
	
	public void matchPhenomenonsAndSensorsWithText(String[] lines) throws ParseException, IOException
	{
		System.out.print(".");
		for (String line : lines)
		{
                    line = line.trim();
                    analyze(line);
		}
	}
	
	private void analyze(String text) throws ParseException, IOException
	{
            Integer numOfOcc;
            
            MatchFinder matchFinder = new MatchFinder();
            List<String> matchesFound = matchFinder.FindMatches(text);
                
            //No possible matches if none or only 1 found
            if(matchesFound.isEmpty() || matchesFound.size() < 2)
                return;
            
            //Match phenomenon found to sensors found if there exist any such pairs
            for(String match : matchesFound)
            {
                if(Controller.isPhenomenon(match))
                {
                    for(String otherMatch : matchesFound)
                    {
                        // Don't form phenomenon-phenomenon associations
                        if(Controller.isPhenomenon(otherMatch))
                            continue;
                        // Form association
                        String association = match + "-" + otherMatch;
                        System.out.println(association);
                        numOfOcc = 1;
                    if(matches.get(association) != null)
                        {
                            numOfOcc = matches.get(association);
                            numOfOcc++;
                        }
                        matches.put(association, numOfOcc);
                    }
                }
            }
            
	}
	
	public void saveStatisticsToDB() throws Exception
	{
            // Get Database Handle
            DB db = MongoConnector.getDatabase();
            DBCollection associations = db.getCollection("associations");
            
            // Add matches found to Associations table in database
            if (!matches.isEmpty()){
                for (String key : matches.keySet())
                {
                    List<String> keys 		= Arrays.asList(key.split("\\-"));
                    String phenomenon 		= keys.get(0);
                    String sensor 			= keys.get(1);
                    int frequency			= matches.get(key);
                                
                    //  ADDING CODE
                    DBCursor cursor;
                    BasicDBObject query = new BasicDBObject("phenomenon", phenomenon).
                                      append("sensor", sensor);
                    cursor = associations.find(query);
                    if(cursor.hasNext())
                    {
                        DBObject result = cursor.next();
                        frequency += (Integer) result.get("frequency");
                        BasicDBObject update = new BasicDBObject("phenomenon", phenomenon).append("sensor", sensor)
                                .append("frequency", frequency);
                        associations.update(query, update);
                    }
                    else
                    {
                        BasicDBObject newAssociation = new BasicDBObject("phenomenon", phenomenon).append("sensor", sensor)
                                .append("frequency", frequency);
                        associations.insert(newAssociation);
                    }
                }

                //Clear existing matches
		matches 		= new HashMap<String, Integer>();

	}
    }
}
