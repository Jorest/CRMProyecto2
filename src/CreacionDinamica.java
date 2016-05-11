//metodos para modificar tablas
//puede que sea mejor agregar los metodos a la clase de duarte despues
public class CreacionDinamica {

	
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
			query+= '\n' +"INSERT INTO NewCamps ( "+'\''+nombre+'\''+", "+'\''+tipo+'\''+") ;" ;
		}
		return query ;
					
	}
}
