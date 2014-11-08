package registrar.mascota;

import javax.swing.JDialog;
import javax.swing.JPanel;

import java.awt.CardLayout;

import logicaExterna.Usuarios;




public class Registrar extends JDialog{

	private static Registrar instance = null;
	JPanel panelCards = new JPanel();
	CardLayout cardlayout = new CardLayout();
	protected Registrar() {
		
	}
	
	public static Registrar getInstance() {
		if (instance == null) {	instance = new Registrar(); }
		return instance;
	}
	
	public void crearDialog (){
		setSize(600, 600);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		
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
