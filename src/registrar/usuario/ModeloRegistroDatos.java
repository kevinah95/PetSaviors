package registrar.usuario;

import individuos.Individuo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import logicaExterna.Usuarios;

public class ModeloRegistroDatos {
	
	Usuarios usuarios = Usuarios.getInstance();

	public ModeloRegistroDatos() {
		
	}
	
	public boolean verificarDatos(String nombre, String pApellido,
			String sApellido, String telefono, String cedula, String correo,
			String contrasenia) {
		//Comprobar Nombre
		if ( nombre.trim().isEmpty() ){ //Verifica si tiene espacios en blanco
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Nombre no ha sido ingresado");	return false;}
		//Comprobar pApellido
		if ( pApellido.trim().isEmpty() ){
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Primer Apellido no ha sido ingresado"); return false;}
		//Comprobar sApellido
		if ( sApellido.trim().isEmpty() ){
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Segundo Apellido no ha sido ingresado"); return false;}
		if (!telefono.matches("\\d*") || telefono.trim().isEmpty()){
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Teléfono solo acepta digitos");	return false;}
		//Comprobar cédula
		if (!cedula.matches("\\d*") || cedula.trim().isEmpty()){
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Cédula solo acepta digitos");	return false;}else{
				if (!verificarCedula(cedula)){
					return false;
				}
			}
		//Comprobar Correo
		if ( correo.trim().isEmpty() ){
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Correo no ha sido ingresado");	return false;}
		else{
			if (verificarEmail(correo) == false){ return false; }
		}
		//Comprobar segundo apellido
		if ( contrasenia.trim().isEmpty() ){
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "El dato Contraseña no ha sido ingresado");	return false;}
		
		return true;
		
	}
	
	public boolean verificarEmail(String correo) {
		// Establecer el patrón
		Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
		// Asociar el string al patrón
		Matcher matchCorreo = p.matcher(correo);
		// Comprobar si encaja
		if (matchCorreo.matches()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(RegistarUsuario.panelCards,
					"La dirección de correo no es válida");
			return false;
		}

	}
	
	@SuppressWarnings("static-access")
	public boolean verificarCedula(String pCedula){
		if (usuarios.usuariosRegistrados == null){
			return true;
		}else{
			int coincidencias = (int) usuarios.usuariosRegistrados.stream().filter(p -> p.getIdentificacion().equals(pCedula)).count();
			if (coincidencias==0){
				return true; //Pasó la prueba
			}
		}
		return false;
	}
	

	
	

}
