
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import twitter4j.TwitterException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class CRMProyecto2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {


        Connection c = ConnectionDB.GetConnect();
        Twitter t= new Twitter();
        try {
            
            GUI gui = new GUI();
            gui.setVisible(true);
            t.getInformacion("RiverKev95");
            
           
            
            
          /**  System.out.println("Prueba conexión MongoDB");
            MongoClient mongo = MangoDB.crearConexion(); 
            if (mongo != null) {
            System.out.println("Lista de bases de datos: ");
                MangoDB.printDatabases(mongo);
            } else {
                System.out.println("Error: Conexión no establecida");
            }
        }
     
        /**
         * Clase para crear una conexión a MongoDB.
         * @return MongoClient conexión
         */
        } catch (TwitterException ex) {
            Logger.getLogger(CRMProyecto2.class.getName()).log(Level.SEVERE, null, ex);
        }

}
}

