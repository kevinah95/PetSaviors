package registrar.mascota;


import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.CardLayout;

public class RegistrarMascota extends JDialog {

	public static String modoRegistro = "";
	public static final String ENCONTRADO = "Encontrado";
	public static final String EXTRAVIADO = "Extraviado";
	static JPanel panelCards = new JPanel();
	static CardLayout cardlayout = new CardLayout();
	
	public static VistaEtapaImagenes vistaetapaimagenes;
	public static VistaEtapaDatos vistaetapadatos;

	public RegistrarMascota() {
		setSize(600, 600);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		setLocationRelativeTo(null);
		agregarPaneles();
		setModal(true);
		setAlwaysOnTop(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setVisible(true);
	}

	public void agregarPaneles() {

		
		ModeloEtapaSeleccion modeloetapaseleccion = new ModeloEtapaSeleccion();
		VistaEtapaSeleccion etapaseleccion = new VistaEtapaSeleccion();
		new ControladorEtapaSeleccion(etapaseleccion,modeloetapaseleccion);
		panelCards.add("VistaEtapaSeleccion", etapaseleccion);

		vistaetapadatos = new VistaEtapaDatos();
		ModeloEtapaDatos modeloetapadatos = new ModeloEtapaDatos();
		new ControladorEtapaDatos(vistaetapadatos,modeloetapadatos);
		panelCards.add("VistaEtapaDatos", vistaetapadatos);

		ModeloEtapaImagenes modeloetapaimagenes = new ModeloEtapaImagenes();
		vistaetapaimagenes = new VistaEtapaImagenes();
		new ControladorEtapaImagenes(vistaetapaimagenes,modeloetapaimagenes);
		panelCards.add("VistaEtapaImagenes", vistaetapaimagenes);

		cardlayout.show(panelCards, "VistaEtapaSeleccion");
	}

	public static void main(String[] args) {
		RegistrarMascota reg = new RegistrarMascota();

	}

	public static void actualizarModo() {
		if (modoRegistro.equals(ENCONTRADO)) {
			vistaetapaimagenes.txtRecompensa.setEnabled(false);
		} else if (modoRegistro.equals(EXTRAVIADO)) {
			vistaetapaimagenes.txtRecompensa.setEnabled(true);

		}
	}
}
