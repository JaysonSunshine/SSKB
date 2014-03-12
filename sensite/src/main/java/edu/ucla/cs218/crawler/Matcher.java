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
	private ResultSet resultSet;
	private ResultSet resultSetPhenomena;
	private HashMap<String, Integer> matches 		= new HashMap<String, Integer>();
	private HashMap<String, Integer> phenomenaOccourance 	= new HashMap<String, Integer>();
	
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
            //List<String> phenomenonsList 	= DataHelper.getList(DataHelper.PHENOMENONS_LIST);
            //List<String> sensorsList        = DataHelper.getList(DataHelper.SENSORS_LIST);
            Integer numOfOcc;
                
            //System.out.println(text);
            
            MatchFinder matchFinder = new MatchFinder();
            List<String> matchesFound = matchFinder.FindMatches(text);
                
            if(matchesFound.isEmpty() || matchesFound.size() < 2)
            {
                //System.out.println("no matches");
                return;
            }
            //System.out.println("HAS MATCHES");
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
            int flag = 0;
                
            if (!matches.isEmpty()){
                for (String key : matches.keySet())
                {
                    List<String> keys 		= Arrays.asList(key.split("\\-"));
                    String phenomenon 		= keys.get(0);
                    String sensor 			= keys.get(1);
                    int frequency			= matches.get(key);
                                
                    //  ADDING CODE
                    //while adding
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
                    /*
                    DBCursor curs = associations.find();
                    if(curs.hasNext()) {
                        DBObject o = curs.next();
                        String phen = (String) o.get("phenomenon") ; 
                        String sens = (String) o.get("sensor") ; 
                        if(phen.equals(phenomenon) && sens.equals(sensor))
                        {
                   
                            flag = 1;
                            BasicDBObject set = new BasicDBObject("phenomenon", phen).append("sensor", sens).append("$inc", new BasicDBObject("frequency", frequency));
                            associations.update(curs.curr(), set);
                        }
                    }

                                
                                
                    if(flag ==0) {   
                        BasicDBObject query2 = new BasicDBObject("phenomenon", phenomenon).append("sensor", sensor).append("frequency", frequency);
                    }
                    */
        
                                /*
                                if(!isInDatabase(phenomena-sensor))
                                {
                                    addToDatabase(phenomena-sensor, frequency);
                                    continue;
                                }
                                
                                curFrequency = getFromDatabase(phenomena-sensor);
                                addToDatabase(phenomena-sensor, freqeuncy+curFrequency);
                                */
                                
                                //
                                
                                
                                
                                
                                /*
				// If phenomenon doesn't exist, insert new
				//BasicDBList newSensorsList = new BasicDBList();
				//newSensorsList.add(new BasicDBObject()
				//	.append("sensorName", sensor)
				//	.append("count", 0)
				);
                                */
                                
                                // DATABASE ADDING PART, IGNORE FOR NOW
				/*
                                        db.getCollection("Phenomena").update(
					new BasicDBObject("phenomenaName", phenomena),
					new BasicDBObject("$setOnInsert", new BasicDBObject()
						.append("phenomenaName", phenomena)
						.append("count", 0)
						.append("sensors", newSensorsList)
					),
					true,
					false
				);
				
				// If phenomena-sensor pair doesn't exist, insert it
				db.getCollection("Phenomena").update(
					new BasicDBObject()
						.append("phenomenaName", phenomena)
						.append("sensors.sensorName", new BasicDBObject("$ne", sensor)),
					new BasicDBObject("$push", new BasicDBObject("sensors", newSensorsList.get(0))));
				
				// Update matches for phenomena-sensor pair
				db.getCollection("Phenomena").update(
					new BasicDBObject()
						.append("phenomenaName", phenomena)
						.append("sensors.sensorName", sensor),
					new BasicDBObject("$inc
                                
				//double ratio = totalNumberMatches/(double)totalNumberPhenomenaOcc;
				//String ratioString = new DecimalFormat("##.##").format(ratio*100);
				System.out.println("\nSensor: '"+sensor+"' have matched phenomena :'"+phenomena+"' with frequency: "+matchCount+" %");
			}
		}
		
                // DATABASE ADD, IGNORE FOR NOW
                /*
		if (!phenomenaOccourance.isEmpty()){", new BasicDBObject("sensors.$.count", matchCount)));
				
                                
				//double ratio = totalNumberMatches/(double)totalNumberPhenomenaOcc;
				//String ratioString = new DecimalFormat("##.##").format(ratio*100);
				//System.out.println("\nSensor: '"+sensor+"' have matched phenomena :'"+phenomena+"' with frequency: "+matchCount+" %");
			}
		}
		*/
                // DATABASE ADD, IGNORE FOR NOW
                /*
		if (!phenomenaOccourance.isEmpty()){
			for (String key : phenomenaOccourance.keySet())
			{
				String phenomena 		= key;
				int numberPhenomenaOcc	= phenomenaOccourance.get(phenomena);
				
				// If phenomenon doesn't exist, insert new
				db.getCollection("Phenomena").update(
					new BasicDBObject("phenomenaName", phenomena),
					new BasicDBObject("$setOnInsert", new BasicDBObject()
						.append("phenomenaName", phenomena)
						.append("count", 0)
						.append("sensors", new BasicDBList())
					),
					true,
					false
				);
				
				// Update occurances for phenomena
				db.getCollection("Phenomena").update(
					new BasicDBObject("phenomenaName", phenomena),
					new BasicDBObject("$inc", new BasicDBObject("count", numberPhenomenaOcc))
				);
			}
		}
		*/
                
		matches 		= new HashMap<String, Integer>();
		phenomenaOccourance 	= new HashMap<String, Integer>();
	}
    }
}
