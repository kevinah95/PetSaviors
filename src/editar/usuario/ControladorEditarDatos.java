package editar.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEditarDatos implements ActionListener{

	public static VistaEditarDatos vista = null;
	ModeloEditarDatos modelo = null;
	
	public static String nombre = "";
	public static String pApellido = "";
	public static String sApellido = "";
	public static String telefono = "";
	public static String cedula = "";
	public static String correo = "";
	public static String contrasenia = "";
	
	public ControladorEditarDatos(VistaEditarDatos vista, ModeloEditarDatos modelo) {
		this.vista = vista;
		this.modelo = modelo;
		setAcciones(this);
	}
	
	public void setAcciones(ActionListener escuchador){
		vista.btnSiguiente.addActionListener(escuchador);
		vista.btnCancelar.addActionListener(escuchador);
	}

	
	public void actionPerformed(ActionEvent e) {
		Object btnTemp = e.getSource();
		if (btnTemp == vista.btnCancelar){
			javax.swing.SwingUtilities.getWindowAncestor(vista).dispose();
		}
		
		if(btnTemp == vista.btnSiguiente){
			referenciaDatos();
			boolean flagverificar = modelo.verificarDatos( telefono, correo);
			if (flagverificar){
				
				EditarUsuario.cardlayout.show(EditarUsuario.panelCards, "VistaEditarTipo");
				
			}
		}
		
	}
	
	public void limpiarTextos(){
		vista.txtNombre.setText("");
		vista.txtPApellido.setText("");
		vista.txtSApellido.setText("");
		vista.txtTelefono.setText("");
		vista.txtCorreo.setText("");
		vista.txtContrasenia.setText("");
	}
	
	public void referenciaDatos() {
		nombre = vista.txtNombre.getText();
		pApellido = vista.txtPApellido.getText();
		sApellido = vista.txtSApellido.getText();
		telefono = vista.txtTelefono.getText();
		correo = vista.txtCorreo.getText();
		contrasenia = vista.txtContrasenia.getText();
	}
	
	

}
