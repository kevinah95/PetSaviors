package petFinder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.GridBagLayout;

@SuppressWarnings("serial")
public class vistaPetFinder extends JPanel{
	public static JPanel contenedor = new JPanel(); 
	private JPanel ventanaPetFinder = new JPanel();
	public static CardLayout cardsPanel = new CardLayout();
	
	JButton btnMisMascotas = new JButton("");
	JButton btnPorCategoria = new JButton("");
	
	public vistaPetFinder() {
		setSize(766, 458);
		contenedor.setSize(766, 458);
		contenedor.setLayout(cardsPanel);
		
		crearVentanaPetFinder();
		insertarPaneles();

		
		contenedor.setVisible(true);
		setLayout(new CardLayout(0, 0));
		add(contenedor, "name_43601750989967");	
	}
	
	public void crearVentanaPetFinder() {
		
		ventanaPetFinder.setBackground(new Color(110, 166,  155));
		ventanaPetFinder.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnMisMascotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardsPanel.show(contenedor, "Mis Mascotas");
			}
		});
		btnMisMascotas.setIcon(new ImageIcon(vistaPetFinder.class.getResource("/recursos/BotonMisMascotas.png")));
		btnMisMascotas.setOpaque(false);
		btnMisMascotas.setContentAreaFilled(false);
		btnMisMascotas.setBorder(null);
		
		btnPorCategoria.setIcon(new ImageIcon(vistaPetFinder.class.getResource("/recursos/BotonPorCategoria.png")));
		btnPorCategoria.setContentAreaFilled(false);
		btnPorCategoria.setBorder(null);
		
		ventanaPetFinder.add(btnMisMascotas);
		ventanaPetFinder.add(btnPorCategoria);
		
		ventanaPetFinder.setVisible(true);
		
	}
	
	public void insertarPaneles() {
		
		contenedor.add("PetFinder", ventanaPetFinder);
		
		VentanaMisMascotas misMascotas = new VentanaMisMascotas();
		contenedor.add("Mis Mascotas", misMascotas);
		
		//cardsPanel.show(contenedor, "Mis Mascotas");
	}
		
}
