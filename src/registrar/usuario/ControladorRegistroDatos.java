package registrar.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ControladorRegistroDatos implements ActionListener{

	public static VistaRegistroDatos vista = null;
	ModeloRegistroDatos modelo = null;
	
	public static String nombre = "";
	public static String pApellido = "";
	public static String sApellido = "";
	public static String telefono = "";
	public static String cedula = "";
	public static String correo = "";
	public static String contrasenia = "";
	
	public ControladorRegistroDatos(VistaRegistroDatos vista, ModeloRegistroDatos modelo) {
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
			boolean flagverificar = modelo.verificarDatos(nombre, pApellido,
					sApellido, telefono, cedula, correo, contrasenia);
			if (flagverificar){
				
				RegistarUsuario.cardlayout.show(RegistarUsuario.panelCards, "VistaRegistroTipo");
				
			}
		}
		
	}
	
	public void limpiarTextos(){
		vista.txtNombre.setText("");
		vista.txtPApellido.setText("");
		vista.txtSApellido.setText("");
		vista.txtTelefono.setText("");
		vista.txtCedula.setText("");
		vista.txtCorreo.setText("");
		vista.txtContrasenia.setText("");
	}
	
	public void referenciaDatos() {
		nombre = vista.txtNombre.getText();
		pApellido = vista.txtPApellido.getText();
		sApellido = vista.txtSApellido.getText();
		telefono = vista.txtTelefono.getText();
		cedula = vista.txtCedula.getText();
		correo = vista.txtCorreo.getText();
		contrasenia = vista.txtContrasenia.getText();
	}
	
	

}
