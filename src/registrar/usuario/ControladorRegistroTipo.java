package registrar.usuario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ControladorRegistroTipo implements ActionListener,ItemListener{

	VistaRegistroTipo vista;
	ModeloRegistroTipo modelo;
	
	String imgPerfil = "";
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
			
		}
		if (source == vista.btnPerfil) {
			
		}
		
	}


	
	public void itemStateChanged(ItemEvent e) {
		Object source = e.getItemSelectable();
		
		
	}

}
