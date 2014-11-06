package clasificacion.animales;

import java.util.ArrayList;


public class Prueba {

	
	public Prueba() {
		
	}
	public static void main(String[] args){
		ControlEspecie ce = ControlEspecie.getInstance();
		ce.especiesRegistradas.forEach(p-> p.getNombre() );
		
		
	}
	
	

}
