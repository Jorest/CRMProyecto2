import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class Zampadora {
	
	
	public void zampar(String json1){
		DBObject json =  (DBObject) com.mongodb.util.JSON.parse(json1);
	}

	

	public void agregarJson (DBObject objeto ){
		DBCollection troll;
		MongoClient mongo = null;
		try {
            mongo = new MongoClient("localhost", 27017);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
		DB db = mongo.getDB("Tweet");
		DBCollection collection = db.getCollection("user");
		collection.insert(objeto);
	
		
	}
	
	
}
