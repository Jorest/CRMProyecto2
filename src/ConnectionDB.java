
import java.sql.Connection;
import java.sql.DriverManager;

//Holi
public class ConnectionDB {
    
   public static Connection GetConnection()
    {
        Connection c = null;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/Proyecto2",
            "postgres", "postgres");
          // Statement stmt = c.createStatement();
        // ResultSet rs = stmt.executeQuery( "SELECT
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return c; 
    }
}