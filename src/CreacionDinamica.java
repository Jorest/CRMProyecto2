import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

//metodos para modificar tablas
//puede que sea mejor agregar los metodos a la clase de duarte despues
public class CreacionDinamica {
	 ArrayList<JTextField> campos = new ArrayList<JTextField>(); 
	 ArrayList<String> nombres = new ArrayList<String>();
	 ArrayList<String> tipos = new ArrayList<String>();
	 
	//chekiamos que el nombre no exista
	public boolean checkNombre (String tipo){
		return true ;
	}

	public String addCampo (String tipo , String nombre ){
		String query = "";
		if (checkNombre(nombre))
		{
			//alteramos la tabla e insertamos un nuevo elemento en el tabla de nuevos campos 
			
			try {

                Statement stmt = null;
                Connection c;
                //SQL query to send to database
                 Class.forName("org.postgresql.Driver");
           c = DriverManager
              .getConnection("jdbc:postgresql://localhost:5432/Empresa",
              "postgres", "none");
                stmt = c.createStatement();
				
				query+="AlTER TABLE \"Cliente\" ADD "+nombre+" "+tipo+" ;" ;
				System.out.println(query);
				query+= '\n' +"INSERT INTO \"NuevosCampos\" values ( "+'\''+nombre+'\''+", "+'\''+tipo+'\''+") ;";
				stmt.execute(query);
			}
			catch(Exception exception)
	        {
	                exception.printStackTrace();
	        }
			
			
		}
		return query ;				
	}

	
//metodo que agrega un boton

	public void agregarTextFields( JPanel frame ){
			int posiciony=300;
			Query();
		  for (int i=0 ; i<nombres.size();i++){
			  agregarTextField(frame,nombres.get(i), posiciony);
			  posiciony+=30 ;
			  
		  }
	
		  for (int i=0 ; i<campos.size();i++){
				frame.add(campos.get(i),BorderLayout.SOUTH);
				posiciony+=25;
			}
		  campos.clear();
	
	}
	
	public void agregarTextField( JPanel frame, String nombre, int pos ){
    
	//   frame.setLayout(new GridLayout(0, 1));
	   
	   JTextField milabel =new JTextField(nombre) ;
	   milabel.setSize(100,25);
	   milabel.setLocation(10,pos);
	   milabel.setVisible(true);
	   campos.add(milabel);
	   
	 	
	}

//**
	public void Query(){ 
	       
	      try{
	                Statement stmt = null;
	                Connection c;
	                //SQL query to send to database
	                 Class.forName("org.postgresql.Driver");
	           c = DriverManager
	              .getConnection("jdbc:postgresql://localhost:5432/Empresa",
	              "postgres", "none");
	                stmt = c.createStatement();
	                String query = "select * from \"NuevosCampos\"";
	                 
	                //invoke and store query results
	                
	                ResultSet resultSet = stmt.executeQuery(query);
	                //invoke and store query metadata results
	                ResultSetMetaData metadata = resultSet.getMetaData(); 
	          
	                //store number of columns in queried database table
	                int numcols = metadata.getColumnCount(); 
	                System.out.println("asdaosdiaosdiaosdioasidoaisdoiasd");
	                System.out.println(numcols);
	 
	                //create string array to hold column names
	                 String[] col = new String[numcols];
	 
	                //read column names into string array
	                for(int count = 0; count < numcols; count++)
	                {           
	                        col[count] = metadata.getColumnLabel(count + 1);
	                        System.out.println(col[count]);
	                }               
	 
	                //create table model to display query results           
	                DefaultTableModel dtm_search_model = new DefaultTableModel(null,col);
	 
	                //display resultSet(stored query data) in DefaultTable Model(JTable)                        
	                while (resultSet.next())
	           {
	               Object [] rowData = new Object[numcols];
	               for (int i = 0; i < rowData.length; ++i)
	               {
	                  if (i==0){
	                	  nombres.add((String)resultSet.getObject(i+1).toString());
	                	  //System.out.println(rowData[i].toString());
	                  }else {
	                	  tipos.add((String)resultSet.getObject(i+1).toString());	  
	                  }
	                  
	               }
	                }
	        }
	        catch(Exception exception)
	        {
	                exception.printStackTrace();
	        }
	     return;
	  }
	

//**	
}

