package com.adamwesterman.core;

import java.net.UnknownHostException;
import java.util.ArrayList;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class DBHandler {
	
	private MongoClient mongoClient;
	private DB db;
	
	public DBHandler(String dbName) {
		try {
			this.mongoClient = new MongoClient("localhost", 27017);
		} catch (UnknownHostException e) {
			System.out.println("Couldn't connect to MongoDB on localhost");
		}
		
		this.db = this.mongoClient.getDB(dbName);
	}
	
	public ArrayList<Track> getAllTracks() {
		ArrayList<Track> returnTracks = new ArrayList<Track>();
		DBCollection collection = db.getCollection("tracks");
		
		DBCursor cursor = collection.find();
		try {
			while (cursor.hasNext()) {
				DBObject object = cursor.next();
				String name = object.get("name").toString();
				String artist = object.get("artist").toString();
				Track track = new Track(name, artist);
				returnTracks.add(track);
			}
		} finally {
			cursor.close();
		}
		
		return returnTracks;
	}
}
