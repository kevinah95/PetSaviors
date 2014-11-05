package logicaInterna;

public class Animal {	
	
	public Animal (String pTipoMascota, String pRaza, String pColor,
				   //Los sig. parámetros no son requeridos. 
				   String pChipIdentificacion,
				   String pNombreMascota,String pSexo)
	{	
		cantAnimales++;
		setIdAnimal(cantAnimales);
		setTipoMascota(pTipoMascota);
		setRaza(pRaza);
		setColor(pColor);
		setChipIdentificacion(pChipIdentificacion);
		setNombreMascota(pNombreMascota);
		setSexo(pSexo);
	}
	
	//Variables de las que se encarga el sistema. 
	private static int cantAnimales = 0;
	private int idAnimal = 0;
	private float contadorSemejanzas = 0;

	//Los parámetros mínimos para el registro. 
	private String tipoMascota = null;
	private String raza = null;
	private String color = null;
	private String sexo = null;
	
	//Los parámetros secundarios. 
	private String chipIdentificacion = null;
	private String nombreMascota = null;
	
	//Getters y setters.
	public static int getCantAnimales() {
		return cantAnimales;}
	public static void setCantAnimales(int cantAnimales) {
		Animal.cantAnimales = cantAnimales;}
	public int getIdAnimal() {
		return idAnimal;}
	public void setIdAnimal(int idAnimal) {
		this.idAnimal = idAnimal;}
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
	public String getChipIdentificacion() {
		return chipIdentificacion;}
	public void setChipIdentificacion(String chipIdentificacion) {
		this.chipIdentificacion = chipIdentificacion;}
	public String getNombreMascota() {
		return nombreMascota;}
	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;}
	public float getContadorSemejanzas() {
		return contadorSemejanzas;}
	public void setContadorSemejanzas(float contadorSemejanzas) {
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
				+ chipIdentificacion + ";"
				+ nombreMascota;
	}
}
