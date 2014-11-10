package editar.usuario;

import java.awt.CardLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;

public class EditarUsuario extends JDialog {
	
	static JPanel panelCards = new JPanel();
	static CardLayout cardlayout = new CardLayout();
	
	public EditarUsuario() {
		setSize(600, 600);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		setLocationRelativeTo(null);
		agregarPaneles();
		setModal (true);
		setAlwaysOnTop(true);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setVisible(true);
	}
	
	public void agregarPaneles(){
		VistaEditarDatos vistaEditarDatos = new VistaEditarDatos();
		ModeloEditarDatos modeloEditarDatos = new ModeloEditarDatos();
		new ControladorEditarDatos(vistaEditarDatos, modeloEditarDatos);
		panelCards.add(vistaEditarDatos,"VistaEditarDatos");
		
		VistaEditarTipo vistaEditarTipo = new VistaEditarTipo();
		ModeloEditarTipo modeloeditartipo = new ModeloEditarTipo();
		new ControladorEditarTipo(vistaEditarTipo, modeloeditartipo);
		panelCards.add(vistaEditarTipo,"VistaEditarTipo");
		
		
		cardlayout.show(panelCards, "VistaEditarDatos");
	}
	
	

	public static void main(String[] args) {
		EditarUsuario reg = new EditarUsuario();

	}

}
