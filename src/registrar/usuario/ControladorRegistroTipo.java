package registrar.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.ImageIcon;

public class ControladorRegistroTipo implements ActionListener,ItemListener{

	VistaRegistroTipo vista;
	ModeloRegistroTipo modelo;
	
	String dirImgPerfil = "";
	String casaCuna = "";
	String adoptante = "";
	
	
	public ControladorRegistroTipo(VistaRegistroTipo vista,ModeloRegistroTipo modelo) {
		this.vista = vista;
		this.modelo = modelo;
		setAcciones(this);
	}

	
	private void setAcciones(ActionListener escuchador) {
		vista.btnPerfil.addActionListener(escuchador);
		vista.checkCasaCuna.addItemListener(this);
		vista.checkAdoptante.addItemListener(this);
		vista.btnAtras.addActionListener(escuchador);
		vista.btnConfirmar.addActionListener(escuchador);
	}


	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == vista.btnAtras){
			RegistarUsuario.cardlayout.show(RegistarUsuario.panelCards, "VistaRegistroDatos");
		}
		if (source == vista.btnConfirmar){
			try {modelo.copiarImgToPerfiles();} catch (IOException e1) { e1.printStackTrace(); }
			referenciaDatos();
			
			modelo.registrarNuevoUsuario(ControladorRegistroDatos.nombre,
					ControladorRegistroDatos.pApellido,
					ControladorRegistroDatos.sApellido,
					ControladorRegistroDatos.telefono,
					ControladorRegistroDatos.cedula,
					ControladorRegistroDatos.correo,
					ControladorRegistroDatos.contrasenia, casaCuna, adoptante,
					dirImgPerfil);
			javax.swing.SwingUtilities.getWindowAncestor(vista).dispose();
			
		}
		if (source == vista.btnPerfil) {
			if (modelo.verificarImagen()){
				try {
					modelo.verificarArchivo();
					vista.btnPerfil.setIcon(new ImageIcon(modelo.obtenerImagen()));					
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
	}


	
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		
		
	}
	
	private void referenciaDatos(){
		dirImgPerfil = modelo.path;
		casaCuna = String.valueOf(vista.checkCasaCuna.isSelected());
		adoptante = String.valueOf(vista.checkAdoptante.isSelected());
	}

}
