package registrar.usuario;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;

import fabrica.botones.JButtonTransparente;

public class VistaRegistroTipo extends JPanel{

	final static Font fontTextos = new Font("Segoe UI", Font.BOLD, 14);
	JButtonTransparente btnPerfil;
	JCheckBox checkCasaCuna;
	JCheckBox checkAdoptante;
	JButtonTransparente btnAtras;
	JButtonTransparente btnConfirmar;
	JPanel panelPerfil;
	
	public VistaRegistroTipo() {
		setBackground(new Color(179, 209, 202));
		setSize(600, 600);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(65, 40, 470, 520);
		add(panel);
		panel.setLayout(null);
		
		panelPerfil = new JPanel();
		panelPerfil.setBounds(175, 63, 120, 120);
		panel.add(panelPerfil);
		panelPerfil.setLayout(null);
		
		
		
		btnPerfil = new JButtonTransparente("");
		btnPerfil.setIcon(new ImageIcon(VistaRegistroTipo.class.getResource("/recursos/profileEncima3.png")));
		btnPerfil.setBounds(0, 0, 120, 120);
		btnPerfil.setDirImagen("/recursos/profileEncima3.png");
		panelPerfil.add(btnPerfil);
		
		checkCasaCuna = new JCheckBox("Casa Cuna");
		checkCasaCuna.setBounds(95, 367, 97, 23);
		checkCasaCuna.setFont(fontTextos);
		checkCasaCuna.setForeground(new Color(51,51,51));
		panel.add(checkCasaCuna);
		
		checkAdoptante = new JCheckBox("Adoptante");
		checkAdoptante.setForeground(new Color(51, 51, 51));
		checkAdoptante.setFont(new Font("Segoe UI", Font.BOLD, 14));
		checkAdoptante.setBounds(282, 369, 97, 23);
		panel.add(checkAdoptante);
		
		btnAtras = new JButtonTransparente("Atrás");
		btnAtras.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAtras.setBounds(129, 458, 130, 39);
		panel.add(btnAtras);
		
		btnConfirmar = new JButtonTransparente("Confirmar");
		btnConfirmar.setForeground(new Color(240, 240, 240));
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnConfirmar.setBounds(269, 458, 130, 39);
		panel.add(btnConfirmar);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 470, 520);
		panel.add(lblBG);
		lblBG.setIcon(new ImageIcon(VistaRegistroTipo.class.getResource("/recursos/TipoUsuario.png")));
	}
}
