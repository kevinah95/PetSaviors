package logicaInterna;

import java.util.ArrayList;

import logicaExterna.Tiempo;

public class ReporteAnimal extends Animal{

	public static ArrayList<ReporteAnimal> animalesSistema = new ArrayList<ReporteAnimal>();
	
	public ReporteAnimal(String pTipoMascota, String pRaza, String pColor,
			   			String pTelefonoContacto, String pCorreoContacto,
			   			String pLugarContacto, String pCondicionEntrada,
			   			//Los sig. parámetros no son requeridos. 
			   			String pChipIdentificacion, String pDirFoto,
			   			String pNombreMascota, String pRecompensa) 
	{
		super(pTipoMascota, pRaza, pColor,
			  pChipIdentificacion,
			  pNombreMascota);
		
		setTelefonoContacto(pTelefonoContacto); 
		setCorreoContacto(pCorreoContacto); 
		setLugarContacto(pLugarContacto);
		setCondicionEntrada(pCondicionEntrada); 
		setDirFoto(pDirFoto);
		setRecompensa(Double.parseDouble(pRecompensa));
		
		setFechaRegistrado(Tiempo.fechaSistema());
		setFechaSalidaSistema("false");
		setCondicionSalida("false");
		setEnAdopcion(false);
		setDiasSistema(1);
		
	}

	private String telefonoContacto = null;
	private String correoContacto = null;
	private String lugarContacto = null;
	private String dirFoto = null;
	private String condicionEntrada; //"Encontrado, Extraviado"
	private double recompensa = 0; //0 si no hay recompensa. Else: Si hay recompensa. 
	
	private String  fechaRegistrado = null;
	private String  fechaSalidaSistema = null;
	private boolean enAdopcion = false; //Si diasSistema tiene determinado número, cambia a positivo. 
	private String  condicionSalida = null; //"Devuelto": Se encontró al dueño y fue devuelto. "Adoptado": Alguien lo adoptó.
	private int 	diasSistema = 0; 
	
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
	public String getDirFoto() {
		return dirFoto;}
	public void setDirFoto(String dirFoto) {
		this.dirFoto = dirFoto;}
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
	
}
