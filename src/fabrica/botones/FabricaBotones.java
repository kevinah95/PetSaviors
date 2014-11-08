package fabrica.botones;

import java.io.IOException;

import javax.swing.JButton;



public class FabricaBotones {

	private static FabricaBotones instance = null;
	public static final String TRANSPARENTE = "Transparente";
	public static final String NORMAL = "Normal";
	protected FabricaBotones() { }

	
	public static FabricaBotones getInstance() {
		if (instance == null) {	instance = new FabricaBotones(); }
		return instance;
	}
	
	/**
	 * Crea botones de tipo: Transparente - Normal
	 *
	 * @param
	 * @return Botón del tipo seleccionado
	 */
	public static JButton crearBoton(String tipoBoton, String nombreBoton){
		if (tipoBoton.equals("Transparente")){
			return new Transparente(nombreBoton);
		}else if( tipoBoton.equals("Normal") ){
			return new JButton(nombreBoton);
		}else return null;
	}

}
