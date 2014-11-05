package logicaInterna;

import java.util.*;
import logicaExterna.Tiempo;

public class Animal {	
	public static ArrayList<Animal> animalesSistema = new ArrayList<Animal>();
	public static ArrayList<Animal> resultadoPetFinder = new ArrayList<Animal>();
	
	public Animal (String pTipoMascota, String pRaza, String pColor,
				   String pTelefonoContacto, String pCorreoContacto,
				   String pLugarContacto, String pCondicionEntrada,
				   //Los sig. parámetros no son requeridos. 
				   String pChipIdentificacion, String pDirFoto,
				   String pNombreMascota, String pRecompensa)
	{	
		cantAnimales++;
		setIdAnimal(cantAnimales);
		setFechaRegistrado(Tiempo.fechaSistema());
		setFechaSalidaSistema("false");
		setCondicionSalida("false");
		setEnAdopcion(false);
		setDiasSistema(1);
		setTipoMascota(pTipoMascota);
		setRaza(pRaza);
		setColor(pColor);
		setTelefonoContacto(pTelefonoContacto); 
		setCorreoContacto(pCorreoContacto); 
		setLugarContacto(pLugarContacto);
		setCondicionEntrada(pCondicionEntrada); 
		setChipIdentificacion(pChipIdentificacion);
		setDirFoto(pDirFoto);
		setNombreMascota(pNombreMascota);
		setRecompensa(Double.parseDouble(pRecompensa));
	}
	
	//Variables de las que se encarga el sistema. 
	protected static int cantAnimales = 0;
	protected int idAnimal = 0;
	protected String fechaRegistrado = null;
	protected String fechaSalidaSistema = null;
	protected boolean enAdopcion = false; //Si diasSistema tiene determinado número, cambia a positivo. 
	protected String condicionSalida = null; //"Devuelto": Se encontró al dueño y fue devuelto. "Adoptado": Alguien lo adoptó.
	protected int diasSistema = 0; 
	private int contadorSemejanzas = 0;

	//Los parámetros mínimos para el registro. 
	protected String tipoMascota = null;
	protected String raza = null;
	protected String color = null;
	protected String sexo = null;
	protected String telefonoContacto = null;
	protected String correoContacto = null;
	protected String lugarContacto = null;
	protected String condicionEntrada; //False: Se perdió. True: Fue encontrado.
	
	//Los parámetros secundarios. 
	protected String chipIdentificacion = null;
	protected String dirFoto = null;
	protected String nombreMascota = null;
	protected double recompensa = 0; //0 si no hay recompensa. Else: Si hay recompensa. 

	//Getters y setters.
	public static ArrayList<Animal> getAnimalesSistema() {
		return animalesSistema;}
	public static void setAnimalesSistema(ArrayList<Animal> animalesSistema) {
		Animal.animalesSistema = animalesSistema;}
	public static int getCantAnimales() {
		return cantAnimales;}
	public static void setCantAnimales(int cantAnimales) {
		Animal.cantAnimales = cantAnimales;}
	public int getIdAnimal() {
		return idAnimal;}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;}
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
	public String getTipoMascota() {
		return tipoMascota;}
	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;}
	public String getRaza() {
		return raza;}
	public void setRaza(String raza) {
		this.raza = raza;}
	public String getColor() {
		return color;}
	public void setColor(String color) {
		this.color = color;}
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
	public String getChipIdentificacion() {
		return chipIdentificacion;}
	public void setChipIdentificacion(String chipIdentificacion) {
		this.chipIdentificacion = chipIdentificacion;}
	public String getDirFoto() {
		return dirFoto;}
	public void setDirFoto(String dirFoto) {
		this.dirFoto = dirFoto;}
	public String getNombreMascota() {
		return nombreMascota;}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;}
	public double getRecompensa() {
		return recompensa;}
	public void setRecompensa(double dRecompensa) {
		this.recompensa = dRecompensa;}
	public int getContadorSemejanzas() {
		return contadorSemejanzas;}
	public void setContadorSemejanzas(int contadorSemejanzas) {
		this.contadorSemejanzas = contadorSemejanzas;}
	public String getSexo() {
		return sexo;}
	public void setSexo(String sexo) {
		this.sexo = sexo;}
	
	@Override
	public String toString() 
	{
		return "Animal;"
				+ idAnimal + ";"
				+ tipoMascota + ";"
				+ raza + ";"
				+ color + ";"
				+ sexo + ";"
				+ telefonoContacto + ";"
				+ correoContacto + ";"
				+ lugarContacto + ";"
				+ condicionEntrada + ";"
				+ chipIdentificacion + ";"
				+ dirFoto + ";"
				+ nombreMascota + ";"
				+ enAdopcion + ";"
				+ condicionSalida + ";"
				+ diasSistema  + ";"
				+ recompensa + ";"
				+ fechaRegistrado + ";"
				+ fechaSalidaSistema;
	}
}
