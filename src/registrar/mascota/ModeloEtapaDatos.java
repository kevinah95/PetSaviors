package registrar.mascota;

import clasificacion.animales.ControlEspecie;

public class ModeloEtapaDatos {

	String[] listaRaza = null;
	private static ModeloEtapaDatos instance = null;
	protected ModeloEtapaDatos() {
		
	}
	public static ModeloEtapaDatos getInstance() {
		if (instance == null) {	instance = new ModeloEtapaDatos(); }
		return instance;
	}
	
	public String[] llenarComboRaza(String especieElegida){
		
		ControlEspecie.especiesRegistradas.stream().filter(
        		p->p.getNombre().equals(especieElegida)).forEach(
        				p->listaRaza = p.getListaRazas().toArray(new String[p.getListaRazas().size()]) );
		return listaRaza;
	}

}
