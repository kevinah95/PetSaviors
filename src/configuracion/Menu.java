package configuracion;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JWindow;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;

import com.sun.xml.internal.ws.api.Component;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.FlowLayout;
import java.awt.Paint;

import javax.swing.JList;
import javax.swing.AbstractListModel;

import render.listas.RenderMenu;
import render.listas.RenderPrincipal;

public class Menu extends JFrame implements WindowFocusListener{
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
		lblBG.setIcon(new ImageIcon(Menu.class.getResource("/recursos/ConfigMenu.png")));
		lblBG.setBounds(5, 0, 210, 220);
		lblBG.setVisible(true);
		
		JPanel panelLista = new JPanel();
		panelLista.setBounds(10, 21, 200, 173);
		panel.add(panelLista);
		panelLista.setBorder(new EmptyBorder(0, 0, 0, 0));
		panelLista.setLayout(new BorderLayout(0, 0));
		panelLista.setBackground(new Color(130,177,166));
		
		
		DefaultListModel<String> model = new DefaultListModel();
	    model.addElement("Reportes Activos");
	    model.addElement("Mis Reportes");
	    model.addElement("Pet Finder ®");
	    ListCellRenderer renderer = new RenderMenu();
		JList listaMenu = new JList(model);
		listaMenu.setFont(new Font("Dialog", Font.BOLD, 18));
	    listaMenu.setBackground(new Color(130, 177, 166));
	    listaMenu.setBorder(null);
	    listaMenu.setSelectedIndex(0);
	    
	    listaMenu.setCellRenderer(renderer);
	    
	    
		JScrollPane scrollPaneLista = new JScrollPane(listaMenu);
	    scrollPaneLista.setBorder(null);
		panelLista.add(scrollPaneLista);
		
		panel.add(lblBG);
		
		setFocusableWindowState(true);
		setAlwaysOnTop(true);
		setFocusable(true);
		setLocation(relativo.getX()+33, relativo.getY()-175);
		addWindowFocusListener(this);
		setVisible(true);
	}
	
	public void windowGainedFocus(WindowEvent e) {}
	public void windowLostFocus(WindowEvent e) { dispose(); }
}
