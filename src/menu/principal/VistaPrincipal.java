/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : VistaPrincipal.java » Paquete: menu.principal » Proyecto: PetSaviors 
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Sistema para mascotas pérdidas - encontradas
 **==================================================================================== 
 */

package menu.principal;

import individuos.Individuo;

import javax.swing.*;

import java.awt.*;

import javax.swing.border.*;

import java.awt.event.*;

import registrar.mascota.VistaEtapaDatos;
import render.listas.RenderPrincipal;
import petFinder.vistaPetFinder;
import configuracion.Menu;

public class VistaPrincipal extends JPanel {
	
	
	public static JList listaMenu;
	public static JPanel panelImagenAnimal = new JPanel();
	public static CardLayout cardsPrincipal = new CardLayout();
	
	/**
	 * TODO Cambiar Individuo a private
	 */
	private Individuo usuario= null;
	
	private static VistaPrincipal instance = null;
	
	protected VistaPrincipal() {
		
	}
	
	public static VistaPrincipal getInstance() {
		if (instance == null) {	instance = new VistaPrincipal(); }
		return instance;
	}

	public void crearVista(){
		setBackground(new Color(179, 209, 202));
		setSize(1280, 720);
	    setLayout(null);
		
		JLabel lblDisenadoPor = new JLabel("Diseñado por DreamTeam APP ®");
		lblDisenadoPor.setBounds(1005, 661, 158, 14);
		lblDisenadoPor.setFont(new Font("Arial", Font.PLAIN, 10));
		lblDisenadoPor.setForeground(new Color(81, 87, 85));
		add(lblDisenadoPor);
		
		JPanel panelConfig = new JPanel();
		panelConfig.setBounds(1107, 70, 84, 84);
		panelConfig.setBackground(new Color(0,0,0,0));
		add(panelConfig);
		panelConfig.setLayout(null);
		
		JLabel lblEncima = new JLabel("");
		lblEncima.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/recursos/profileEncima.png")));
		lblEncima.setBounds(0, 0, 84, 84);
		panelConfig.add(lblEncima);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setBounds(16, 20, 51, 43);
		panelConfig.add(lblProfile);
		lblProfile.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfile.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/recursos/profile.png")));
		lblProfile.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) { if (e.getButton()==MouseEvent.BUTTON1)new Menu(panelConfig); }
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseReleased(MouseEvent e) {}
		});
		lblProfile.setText("");
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/recursos/LogoMenu.png")));
		lblLogo.setBounds(163, 17, 141, 141);
		add(lblLogo);
		
		JPanel panelSurround = new JPanel();
		panelSurround.setBackground(null);
		panelSurround.setBounds(79, 169, 1121, 458);
		add(panelSurround);
		panelSurround.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 869, 458);
		panelSurround.add(panel);
		panel.setBackground(new Color(100, 166, 155));
		panel.setLayout(cardsPrincipal);
		vistaPetFinder petFinder = new vistaPetFinder();
		petFinder.setBounds(0,0,766,458);
		panel.add("Pet Finder", petFinder);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(869, 0, 227, 230);
		panelSurround.add(panelLista);
		panelLista.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelLista.setBackground(new Color(130, 177, 166));
	    panelLista.setLayout(new BorderLayout(0, 0));
	    
	    DefaultListModel<String> model = new DefaultListModel();
	    model.ensureCapacity(100);
	    model.addElement("  Reportes Activos");
	    model.addElement("  Mis Reportes");
	    model.addElement("  Pet Finder ®");
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
	    
	    
	    //JScrollPane scrollPaneLista = new JScrollPane(listaMenu);
	    //scrollPaneLista.setBorder(null);
	    panelLista.add(listaMenu, BorderLayout.NORTH);
	    
	    panelImagenAnimal.setBorder(new EmptyBorder(0, 0, 0, 0));
	    panelImagenAnimal.setBackground(new Color(130, 177, 166));
	    panelImagenAnimal.setBounds(869, 228, 227, 230);
	    panelSurround.add(panelImagenAnimal);
	    panelImagenAnimal.setLayout(new BorderLayout(0, 0));
	    
	    JButton btnAtras = new JButton("");
	    btnAtras.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		vistaPetFinder.cardsPanel.show(vistaPetFinder.contenedor, "PetFinder");
	    		panelImagenAnimal.removeAll();
	    	}
	    });
	    btnAtras.setIcon(new ImageIcon(VistaPrincipal.class.getResource("/recursos/BotonAtras.png")));
	    btnAtras.setBounds(10, 169, 61, 61);
	    btnAtras.setOpaque(false);
	    btnAtras.setContentAreaFilled(false);
	    btnAtras.setBorder(null);
	    add(btnAtras);
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(1280, 720);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(new VistaPrincipal());
		
		f.setVisible(true);

	}

	/**
	 * @return the usuario
	 */
	public Individuo getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Individuo usuario) {
		this.usuario = usuario;
	}
}


