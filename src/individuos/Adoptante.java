package individuos;

import java.util.*;

public class Adoptante extends Individuo{

	public Adoptante(String pIdentificacion, String pNombre, String primerApellido,
			String segundoApellido, String pCorreo,String pContrasena, 
			String pCasaCuna,
			
			String pDirImagenes,
			String pImagenes,
			String pCalificaciones)
	{
		
		super(pIdentificacion,pNombre,primerApellido,
			    segundoApellido,pCorreo, pContrasena,
			    pCasaCuna);
		setDirImagenes(pDirImagenes);
		String[] imagenes;
		imagenes = pImagenes.split("$");
		for ( String directorioImagen : imagenes )
			img.add(directorioImagen);
		String[] calif;
		calif = pCalificaciones.split("$");
		for ( String nota : calif )
			calificaciones.add(Integer.parseInt(nota));
	}
	
	private String dirImagenes = null;
	private ArrayList<String> img = new ArrayList<String>();
	private ArrayList<Integer> calificaciones = new ArrayList<Integer>();
	
	public String getDirImagenes() {
		return dirImagenes;}
	public void setDirImagenes(String dirImagenes) {
		this.dirImagenes = dirImagenes;}
	public ArrayList<String> getImg() {
		return img;}
	public void setImg(ArrayList<String> img) {
		this.img = img;}
	public ArrayList<Integer> getCalificaciones() {
		return calificaciones;}
	public void setCalificaciones(ArrayList<Integer> calificaciones) {
		this.calificaciones = calificaciones;}
	
	@Override
	public String toString() {
		return "Individuo;Adoptante;" +
				identificadorIndividuo+ ";" 
				+ identificacion + ";"
				+ nombre + ";" 
				+ correo + ";" 
				+ eventosParticipado + ";" //Cambiar array por división de $
				+ dirImagenes + ";"
				+ img + ";"					//Cambiar arrays por $
				+ calificaciones + ";";}
	
}
