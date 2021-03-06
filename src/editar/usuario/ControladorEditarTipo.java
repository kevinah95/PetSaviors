package editar.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.ImageIcon;

import registrar.usuario.RegistarUsuario;

public class ControladorEditarTipo implements ActionListener,ItemListener{

	VistaEditarTipo vista;
	ModeloEditarTipo modelo;
	
	String dirImgPerfil = "";
	boolean casaCuna = false;
	boolean adoptante = false;
	
	
	public ControladorEditarTipo(VistaEditarTipo vista,ModeloEditarTipo modelo) {
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
			EditarUsuario.cardlayout.show(EditarUsuario.panelCards, "VistaEditarDatos");
		}
		if (source == vista.btnConfirmar){
			referenciaImagen();
			if(!dirImgPerfil.trim().isEmpty()){
				try {modelo.copiarImgToPerfiles();} catch (IOException e1) { e1.printStackTrace(); }
				
			}
			
			referenciaDatos();
			
			modelo.registrarNuevoUsuario(ControladorEditarDatos.nombre,
					ControladorEditarDatos.pApellido,
					ControladorEditarDatos.sApellido,
					ControladorEditarDatos.telefono,
					ControladorEditarDatos.cedula,
					ControladorEditarDatos.correo,
					ControladorEditarDatos.contrasenia, casaCuna, adoptante,
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
	private void referenciaImagen(){
		dirImgPerfil = modelo.path;
	}
	
	private void referenciaDatos(){
		casaCuna = vista.checkCasaCuna.isSelected();
		adoptante = vista.checkAdoptante.isSelected();
	}

}
