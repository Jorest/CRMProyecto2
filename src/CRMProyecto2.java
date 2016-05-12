
import com.mongodb.MongoClient;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

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

        GUI gui = new GUI();
        gui.setVisible(true);
        
        System.out.println("Prueba conexión MongoDB");
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
}

