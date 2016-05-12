/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.UnknownHostException;
import java.util.List;

import java.net.UnknownHostException;
import java.util.List;
 
import com.mongodb.MongoClient;
/**
 *
 * @author Proton
 */
public class MangoDB { 
    
    public static MongoClient crearConexion() {
        MongoClient mongo = null;
        mongo = new MongoClient("localhost", 27017);
        return mongo;
    }
 
    /**
     * Clase que imprime por pantalla todas las bases de datos MongoDB.
     * @param mongo conexión a MongoDB
     */

    public static void printDatabases(MongoClient mongo) {
        List dbs = mongo.getDatabaseNames();
        for (Object db : dbs) {
            System.out.println(" - " + db);
        }
    }
}   

