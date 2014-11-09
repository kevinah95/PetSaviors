package individuos;

import logicaInterna.*;

public class Individuo {

	public Individuo(String pIdentificacion, String pNombre, String primerApellido,
					 String segundoApellido,String pTelefono, String pCorreo,String pContrasena, 
					 String pCasaCuna,String pAdoptante,String pAdmin) 
	{
		setIdentificacion(pIdentificacion);
		setNombre(pNombre);
		setpApellido(primerApellido);
		setsApellido(segundoApellido);
		setContrasena(pContrasena);
		setCorreo(pCorreo);
		setTelefono(pTelefono);
		setCasaCuna(Boolean.parseBoolean(pCasaCuna));
		setAdoptante(Boolean.parseBoolean(pAdoptante));
		setAdministrador(Boolean.parseBoolean(pAdmin));
		setDatosSistema(new ElementosIndividuoSistema());
	}
	
	
	protected String identificacion,nombre,pApellido,sApellido,telefono,contrasena,correo = null; 
	protected boolean casaCuna,adoptante,administrador;
	protected ElementosIndividuoSistema datosSistema;
	protected InformacionCasaCuna informacionCasaCuna;
	protected InformacionAdoptante informacionAdoptante;
	
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
	public InformacionCasaCuna getInformacionCasaCuna() {
		return informacionCasaCuna;}
	public void setInformacionCasaCuna(InformacionCasaCuna informacionCasaCuna) {
		this.informacionCasaCuna = informacionCasaCuna;}
	public boolean isAdoptante() {
		return adoptante;}
	public void setAdoptante(boolean adoptante) {
		this.adoptante = adoptante;}
	public boolean isAdministrador() {
		return administrador;}
	public void setAdministrador(boolean administrador) {
		this.administrador = administrador;}
	public InformacionAdoptante getInformacionAdoptante() {
		return informacionAdoptante;}
	public void setInformacionAdoptante(InformacionAdoptante informacionAdoptante) {
		this.informacionAdoptante = informacionAdoptante;}
	
	public String getTelefono() {
		return telefono;}
	public void setTelefono(String telefono) {
		this.telefono = telefono;}
	
	/*===================================================================================================*/
	/*===================================================================================================*/
	/*===================================================================================================*/
	public void cancelarReporte ( ReporteAnimal reporteAnimalPorCambiar ){
		
	}
	public void cerrarCasoPorReencuentro ( ReporteAnimal ReporteAnimalPorCerrar )
	{	
		
	}
	
	public void calificarAdoptante (Individuo individuoPorCalificar, int calificacion)
	{
		if (individuoPorCalificar.isAdoptante())
			individuoPorCalificar.getInformacionAdoptante().agregarCalificacion(calificacion);
	}
	
	public void reportarMascota (String pTipoMascota, String pRaza, String pColor,
								 String pLugarContacto, String pCondicionEntrada,
   								 String pChipIdentificacion, 
   								 String pNombreMascota, String pRecompensa,String pSexo) 
	{
		ReporteAnimal animalReportado = new ReporteAnimal (pTipoMascota,pRaza,pColor,
										this.getTelefono(),this.getCorreo(), pLugarContacto,
										pCondicionEntrada, pChipIdentificacion,
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
