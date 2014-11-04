/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : PrincipalNormal.java � Paquete: menu.principal � Proyecto: PetSaviors 
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Sistema para mascotas p�rdidas - encontradas
 **==================================================================================== 
 */

package menu.principal;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

import java.awt.Font;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import render.listas.RenderPrincipal;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import petFinder.vistaPetFinder;
import configuracion.Menu;



public class PrincipalNormal extends JPanel {
	public static JList listaMenu;
	public static CardLayout cardsPrincipal = new CardLayout();
	
	public PrincipalNormal() {
		setBackground(new Color(179, 209, 202));
		setSize(1280, 720);
		
		
	    setLayout(null);
		
		JLabel lblDisenadoPor = new JLabel("Dise�ado por DreamTeam APP �");
		lblDisenadoPor.setBounds(1005, 661, 158, 14);
		lblDisenadoPor.setFont(new Font("Arial", Font.PLAIN, 10));
		lblDisenadoPor.setForeground(new Color(81, 87, 85));
		add(lblDisenadoPor);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfile.setIcon(new ImageIcon(PrincipalNormal.class.getResource("/recursos/profile.png")));
		lblProfile.setText("");
		lblProfile.setBounds(1070, 98, 60, 60);
		add(lblProfile);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(PrincipalNormal.class.getResource("/recursos/LogoMenu.png")));
		lblLogo.setBounds(163, 17, 141, 141);
		add(lblLogo);
		
		JPanel panelSurround = new JPanel();
		panelSurround.setBackground(null);
		panelSurround.setBounds(149, 169, 981, 458);
		add(panelSurround);
		panelSurround.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 766, 458);
		panelSurround.add(panel);
		panel.setBackground(new Color(100, 166, 155));
		panel.setLayout(cardsPrincipal);
		vistaPetFinder petFinder = new vistaPetFinder();
		petFinder.setBounds(0,0,766,458);
		panel.add("Pet Finder", petFinder);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(765, 0, 281, 458);
		panelSurround.add(panelLista);
		panelLista.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelLista.setBackground(new Color(130, 177, 166));
	    panelLista.setLayout(new BorderLayout(0, 0));
	    
	    DefaultListModel<String> model = new DefaultListModel();
	    model.ensureCapacity(100);
	    model.addElement("  Reportes Activos");
	    model.addElement("  Mis Reportes");
	    model.addElement("  Pet Finder �");
	    ListCellRenderer renderer = new RenderPrincipal();
	    listaMenu = new JList(model);
	    listaMenu.setFont(new Font("Tahoma", Font.BOLD, 16));
	    listaMenu.setBackground(new Color(130, 177, 166));
	    listaMenu.setBorder(null);
	    listaMenu.setSelectedIndex(0);
	    listaMenu.setCellRenderer(renderer);
	    listaMenu.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}			
			@Override
			public void mouseClicked(MouseEvent e) {
				int identificador = listaMenu.getSelectedIndex();
				switch(identificador) {
					case 0:
						System.out.println("El uno");
						break;
					case 1:
						System.out.println("El dos");
						break;
					case 2:
						cardsPrincipal.show(panel, "Pet Finder");
						repaint();
						revalidate();
						break;
				}
			}
		});
	    
	    
	    JScrollPane scrollPaneLista = new JScrollPane(listaMenu);
	    scrollPaneLista.setBorder(null);
	    panelLista.add(scrollPaneLista);
	    
	    JPanel panelConfig = new JPanel();
	    panelConfig.setBackground(null);
	    panelConfig.setBounds(159, 638, 24, 22);
	    add(panelConfig);
	    panelConfig.setLayout(null);
	    
	    JLabel lblConfig = new JLabel("");
	    lblConfig.setBounds(0, 0, 24, 22);
	    panelConfig.add(lblConfig);
	    lblConfig.setIcon(new ImageIcon(PrincipalNormal.class.getResource("/recursos/Configuracion.png")));
	    lblConfig.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) { if (e.getButton()==MouseEvent.BUTTON1)new Menu(panelConfig); }
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	    
	    JButton btnAtras = new JButton("");
	    btnAtras.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		vistaPetFinder.cardsPanel.show(vistaPetFinder.contenedor, "PetFinder");
	    	}
	    });
	    btnAtras.setIcon(new ImageIcon(PrincipalNormal.class.getResource("/recursos/BotonAtras.png")));
	    btnAtras.setBounds(58, 169, 81, 81);
	    btnAtras.setOpaque(false);
	    btnAtras.setContentAreaFilled(false);
	    btnAtras.setBorder(null);
	    add(btnAtras);
	    lblConfig.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) { if (e.getButton()==MouseEvent.BUTTON1)new Menu(panelConfig); }
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
	    
	}

	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1280, 720);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(new PrincipalNormal());
		
		f.setVisible(true);

	}
}

