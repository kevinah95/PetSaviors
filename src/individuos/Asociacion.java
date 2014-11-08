package individuos;

import java.util.ArrayList;

public class Asociacion extends Individuo{

	public Asociacion(String pIdentificacion, String pNombre, String primerApellido,
			String segundoApellido,String pTelefono, String pCorreo,String pContrasena, 

			ArrayList<String> pActividadRegistrada)
	{
		super ( pIdentificacion,pNombre,primerApellido,
			    segundoApellido,pTelefono,pCorreo, pContrasena,
			    "false","false","false");
		setActividadRegistrada(pActividadRegistrada);
	}
	private ArrayList<String> actividadRegistrada = new ArrayList<String>();
	
	public ArrayList<String> getActividadRegistrada() {
		return actividadRegistrada;}
	public void setActividadRegistrada(ArrayList<String> actividadRegistrada) {
		this.actividadRegistrada = actividadRegistrada;}
	
	@Override
	public String toString() {
		return "Individuo;Asociacion;" 
				+ identificacion + ";"
				+ nombre + ";" 
				+ correo + ";"
				+ actividadRegistrada +";" //Cambiar array por $
				+ datosSistema.toString();
	}
}
