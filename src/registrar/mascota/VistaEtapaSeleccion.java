package registrar.mascota;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.plaf.BorderUIResource;

import fabrica.botones.FabricaBotones;

public class VistaEtapaSeleccion extends JPanel{
	
	private static VistaEtapaSeleccion instance = null;
	
	JButton btnMascotaPerdida;
	JButton btnMascotaEncontrada;
	JButton btnSiguiente;
	JButton btnCancelar;

	protected VistaEtapaSeleccion() {
		
	}
	
	public static VistaEtapaSeleccion getInstance() {
		if (instance == null) {	instance = new VistaEtapaSeleccion(); }
		return instance;
	}
	
	public void crearVista(){
		
		setLayout(null);
		JPanel panelSurround = new JPanel();
		panelSurround.setBounds(57, 5, 470, 560);
		add(panelSurround);
		panelSurround.setLayout(null);
		
		btnMascotaPerdida = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnMascotaPerdida.setBounds(31, 176, 176, 153);
		
		panelSurround.add(btnMascotaPerdida);
		
		btnMascotaEncontrada = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnMascotaEncontrada.setBounds(262, 176, 176, 153);
		panelSurround.add(btnMascotaEncontrada);
		
		btnSiguiente = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Siguiente");
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setEnabled(false);
		btnSiguiente.setBounds(264, 503, 131, 41);
		panelSurround.add(btnSiguiente);
		
		btnCancelar = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(130, 503, 131, 41);
		panelSurround.add(btnCancelar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 470, 560);
		panelSurround.add(lblBG);
		lblBG.setIcon(new ImageIcon(VistaEtapaSeleccion.class.getResource("/recursos/RegistrarMascota3.png")));
	}
}
