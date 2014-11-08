package individuos;

import java.util.*;
import com.google.gson.annotations.SerializedName;
import logicaInterna.*;

public class Individuo implements java.io.Serializable{

	public static ArrayList<Individuo> individuosInvolucrados = new ArrayList<Individuo>();
	
	public Individuo(String pIdentificacion, String pNombre, String primerApellido,
					String segundoApellido,String pTelefono, String pCorreo,String pContrasena, 
					String pCasaCuna) 
	{
		setIdentificacion(pIdentificacion);
		setNombre(pNombre);
		setpApellido(primerApellido);
		setsApellido(segundoApellido);
		setContrasena(pContrasena);
		setCorreo(pCorreo);
		setTelefono(pTelefono);
		setCasaCuna(Boolean.parseBoolean(pCasaCuna));
		setDatosSistema(new ElementosIndividuoSistema());
	}
	
	protected String identificacion,nombre,pApellido,sApellido,telefono,contrasena,correo = null; 
	protected boolean casaCuna;
	protected ElementosIndividuoSistema datosSistema;
	
	/*===================================================================================================*/
	/*===================================================================================================*/
	/*===================================================================================================*/
	
	public ElementosIndividuoSistema getDatosSistema() {
		return datosSistema;}
	public void setDatosSistema(ElementosIndividuoSistema datosSistema) {
		this.datosSistema = datosSistema;}
	public String getIdentificacion() {
		return identificacion;}
	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;}
	public String getNombre() {
		return nombre;}
	public void setNombre(String nombre) {
		this.nombre = nombre;}
	public String getpApellido() {
		return pApellido;}
	public void setpApellido(String pApellido) {
		this.pApellido = pApellido;}
	public String getsApellido() {
		return sApellido;}
	public void setsApellido(String sApellido) {
		this.sApellido = sApellido;}
	public String getContrasena() {
		return contrasena;}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;}
	public String getCorreo() {
		return correo;}
	public void setCorreo(String correo) {
		this.correo = correo;}
	public boolean isCasaCuna() {
		return casaCuna;}
	public void setCasaCuna(boolean casaCuna){
		this.casaCuna = casaCuna;}
	public String getTelefono() {
		return telefono;}
	public void setTelefono(String telefono) {
		this.telefono = telefono;}
	
	/*===================================================================================================*/
	/*===================================================================================================*/
	/*===================================================================================================*/
	public void cancelarReporte ( ReporteAnimal reporteAnimalPorCambiar ){
		
	}
	public void cerrarCasoPorReencuentro ( ReporteAnimal ReporteAnimalPorCerrar ){
		
	}
	public void reportarMascota (String pTipoMascota, String pRaza, String pColor,
								 String pLugarContacto, String pCondicionEntrada,
   								 String pChipIdentificacion, String pDirFoto,
   								 String pNombreMascota, String pRecompensa,String pSexo) 
	{
		ReporteAnimal animalReportado = new ReporteAnimal (pTipoMascota,pRaza,pColor,
										this.getTelefono(),this.getCorreo(), pLugarContacto,
										pCondicionEntrada, pChipIdentificacion, pDirFoto,
										pNombreMascota, pRecompensa, pSexo, this.getIdentificacion());
		ReporteAnimal.animalesSistema.add(animalReportado);
	}
	@Override
	public String toString() {
		return "Individuo [identificacion=" + identificacion + ", nombre="
				+ nombre + ", pApellido=" + pApellido + ", sApellido="
				+ sApellido + ", telefono=" + telefono + ", contrasena="
				+ contrasena + ", correo=" + correo + ", casaCuna=" + casaCuna
				+ ", datosSistema=" + datosSistema.toString() + "]";
	}
	
	
}
