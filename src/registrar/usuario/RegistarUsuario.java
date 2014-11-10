package registrar.usuario;

import java.awt.CardLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class RegistarUsuario extends JDialog {
	
	static JPanel panelCards = new JPanel();
	static CardLayout cardlayout = new CardLayout();
	
	

	public RegistarUsuario() {
		setSize(600, 600);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		setLocationRelativeTo(null);
		agregarPaneles();
		setModal (true);
		setAlwaysOnTop(true);
		setModalityType (ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setVisible(true);
	}
	
	public void agregarPaneles(){
		VistaRegistroDatos vistaRegDatos = new VistaRegistroDatos();
		ModeloRegistroDatos modeloRegDatos = new ModeloRegistroDatos();
		new ControladorRegistroDatos(vistaRegDatos, modeloRegDatos);
		panelCards.add(vistaRegDatos,"VistaRegistroDatos");
		
		VistaRegistroTipo vistaRegTipo = new VistaRegistroTipo();
		ModeloRegistroTipo modeloRegTipo = new ModeloRegistroTipo();
		new ControladorRegistroTipo(vistaRegTipo, modeloRegTipo);
		panelCards.add(vistaRegTipo,"VistaRegistroTipo");
		
		
		cardlayout.show(panelCards, "VistaRegistroDatos");
	}
	
	

	public static void main(String[] args) {
		RegistarUsuario reg = new RegistarUsuario();

	}

}
