package configuracion;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.*;

import editar.usuario.EditarUsuario;

import java.awt.*;
import java.awt.event.*;

import login.vistaIngreso;
import login.vistaLogIn;
import registrar.mascota.RegistrarMascota;
import render.listas.RenderMenu;

public class Menu extends JFrame implements WindowFocusListener, ListSelectionListener{
	private static final long serialVersionUID = 1L;
	JList<String> listaMenu;
	
	public Menu(java.awt.Component relativo){
		setUndecorated(true);
		setBackground(new Color(0,0,0,0)); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(220, 220);
		JPanel panel = new JPanel(){
			protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    Paint p =
                        new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0),
                            0.0f, getHeight(), new Color(0, 0, 0, 0), true);
                    Graphics2D g2d = (Graphics2D)g; g2d.setPaint(p); g2d.fillRect(0, 0, getWidth(), getHeight()); } }
		};
		panel.setBackground(new Color(0,0,0,0));
		panel.setBounds(0, 0, 220, 220);
		panel.setLayout(null);
		setContentPane(panel);
		
		JLabel lblBG = new JLabel("");
		lblBG.setIcon(new ImageIcon(Menu.class.getResource("/recursos/ConfigMenu2.png")));
		lblBG.setBounds(5, 0, 210, 220);
		lblBG.setVisible(true);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(19, 42, 168, 152);
		panel.add(panelLista);
		panelLista.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelLista.setLayout(new BorderLayout(0, 0));
		panelLista.setBackground(new Color(130,177,166));
		
		
		DefaultListModel<String> model = new DefaultListModel<String>();
	    model.addElement("Editar Perfil");
	    model.addElement("Reportar Mascota");
	    model.addElement("Cerrar Sesi�n");
	    ListCellRenderer<String> renderer = new RenderMenu();
		listaMenu = new JList<String>(model);
		listaMenu.setFont(new Font("Dialog", Font.BOLD, 15));
	    listaMenu.setBackground(new Color(130, 177, 166));
	    listaMenu.setBorder(null);
	    
	    
	    listaMenu.setCellRenderer(renderer);
	    
	    listaMenu.addListSelectionListener(this);
	    
	    
	    
		JScrollPane scrollPaneLista = new JScrollPane(listaMenu);
	    scrollPaneLista.setBorder(null);
		panelLista.add(scrollPaneLista);
		
		panel.add(lblBG);
		
		setFocusableWindowState(true);
		setAlwaysOnTop(true);
		setFocusable(true);
		setLocationRelativeTo(relativo);
		setLocation(getX()-60, getY()+120);
		addWindowFocusListener(this);
		setVisible(true);
	}
	
	public void windowGainedFocus(WindowEvent e) {}
	public void windowLostFocus(WindowEvent e) { dispose(); }

	public void valueChanged(ListSelectionEvent e) {
		
		if (e.getValueIsAdjusting() == true) {
			if(listaMenu.getSelectedIndex() == 0){
				
				EditarUsuario editarusuario = new EditarUsuario();
				
			}
			if (listaMenu.getSelectedIndex() == 1) {
				RegistrarMascota registrarmascota = new RegistrarMascota();
				System.out.println(listaMenu.getSelectedIndex());
				
			}
			if (listaMenu.getSelectedIndex() == 2) {
				vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "Ingresar");
				dispose();
				vistaLogIn.getInstance().txtCedula.setText("C�dula");
				vistaLogIn.getInstance().txtContrasenia.setText("Contrasenia");
			}
			
		}
		
	}
}
