package edu.ucla.cs218.sensite;

import java.net.UnknownHostException;

import com.mongodb.*;

public class MongoConnector {
	static private DB db = null;
	static public DB getDatabase() {
		if (db == null)
			try {
				db = new MongoClient(new MongoClientURI("mongodb://sensite:sensite@ds053188.mongolab.com:53188/sensite")).getDB("sensite");
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		return db;
	}
}
