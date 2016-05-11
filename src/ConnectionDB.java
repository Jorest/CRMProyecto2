
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class ConnectionDB {
	public static Connection GetConnect () {
	      Connection c = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:5432/Proyecto2",
	            "postgres", "postgres");
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	      System.out.println("Opened database successfully");
	      return c ;
	}
        
        public void insertar(List valores) throws SQLException{
         Statement stmt = GetConnect().createStatement();
         String sql = "INSERT INTO COMPANY "
               + "VALUES (" ;
         String val="";
         for(int i=0;i<valores.size();i++){
             if (i==valores.size()-1){
                 val=val+(String)valores.get(i);
             }
             else{
                val=val+(String)valores.get(i)+",";
             }
         }
         sql=sql+" ) ;";
         stmt.executeUpdate(sql);
         stmt.close();
         GetConnect().commit();
        }
        
        public void select(){
            
        }
}	
	
