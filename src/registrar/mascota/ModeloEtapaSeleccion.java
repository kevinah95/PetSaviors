package registrar.mascota;

public class ModeloEtapaSeleccion {

	private static ModeloEtapaSeleccion instance = null;
	protected ModeloEtapaSeleccion() {
		
	}
	
	public static ModeloEtapaSeleccion getInstance(){
		if (instance == null){ instance = new ModeloEtapaSeleccion(); }
		return instance;
	}
	
	
	

}
