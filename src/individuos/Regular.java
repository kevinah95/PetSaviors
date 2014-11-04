package individuos;

import java.util.*;

import com.google.gson.annotations.SerializedName;

import logicaInterna.Animal;

public class Regular extends Individuo {

	public Regular(String pIdentificacion, String pNombre, String primerApellido,
			String segundoApellido, String pCorreo,String pContrasena, 
			String pCasaCuna) {
		super (pIdentificacion,pNombre,primerApellido,
			    segundoApellido,pCorreo, pContrasena,
			    pCasaCuna);
		setReportes(new ArrayList<Animal>());
	}
	
	@SerializedName("arrayrepo")
	private ArrayList<Animal> reportes;
	
	public ArrayList<Animal> getReportes() {
		return reportes;}
	public void setReportes(ArrayList<Animal> reportes) {
		this.reportes = reportes;
		}
	
	@Override
	public String toString() {
		return "Individuo:Regular"+ reportes 
				+ getIdentificadorIndividuo() + getIdentificacion()
				+ getNombre() + getCorreo() 
				+ getEventosParticipado() 
				+ getReportes()
				+ isCasaCuna()
				+ getEventosParticipado();
	}
}
