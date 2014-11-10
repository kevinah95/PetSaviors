package editar.usuario;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import logicaExterna.Usuarios;

public class ModeloEditarDatos {
	
	Usuarios usuarios = Usuarios.getInstance();

	public ModeloEditarDatos() {
		
	}
	
	public boolean verificarDatos(String telefono, String correo) {

		if (!telefono.matches("\\d*")) {
			JOptionPane.showMessageDialog(EditarUsuario.panelCards,
					"El dato Tel�fono solo acepta digitos");
			return false;
		}

		if (verificarEmail(correo) == false) {
			return false;
		}

		return true;

	}
	
	public boolean verificarEmail(String correo) {
		// Establecer el patr�n
		Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
		// Asociar el string al patr�n
		Matcher matchCorreo = p.matcher(correo);
		// Comprobar si encaja
		if (matchCorreo.matches()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(EditarUsuario.panelCards,
					"La direcci�n de correo no es v�lida");
			return false;
		}

	}
	
	
	

	
	

}
