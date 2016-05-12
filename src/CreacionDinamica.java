import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

//metodos para modificar tablas
//puede que sea mejor agregar los metodos a la clase de duarte despues
public class CreacionDinamica {
	 ArrayList<JTextField> campos = new ArrayList<JTextField>(); 
	
	//chekiamos que el nombre no exista
	public boolean checkNombre (String tipo){
		return true ;
	}

	public String addCampo (String tabla, String tipo , String nombre ){
		String query = "";
		if (checkNombre(nombre))
		{
			//alteramos la tabla e insertamos un nuevo elemento en el tabla de nuevos campos 
			query+="aLTER TABLE" +tabla+ "ADD" +nombre+" "+ tipo +";" ;
			query+= '\n' +"INSERT INTO  ( "+'\''+nombre+'\''+", "+'\''+tipo+'\''+") ;";
			
		}
		return query ;				
	}

	
//metodo que agrega un boton

	public void agregarTextFields( JPanel frame,ArrayList<String> nombres ){
		  for (int i=0 ; i<nombres.size();i++){
			  agregarTextField(frame,nombres.get(i));
		  }
	}
	
	public void agregarTextField( JPanel frame, String nombre){
    
	   frame.setLayout(new GridLayout(0, 1));

	   JTextField milabel =new JTextField(nombre) ;
	   milabel.setSize(100,20);
	   milabel.setVisible(true);
	   campos.add(milabel);
	   
	   for (int i=0 ; i<campos.size();i++){
			frame.add(campos.get(i),BorderLayout.SOUTH);
		}
	   
	    //frame.add(milabel,BorderLayout.SOUTH);
	
}


	

	
}

