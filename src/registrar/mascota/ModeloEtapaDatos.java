package registrar.mascota;

import java.util.function.Predicate;

import javax.swing.JOptionPane;

import logicaExterna.Mascotas;
import logicaInterna.ReporteAnimal;
import clasificacion.animales.ControlEspecie;

public class ModeloEtapaDatos {

	String[] listaRaza = null;
	
	private static ModeloEtapaDatos instance = null;
	private static final boolean DENEGADO = false;
	Predicate<ReporteAnimal> predicadoChipAnimal;
	Predicate<ReporteAnimal> predicadoModoEncontrado;
	Predicate<ReporteAnimal> predicadoModoPerdido;
	Predicate<ReporteAnimal> predicadoFullModo;
	
	private boolean condicionChip=false;
	
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
		
		condicionChip = true;		
		predicadoChipAnimal = new Predicate<ReporteAnimal>() {
			public boolean test(ReporteAnimal t) {
				
				return t.getAnimalReportado().getChipIdentificacion().equals(chip);
			}
		};
		
		if (RegistrarMascota.modoRegistro.equals(RegistrarMascota.ENCONTRADO)){
			predicadoModoEncontrado = new Predicate<ReporteAnimal>() {
				public boolean test(ReporteAnimal t) {
					
					return t.getCondicionEntrada().equals(RegistrarMascota.ENCONTRADO);
				}
			};
			predicadoFullModo = predicadoChipAnimal.and(predicadoModoEncontrado);
			
		}
			
		if (RegistrarMascota.modoRegistro.equals(RegistrarMascota.EXTRAVIADO)){
			predicadoModoPerdido = new Predicate<ReporteAnimal>() {
				public boolean test(ReporteAnimal t) {
					
					return t.getCondicionEntrada().equals(RegistrarMascota.EXTRAVIADO);
				}
			};
			predicadoFullModo = predicadoChipAnimal.and(predicadoModoPerdido);
		}
		
		Mascotas.mascotasRegistradas.stream().filter(predicadoFullModo).forEach(p->cambiarCondicionChip());
		System.out.println(condicionChip);
		return condicionChip;
	}
	
	
		
		
	
	private void cambiarCondicionChip(){
		System.out.println("denegado");
		condicionChip = DENEGADO; //si lo encontró entonces no se puede registrar 
	}

}
