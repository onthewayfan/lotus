package com.lotus.mongodb;

import com.mongodb.Block;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongodbTest {
	
	public static void main(String[] args) {
		
        try (MongoClient client = new MongoClient("localhost", 27017)) {
            
            MongoDatabase database = client.getDatabase("db1");
            MongoCollection<Document> collection = database.getCollection("worker");
            
            // Created with Studio 3T, the IDE for MongoDB - https://studio3t.com/
            
            Document query = new Document();
            
            Block<Document> processBlock = new Block<Document>() {
                @Override
                public void apply(final Document document) {
                    System.out.println(document);
                }
            };
            
            collection.find(query).forEach(processBlock);
            
        } catch (MongoException e) {
            // handle MongoDB exception
            e.printStackTrace();
        }
    
	}
	
	

}
