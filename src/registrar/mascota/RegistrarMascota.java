package registrar.mascota;


import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.*;

import java.awt.CardLayout;



public class RegistrarMascota extends JDialog {

	public static String modoRegistro= "";
	public static final String ENCONTRADO = "Encontrado";
	public static final String EXTRAVIADO = "Extraviado";
	static JPanel panelCards = new JPanel();
	static CardLayout cardlayout = new CardLayout();
	static VistaEtapaDatos etapadatos;
	static VistaEtapaImagenes etapaimagenes;
	static VistaEtapaSeleccion etapaseleccion;
	
	
	

	public RegistrarMascota() {
		setSize(600, 600);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		setLocationRelativeTo(null);
		agregarPaneles();
//		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
//		addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                System.out.println("closing...");
//                dispose();
//                instance = null;
//            }
//        });
		setResizable(false);
		setVisible(true);
	}
	
	
	
	
	
	
	
	public void agregarPaneles(){
		
		etapaseleccion = new VistaEtapaSeleccion();
		
		new ControladorEtapaSeleccion();
		panelCards.add("VistaEtapaSeleccion",etapaseleccion);
		
		
		etapadatos = new VistaEtapaDatos();
		
		new ControladorEtapaDatos(etapadatos);
		panelCards.add("VistaEtapaDatos",etapadatos);

		
		etapaimagenes = new VistaEtapaImagenes();
		
		new ControladorEtapaImagenes();
		panelCards.add("VistaEtapaImagenes",etapaimagenes);
		
		cardlayout.show(panelCards, "VistaEtapaSeleccion");
	}

	public static void main(String[] args) {
		RegistrarMascota reg = new RegistrarMascota();
		
	}
	
	public static void actualizarModo(){
		if (modoRegistro.equals(ENCONTRADO)){
			etapaimagenes.txtRecompensa.setEnabled(false);
		}else if(modoRegistro.equals(EXTRAVIADO)){
			etapaimagenes.txtRecompensa.setEnabled(true);
			
		}
	}
	

	
	public JPanel getPanelCards() {
		return panelCards;
	}

	
	public void setPanelCards(JPanel panelCards) {
		this.panelCards = panelCards;
	}

	
	

}
