package registrar.mascota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEtapaSeleccion implements ActionListener{

	VistaEtapaSeleccion vista = null;
	ModeloEtapaSeleccion modelo = null;
	
	public ControladorEtapaSeleccion() {
		this.modelo = ModeloEtapaSeleccion.getInstance();
		this.vista = VistaEtapaSeleccion.getInstance();
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
			RegistrarMascota.getInstance().dispose();
		}
		
		if (source == vista.btnMascotaEncontrada) {
			VistaEtapaImagenes.getInstance().lblLugar.setText("Lugar donde la encontró");
			RegistrarMascota.modoRegistro = RegistrarMascota.ENCONTRADO;
			RegistrarMascota.actualizarModo();
			RegistrarMascota.getInstance().cardlayout.show(RegistrarMascota.getInstance().panelCards,"VistaEtapaDatos");
			vista.getParent().repaint();
			vista.getParent().revalidate();
		}
		
		if (source == vista.btnMascotaPerdida) {
			VistaEtapaImagenes.getInstance().lblLugar.setText("Lugar donde se extravió");
			RegistrarMascota.modoRegistro = RegistrarMascota.EXTRAVIADO;
			RegistrarMascota.actualizarModo();
			RegistrarMascota.getInstance().cardlayout.show(RegistrarMascota.getInstance().panelCards,"VistaEtapaDatos");
			vista.getParent().repaint();
			vista.getParent().revalidate();
		}
		
	}

}
