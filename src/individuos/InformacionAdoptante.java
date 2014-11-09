package individuos;

import java.util.*;

public class InformacionAdoptante{

	public InformacionAdoptante(ArrayList<Integer> pCalificaciones)
	{
		setCalificaciones(pCalificaciones);
	}
	
	private ArrayList<Integer> calificaciones = new ArrayList<Integer>();
	
	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;}
	public void setCalificaciones(ArrayList<Integer> calificaciones) {
		this.calificaciones = calificaciones;}
	
	public void agregarCalificacion (int nuevaCalificacion){
		this.calificaciones.add(nuevaCalificacion);}
	
	@Override
	public String toString() {
		return "InformacionAdoptante;" //Cambiar arrays por $
				+ calificaciones;}
	
}
