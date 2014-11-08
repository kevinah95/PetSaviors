package login;

import individuos.Individuo;

import java.util.function.Predicate;

import javax.swing.JOptionPane;

import logicaExterna.Usuarios;


public class ModeloLogIn {

	private static ModeloLogIn instance = null;
	
	public boolean ACCESO_CONCEDIDO = false;
	
	Usuarios usuarios = Usuarios.getInstance();
	protected ModeloLogIn() {
		
	}
	
	public static ModeloLogIn getInstance() {
		if (instance == null) {	instance = new ModeloLogIn(); }
		return instance;
	}
	
	
	
	public void verificarDatos(Predicate<Individuo> predicadoFull){
		ACCESO_CONCEDIDO = false;
		if (usuarios.usuariosRegistrados == null){
			JOptionPane.showMessageDialog(null, "No hay usuarios registrados en el sistema");
			
		}else{
			usuarios.usuariosRegistrados.stream().filter(predicadoFull).forEach(p->concederAcceso());
		}
	}
	
	private void concederAcceso(){
		ACCESO_CONCEDIDO = true;
	}
	
	
	
	
	

}
