package individuos;

import java.util.*;

import logicaInterna.Actividad;
import logicaInterna.Animal;

public class Individuo {

	public static ArrayList<Individuo> individuosInvolucrados = new ArrayList<Individuo>();
	
	public Individuo(String pIdentificacion, String pNombre, String primerApellido,
					String segundoApellido,String pTelefono, String pCorreo,String pContrasena, 
					String pCasaCuna) 
	{
		cantIndividuos++;
		setIdentificadorIndividuo(cantIndividuos);
		setIdentificacion(pIdentificacion);
		setNombre(pNombre);
		setpApellido(primerApellido);
		setsApellido(segundoApellido);
		setContrasena(pContrasena);
		setCorreo(pCorreo);
		setTelefono(pTelefono);
		setCasaCuna(Boolean.parseBoolean(pCasaCuna));
		setReportes(new ArrayList<Animal>());
	}
	
	protected static int cantIndividuos = 0;
	protected int identificadorIndividuo = 0;
	protected String identificacion,nombre,pApellido,sApellido,telefono,contrasena,correo = null; 
	protected boolean casaCuna;
	protected ArrayList<Actividad> eventosParticipado = new ArrayList<Actividad>();
	private ArrayList<Animal> reportes;	
	/*===================================================================================================*/
	/*===================================================================================================*/
	/*===================================================================================================*/
	public static ArrayList<Individuo> getUsuariosInvolucrados() {
		return individuosInvolucrados;}
	public static void setUsuariosInvolucrados(
			ArrayList<Individuo> usuariosInvolucrados) {
		Individuo.individuosInvolucrados = usuariosInvolucrados;}
	public static int getCantIndividuos() {
		return cantIndividuos;}
	public static void setCantIndividuos(int cantClientes) {
		Individuo.cantIndividuos = cantClientes;}
	public int getIdentificadorIndividuo() {
		return identificadorIndividuo;}
	public void setIdentificadorIndividuo(int identificadorCliente) {
		this.identificadorIndividuo = identificadorCliente;}
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
	public ArrayList<Actividad> getEventosParticipado() {
		return eventosParticipado;}
	public void setEventosParticipado(ArrayList<Actividad> eventosParticipado) {
		this.eventosParticipado = eventosParticipado;}
	public ArrayList<Animal> getReportes() {
		return reportes;}
	public void setReportes(ArrayList<Animal> reportes) {
		this.reportes = reportes;}
	/*===================================================================================================*/
	/*===================================================================================================*/
	/*===================================================================================================*/
	
	public void registrarAnimal ( ){}
	
	public void cambiarEstado ( ){} 
	
	public void editarCondicion ( ){}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	
	
	
	
	
}
