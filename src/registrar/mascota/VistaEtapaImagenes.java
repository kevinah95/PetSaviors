package registrar.mascota;

import java.awt.*;
import java.net.URL;
import java.text.NumberFormat;
import javax.swing.*;
import fabrica.botones.*;

public class VistaEtapaImagenes extends JPanel{
	private static final long serialVersionUID = 1L;

	
	
	public static final URL ICONO_DEFAULT = VistaEtapaImagenes.class.getResource("/recursos/framepeq.png");
	
	String[] Imagenes = new String[6]; 
	JButton btnAtras;
	JButton btnGuardar;
	JButtonTransparente btnImagen0;
	JButtonTransparente btnImagen1;
	JButtonTransparente btnImagen2;
	JButtonTransparente btnImagen3;
	JButtonTransparente btnImagen4;
	JButtonTransparente btnImagen5;
	JLabel lblImagenPrincipal;
	JLabel lblLugar;
	JTextField txtLugar;
	JFormattedTextField txtRecompensa;
	NumberFormat formatoCantidad = NumberFormat.getCurrencyInstance();
	
	final static Font fontTextos = new Font("Segoe UI", Font.BOLD, 13);
	
	
	public VistaEtapaImagenes() {
		setLayout(null);
		setSize(600, 600);
		
		JPanel panelSurround = new JPanel();
		panelSurround.setBounds(57, 5, 470, 560);
		add(panelSurround);
		panelSurround.setLayout(null);
		
		btnAtras = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Atrás");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnAtras.setBounds(130, 503, 131, 41);
		panelSurround.add(btnAtras);
		
		btnGuardar = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Guardar");
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnGuardar.setBounds(264, 503, 131, 41);
		panelSurround.add(btnGuardar);
		
		
		
		JPanel panelMiniaturas = new JPanel();
        panelMiniaturas.setBackground(Color.WHITE);
		panelMiniaturas.setBounds(44, 314, 382, 68);
		panelSurround.add(panelMiniaturas);
		
		btnImagen0 = new JButtonTransparente("");
		btnImagen0.setName("0");
		panelMiniaturas.setLayout(new GridLayout(0, 6, 2, 0));
		btnImagen0.setIcon(new ImageIcon(ICONO_DEFAULT));
		panelMiniaturas.add(btnImagen0);
		
		btnImagen1 = new JButtonTransparente("");
		btnImagen1.setName("1");
		panelMiniaturas.add(btnImagen1);
		
		btnImagen2 = new JButtonTransparente("");
		btnImagen2.setName("2");
		panelMiniaturas.add(btnImagen2);
		
		btnImagen3 = new JButtonTransparente("");
		btnImagen3.setName("3");
		panelMiniaturas.add(btnImagen3);
		
		btnImagen4 = new JButtonTransparente("");
		btnImagen4.setName("4");
		panelMiniaturas.add(btnImagen4);
		
		btnImagen5 = new JButtonTransparente("");
		btnImagen5.setName("5");
		panelMiniaturas.add(btnImagen5);
		
		lblLugar = new JLabel("Lugar");
		lblLugar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLugar.setForeground(new Color(27,39,51));
		lblLugar.setBounds(44, 391, 177, 17);
		panelSurround.add(lblLugar);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(44, 416, 177, 30);
		panelSurround.add(txtLugar);
		txtLugar.setOpaque(false);
		txtLugar.setForeground(new Color(27, 39, 51));
		txtLugar.setFont(fontTextos);
		txtLugar.setColumns(10);
		txtLugar.setBorder(null);
		
		txtRecompensa = new JFormattedTextField(formatoCantidad);
		txtRecompensa.setValue(new Double(0.0));
		txtRecompensa.setOpaque(false);
		txtRecompensa.setForeground(new Color(27, 39, 51));
		txtRecompensa.setFont(fontTextos);
		txtRecompensa.setColumns(10);
		txtRecompensa.setBorder(null);
		txtRecompensa.setBounds(248, 416, 177, 30);
		panelSurround.add(txtRecompensa);
		
		lblImagenPrincipal = new JLabel("Imagen Principal");
		lblImagenPrincipal.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagenPrincipal.setForeground(new Color(27, 39, 51));
		lblImagenPrincipal.setFont(fontTextos);
		lblImagenPrincipal.setBounds(44, 79, 382, 207);
		panelSurround.add(lblImagenPrincipal);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 470, 560);
		panelSurround.add(lblBG);
		lblBG.setIcon(new ImageIcon(VistaEtapaImagenes.class.getResource("/recursos/RegistrarMascota2.png")));
		setFocusable(true);
		requestFocusInWindow();
	}

	
	public void limpiarDatos(){
		btnImagen0.setDirImagen("");
		btnImagen1.setDirImagen("");
		btnImagen2.setDirImagen("");
		btnImagen3.setDirImagen("");
		btnImagen4.setDirImagen("");
		btnImagen5.setDirImagen("");
		btnImagen0.setIcon(new ImageIcon(ICONO_DEFAULT));
		btnImagen1.setIcon(null);
		btnImagen2.setIcon(null);
		btnImagen3.setIcon(null);
		btnImagen4.setIcon(null);
		btnImagen5.setIcon(null);
		lblImagenPrincipal.setIcon(null);
		lblImagenPrincipal.setText("");
		txtLugar.setText("");
		txtRecompensa.setValue(new Double(0.0));
	}
}
