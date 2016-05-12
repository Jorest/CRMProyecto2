
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.List;


public class ConnectionDB {
    private Connection c;

    public ConnectionDB() {
        c=GetConnect();
    }
    
    
    
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
        
        public void insertar(List valores, List tipos) throws SQLException{
         Statement stmt = c.createStatement();
         String sql = "INSERT INTO \"Cliente\" "
               + "VALUES (" ;
         String val="";
         for(int i=0;i<valores.size();i++){
             if (i==valores.size()-1){
                 val=val+(String)valores.get(i);
             }
             else{
                val=val+tipoRetorno((String)valores.get(i),(String)tipos.get(i))+",";
             }
         }
         sql=sql+" ) ;";
         stmt.executeUpdate(sql);
         stmt.close();
         c.commit();
        }
        
        public String tipoRetorno(String valor, String tipo){
            if(tipo.equals("int")||tipo.equals("float")){
                return valor;
            }
            else {
                return "\""+valor+"\"";
            }
            }
        public void select(){
            
        }
}
       /** public void update(String id, ) throws SQLException{
            Statement stmt = c.createStatement();
            String sql = "UPDATE \"Cliente\" set SALARY = 25000.00 where ID=1;";
            stmt.executeUpdate(sql);
            c.commit();

        }
}	
	**/
