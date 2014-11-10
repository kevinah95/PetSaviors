package registrar.mascota;

import javax.swing.JOptionPane;

import logicaExterna.Mascotas;
import clasificacion.animales.ControlEspecie;

public class ModeloEtapaDatos {

	String[] listaRaza = null;
	private boolean confirmacionChip =false;
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
	
	public boolean verificarDatos(String nombre,String chip, String descripcion ){
		if(nombre.trim().isEmpty()){
			JOptionPane.showMessageDialog(RegistrarMascota.panelCards, "Por Favor ingrese el nombre de la mascota");
			return false;
		}else if(chip.trim().isEmpty()){
			JOptionPane.showMessageDialog(RegistrarMascota.panelCards, "Por Favor ingrese el chip de la mascota");
			return false;
		}else if(descripcion.trim().isEmpty()){
			JOptionPane.showMessageDialog(RegistrarMascota.panelCards, "Por Favor ingrese la descripción de la mascota");
			return false;
		}
		return true;
			
	}
	
	public boolean chipRepetido(String chip){
		Mascotas.mascotasRegistradas.forEach(p->confirmacionChip=p.getAnimalReportado().getChipIdentificacion().equals(chip));
		return confirmacionChip;
	}

}
