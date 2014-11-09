package fabrica.botones;

import javax.swing.JButton;

public class FabricaBotones {

	private static FabricaBotones instance = null;
	public static final String TRANSPARENTE = "JButtonTransparente";
	public static final String NORMAL = "Normal";
	protected FabricaBotones() { }

	
	public static FabricaBotones getInstance() {
		if (instance == null) {	instance = new FabricaBotones(); }
		return instance;
	}
	
	/**
	 * Crea botones de tipo: JButtonTransparente - Normal
	 *
	 * @param
	 * @return Botón del tipo seleccionado
	 */
	public static JButton crearBoton(String tipoBoton, String nombreBoton){
		if (tipoBoton.equals("JButtonTransparente")){
			return new JButtonTransparente(nombreBoton);
		}else if( tipoBoton.equals("Normal") ){
			return new JButton(nombreBoton);
		}else return null;
	}

}
