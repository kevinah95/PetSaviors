package registrar.mascota;

import javax.swing.JDialog;
import javax.swing.JPanel;


import java.awt.CardLayout;




public class RegistrarMascota extends JDialog{

	private static RegistrarMascota instance = null;
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
		
		VistaEtapaDatos etapadatos = VistaEtapaDatos.getInstance();
		etapadatos.crearVista();
		new ControladorEtapaDatos();
		panelCards.add("VistaEtapaDatos",etapadatos);

		
		VistaEtapaImagenes etapaimagenes = VistaEtapaImagenes.getInstance();
		etapaimagenes.crearVista();
		new ControladorEtapaImagenes();
		panelCards.add("VistaEtapaImagenes",etapaimagenes);
		
		cardlayout.show(panelCards, "VistaEtapaDatos");
	}

	public static void main(String[] args) {
		getInstance().crearDialog();
	}

	/**
	 * @return the panelCards
	 */
	public JPanel getPanelCards() {
		return panelCards;
	}

	/**
	 * @param panelCards the panelCards to set
	 */
	public void setPanelCards(JPanel panelCards) {
		this.panelCards = panelCards;
	}

}
