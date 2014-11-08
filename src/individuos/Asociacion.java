package individuos;

import java.util.ArrayList;

public class Asociacion extends Individuo{

	public Asociacion(String pIdentificacion, String pNombre, String primerApellido,
			String segundoApellido,String pTelefono, String pCorreo,String pContrasena, 
			
			String pActividad)
	{
		super(pIdentificacion,pNombre,primerApellido,
			    segundoApellido,pTelefono,pCorreo, pContrasena,
			    "false");
		String[] actividad;
		actividad = pActividad.split("$");
		for ( String evento : actividad )
			actividadRegistrada.add(evento);
	}
	
	private ArrayList<String> actividadRegistrada = new ArrayList<String>();
	
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
