package clasificacion.animales;

import java.util.ArrayList;

public class Especie {
	private String nombre;
	private ArrayList<String> listaRazas = new ArrayList<String>();
	
	public Especie(String nombre){
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<String> getListaRazas() {
		return listaRazas;
	}

	public void setListaRazas(ArrayList<String> listaRazas) {
		this.listaRazas = listaRazas;
	}
	
	public void addRaza(String raza){
		listaRazas.add(raza);
	}
	

}
