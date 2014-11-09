package registrar.mascota;

import javax.swing.*;
import java.awt.CardLayout;

public class RegistrarMascota extends JDialog{

	private static final long serialVersionUID = 1L;
	private static RegistrarMascota instance = null;
	public static String modoRegistro= "";
	public static final String ENCONTRADO = "Encontrado";
	public static final String EXTRAVIADO = "Extraviado";
	JPanel panelCards = new JPanel();
	CardLayout cardlayout = new CardLayout();
	protected RegistrarMascota() {
		
	}
	
	public static RegistrarMascota getInstance() {
		if (instance == null) {	instance = new RegistrarMascota(); }
		return instance;
	}
	
	public void crearDialog (){
		setSize(600, 600);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		setLocationRelativeTo(null);
		agregarPaneles();
		
		setResizable(false);
		setVisible(true);
	}
	
	public void agregarPaneles(){
		
		VistaEtapaSeleccion etapaseleccion = VistaEtapaSeleccion.getInstance();
		etapaseleccion.crearVista();
		new ControladorEtapaSeleccion();
		panelCards.add("VistaEtapaSeleccion",etapaseleccion);
		
		
		VistaEtapaDatos etapadatos = VistaEtapaDatos.getInstance();
		etapadatos.crearVista();
		new ControladorEtapaDatos();
		panelCards.add("VistaEtapaDatos",etapadatos);

		
		VistaEtapaImagenes etapaimagenes = VistaEtapaImagenes.getInstance();
		etapaimagenes.crearVista();
		new ControladorEtapaImagenes();
		panelCards.add("VistaEtapaImagenes",etapaimagenes);
		
		cardlayout.show(panelCards, "VistaEtapaSeleccion");
	}

	public static void main(String[] args) {
		getInstance().crearDialog();
	}
	
	public static void actualizarModo(){
		if (modoRegistro.equals(ENCONTRADO)){
			VistaEtapaImagenes.getInstance().txtRecompensa.setEnabled(false);
		}else if(modoRegistro.equals(EXTRAVIADO)){
			VistaEtapaImagenes.getInstance().txtRecompensa.setEnabled(true);
		}
	}

	
	public JPanel getPanelCards() {
		return panelCards;
	}

	
	public void setPanelCards(JPanel panelCards) {
		this.panelCards = panelCards;
	}

}
