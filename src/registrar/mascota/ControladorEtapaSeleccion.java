package registrar.mascota;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class ControladorEtapaSeleccion implements ActionListener{

	VistaEtapaSeleccion vista = null;
	ModeloEtapaSeleccion modelo = null;
	
	public ControladorEtapaSeleccion(VistaEtapaSeleccion vista, ModeloEtapaSeleccion modelo) {
		this.modelo = modelo;
		this.vista = vista;
		setAcciones(this);
	}

	
	private void setAcciones(ActionListener escuchador) {
		vista.btnMascotaEncontrada.addActionListener(escuchador);
		vista.btnMascotaPerdida.addActionListener(escuchador);
		vista.btnCancelar.addActionListener(escuchador);
	}


	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == vista.btnCancelar) {
			javax.swing.SwingUtilities.getWindowAncestor(vista).dispose();
		}
		
		if (source == vista.btnMascotaEncontrada) {
			RegistrarMascota.vistaetapaimagenes.lblLugar.setText("Lugar donde la encontró");
			RegistrarMascota.modoRegistro = RegistrarMascota.ENCONTRADO;
			RegistrarMascota.actualizarModo();
			RegistrarMascota.cardlayout.show(RegistrarMascota.panelCards,"VistaEtapaDatos");
			vista.getParent().repaint();
			vista.getParent().revalidate();
		}
		
		if (source == vista.btnMascotaPerdida) {
			RegistrarMascota.vistaetapaimagenes.lblLugar.setText("Lugar donde se extravió");
			RegistrarMascota.modoRegistro = RegistrarMascota.EXTRAVIADO;
			RegistrarMascota.actualizarModo();
			RegistrarMascota.cardlayout.show(RegistrarMascota.panelCards,"VistaEtapaDatos");
			vista.getParent().repaint();
			vista.getParent().revalidate();
		}
		
	}

}
