package registrar.mascota;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

import fabrica.botones.FabricaBotones;

import javax.swing.filechooser.FileNameExtensionFilter;

import net.coobird.thumbnailator.Thumbnails;

public class VistaEtapaImagenes extends JPanel{

	private static VistaEtapaImagenes instance = null;
	
	public static final URL ICONO_DEFAULT = VistaEtapaImagenes.class.getResource("/recursos/framepeq.png");
	
	String[] Imagenes = new String[6]; 
	JButton btnAtras;
	JButton btnGuardar;
	JButton btnImagen0;
	JButton btnImagen1;
	JButton btnImagen2;
	JButton btnImagen3;
	JButton btnImagen4;
	JButton btnImagen5;
	JLabel lblImagenPrincipal;
	
	protected VistaEtapaImagenes() {
		
	}
	
	public static VistaEtapaImagenes getInstance() {
		if (instance == null) {	instance = new VistaEtapaImagenes(); }
		return instance;
	}
	
	
	
	public void crearVista(){
		setLayout(null);
		setSize(600, 600);
		
		btnAtras = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Atrás");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAtras.setBounds(190, 509, 131, 41);
		add(btnAtras);
		
		btnGuardar = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnGuardar.setBounds(323, 509, 131, 41);
		add(btnGuardar);
		
		JPanel panelSurround = new JPanel();
		panelSurround.setBounds(57, 5, 470, 560);
		add(panelSurround);
		panelSurround.setLayout(null);
		
		JPanel panelMiniaturas = new JPanel();
        panelMiniaturas.setBackground(Color.WHITE);
		panelMiniaturas.setBounds(44, 314, 382, 68);
		panelSurround.add(panelMiniaturas);
		
		btnImagen0 = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnImagen0.setName("0");
		panelMiniaturas.setLayout(new GridLayout(0, 6, 2, 0));
		btnImagen0.setIcon(new ImageIcon(ICONO_DEFAULT));
		panelMiniaturas.add(btnImagen0);
		
		btnImagen1 = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnImagen1.setName("1");
		panelMiniaturas.add(btnImagen1);
		
		btnImagen2 = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnImagen2.setName("2");
		panelMiniaturas.add(btnImagen2);
		
		btnImagen3 = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnImagen3.setName("3");
		panelMiniaturas.add(btnImagen3);
		
		btnImagen4 = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnImagen4.setName("4");
		panelMiniaturas.add(btnImagen4);
		
		btnImagen5 = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "");
		btnImagen5.setName("5");
		panelMiniaturas.add(btnImagen5);
		
		lblImagenPrincipal = new JLabel("ImagenPrincipal");
		lblImagenPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenPrincipal.setBounds(44, 79, 382, 207);
		panelSurround.add(lblImagenPrincipal);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 470, 560);
		panelSurround.add(lblBG);
		lblBG.setIcon(new ImageIcon(VistaEtapaImagenes.class.getResource("/recursos/RegistrarMascota2.png")));
		setFocusable(true);
		requestFocusInWindow();
	}
	
	
	
	

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.getContentPane().add(new VistaEtapaImagenes());
		f.setVisible(true);
	}
}
