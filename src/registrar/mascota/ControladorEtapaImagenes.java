package registrar.mascota;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


import java.io.IOException;

import javax.swing.ImageIcon;

import petFinder.VentanaMisMascotas;
import logicaExterna.Mascotas;
import menu.principal.VistaPrincipal;
import fabrica.botones.JButtonTransparente;

public class ControladorEtapaImagenes implements ActionListener, MouseListener,
		PropertyChangeListener {

	ModeloEtapaImagenes modelo = null;
	VistaEtapaImagenes vista = null;
	public static JButtonTransparente btnTemp = null;
	private boolean inicializado=false;

	public ControladorEtapaImagenes(VistaEtapaImagenes vista,ModeloEtapaImagenes modelo) {
		this.modelo = modelo;
		this.vista = vista;
		setAcciones(this);
	}
	
	private void setAcciones(ActionListener escuchador) {
		vista.btnAtras.addActionListener(escuchador);
		vista.btnGuardar.addActionListener(escuchador);

		vista.btnImagen0.addMouseListener(this);
		vista.btnImagen1.addMouseListener(this);
		vista.btnImagen2.addMouseListener(this);
		vista.btnImagen3.addMouseListener(this);
		vista.btnImagen4.addMouseListener(this);
		vista.btnImagen5.addMouseListener(this);

		vista.txtRecompensa.addPropertyChangeListener("value", this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.btnAtras) {
			RegistrarMascota.cardlayout.show(
					RegistrarMascota.panelCards,
					"VistaEtapaDatos");
			vista.limpiarDatos();
		}

		if (e.getSource() == vista.btnGuardar) {
			if (modelo.verificarLugar(vista.txtLugar.getText())) {
				joinDatos();
				try {
					modelo.copiarTempToImagenes();
				} catch (IOException e1) { e1.printStackTrace(); }
				modelo.cargarImagenes();
				javax.swing.SwingUtilities.getWindowAncestor(vista).dispose();
			}
			inicializado = false;
			modelo.limpiarDirTemporal();
			Mascotas.getInstance().actualizarJson();
			

		}
	}

	private void joinDatos(){
		VistaEtapaDatos vistaDatos = RegistrarMascota.vistaetapadatos;
		String sexo = null;
		if (vistaDatos.rdbtnMacho.isSelected()) {
			sexo = "Macho";
		} else {
			sexo = "Hembra";
		}
		String raza = null;
		if (vistaDatos.cbRaza.getSelectedItem() == null) {
			raza = "";
		} else {
			raza = vistaDatos.cbRaza.getSelectedItem().toString();
		}
		String especie = null;
		if (vistaDatos.cbEspecie.getSelectedItem() == null) {
			especie = "";
		} else {
			especie = vistaDatos.cbEspecie.getSelectedItem().toString();
		}
		
		modelo.cargarDatos(RegistrarMascota.modoRegistro,
				vistaDatos.txtNombre.getText(), vistaDatos.txtChip.getText(),
				vistaDatos.cbColor.getSelectedItem().toString(), especie, raza,
				sexo, vistaDatos.txtDescripcion.getText(),
				vista.txtLugar.getText(),
				String.valueOf(vista.txtRecompensa.getValue()));
	}
	
	
	
	

	
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON3) {
			btnTemp = (JButtonTransparente) e.getSource();
			if (modelo.verificarImagen()) {
				inicializarIndice();
				try {
					btnTemp.setIcon(new ImageIcon(modelo.obtenerImagen(btnTemp.getIndiceBoton())));
					seleccionBotonDefault();
					btnTemp.setDirImagen(modelo.path);
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo
							.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		} else if (e.getButton() == MouseEvent.BUTTON1) {
			btnTemp = (JButtonTransparente) e.getSource();
			if (!btnTemp.getDirImagen().equals("")) {
				try {
					seleccionarImagenPrincipal();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
	public void propertyChange(PropertyChangeEvent e) {
		Object source = e.getSource();
		if (source == vista.txtRecompensa) {
			vista.txtRecompensa.getValue();
		}

	}
	
	public void inicializarIndice(){
		if(btnTemp==vista.btnImagen0 && inicializado == false){
			modelo.partirDe = modelo.getIndice();
			inicializado = true;
		}
	}
	
	public void seleccionBotonDefault(){
		if(btnTemp==vista.btnImagen0 && vista.btnImagen1.getIcon()== null){
			vista.btnImagen1.setIcon(new ImageIcon(VistaEtapaImagenes.ICONO_DEFAULT));
			vista.btnImagen1.setDirImagen("");
		}else if(btnTemp==vista.btnImagen1 && vista.btnImagen2.getIcon()== null){
			vista.btnImagen2.setIcon(new ImageIcon(VistaEtapaImagenes.ICONO_DEFAULT));
			vista.btnImagen1.setDirImagen("");
		}else if(btnTemp==vista.btnImagen2 && vista.btnImagen3.getIcon()== null){
			vista.btnImagen3.setIcon(new ImageIcon(VistaEtapaImagenes.ICONO_DEFAULT));
			vista.btnImagen1.setDirImagen("");
		}else if(btnTemp==vista.btnImagen3 && vista.btnImagen4.getIcon()== null){
			vista.btnImagen4.setIcon(new ImageIcon(VistaEtapaImagenes.ICONO_DEFAULT));
			vista.btnImagen1.setDirImagen("");
		}else if(btnTemp==vista.btnImagen4 && vista.btnImagen5.getIcon()== null){
			vista.btnImagen5.setIcon(new ImageIcon(VistaEtapaImagenes.ICONO_DEFAULT));
			vista.btnImagen1.setDirImagen("");
		}
	}

	public void seleccionarImagenPrincipal() throws IOException {
		if (btnTemp.getDirImagen() != null) {
			modelo.path = btnTemp.getDirImagen();
			vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo
					.obtenerImagenPrincipal()));
		}
	}

}
