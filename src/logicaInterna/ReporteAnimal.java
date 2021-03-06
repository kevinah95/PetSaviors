package logicaInterna;

import java.util.*;
import logicaExterna.Tiempo;

public class ReporteAnimal{
	
	public ReporteAnimal(String pTipoMascota, String pRaza, String pColor,
			   			String pTelefonoContacto, String pCorreoContacto,
			   			String pLugarContacto, String pCondicionEntrada,
			   			//Los sig. par�metros no son requeridos. 
			   			String pChipIdentificacion, String pNombreMascota,
			   			String pRecompensa,String pSexo,
			   			String pIdentificacionReportante) 
	{
		setAnimalReportado(new Animal(pTipoMascota, pRaza, pColor,
							pChipIdentificacion, pNombreMascota, pSexo));
		
		
		setIdentificacionReportante(pIdentificacionReportante);
		setTelefonoContacto(pTelefonoContacto); 
		setCorreoContacto(pCorreoContacto); 
		setLugarContacto(pLugarContacto);
		setCondicionEntrada(pCondicionEntrada); 
		setFotosAnimal(new ArrayList<String>());
		setRecompensa(Double.parseDouble(pRecompensa));
		setFechaRegistrado(Tiempo.fechaSistema());
		setFechaSalidaSistema("false");
		setCondicionSalida("false");
		setEnAdopcion(false);
		setDiasSistema(1);
	}

	private String identificacionReportante = null;
	private String telefonoContacto = null;
	private String correoContacto = null;
	private String lugarContacto = null;
	private ArrayList<String> fotosAnimal;
	private String condicionEntrada; //"Encontrado, Extraviado"
	private double recompensa = 0; //0 si no hay recompensa. Else: Si hay recompensa. 
	
	private Animal animalReportado;
	private String fechaRegistrado = null;
	private String fechaSalidaSistema = null;
	private boolean enAdopcion = false; //Si diasSistema tiene determinado n�mero, cambia a positivo. 
	
	private String condicionSalida = null; //"Devuelto": Se encontr� al due�o y fue devuelto. "Adoptado": Alguien lo adopt�.
	private int diasSistema = 0; 
	
	
	public String getIdentificacionReportante() {
		return identificacionReportante;}
	public void setIdentificacionReportante(String pIdentificacionReportante) {
		this.identificacionReportante = pIdentificacionReportante;}
	public String getTelefonoContacto() {
		return telefonoContacto;}
	public void setTelefonoContacto(String telefonoContacto) {
		this.telefonoContacto = telefonoContacto;}
	public String getCorreoContacto() {
		return correoContacto;}
	public void setCorreoContacto(String correoContacto) {
		this.correoContacto = correoContacto;}
	public String getLugarContacto() {
		return lugarContacto;}
	public void setLugarContacto(String lugarContacto) {
		this.lugarContacto = lugarContacto;}
	public String getCondicionEntrada() {
		return condicionEntrada;}
	public void setCondicionEntrada(String condicionEntrada) {
		this.condicionEntrada = condicionEntrada;}	
	public ArrayList<String> getFotosAnimal() {
		return fotosAnimal;}
	public void setFotosAnimal(ArrayList<String> fotosAnimal) {
		this.fotosAnimal = fotosAnimal;}
	public void agregarFotosAnimal (String nuevaFoto){
		this.fotosAnimal.add(nuevaFoto);}
	public double getRecompensa() {
		return recompensa;}
	public void setRecompensa(double dRecompensa) {
		this.recompensa = dRecompensa;}
	public String getFechaRegistrado() {
		return fechaRegistrado;}
	public void setFechaRegistrado(String fechaRegistrado) {
		this.fechaRegistrado = fechaRegistrado;}
	public String getFechaSalidaSistema() {
		return fechaSalidaSistema;}
	public void setFechaSalidaSistema(String fechaSalidaSistema) {
		this.fechaSalidaSistema = fechaSalidaSistema;}
	public boolean isEnAdopcion() {
		return enAdopcion;}
	public void setEnAdopcion(boolean enAdopcion) {
		this.enAdopcion = enAdopcion;}
	public String getCondicionSalida() {
		return condicionSalida;}
	public void setCondicionSalida(String condicionSalida) {
		this.condicionSalida = condicionSalida;}
	public int getDiasSistema() {
		return diasSistema;}
	public void setDiasSistema(int diasSistema) {
		this.diasSistema = diasSistema;}
	public Animal getAnimalReportado() {
		return animalReportado;}
	public void setAnimalReportado(Animal animalReportado) {
		this.animalReportado = animalReportado;}

	@Override
	public String toString() {
		return  getAnimalReportado().toString() + 
				"ReporteAnimal [telefonoContacto=" + telefonoContacto
				+ ", correoContacto=" + correoContacto + ", lugarContacto="
				+ lugarContacto + ", fotosAnimal=" + fotosAnimal
				+ ", condicionEntrada=" + condicionEntrada + ", recompensa="
				+ recompensa + ", animalReportado=" + animalReportado
				+ ", fechaRegistrado=" + fechaRegistrado
				+ ", fechaSalidaSistema=" + fechaSalidaSistema
				+ ", enAdopcion=" + enAdopcion + ", condicionSalida="
				+ condicionSalida + ", diasSistema=" + diasSistema + "]";
	}
}
