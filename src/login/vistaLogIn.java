/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : vistaLogIn.java � Paquete: login � Proyecto: PetSaviors 
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Sistema para mascotas p�rdidas - encontradas
 **==================================================================================== 
 */

package login;



import javax.swing.JPanel;


import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.border.EmptyBorder;

import menu.principal.PrincipalNormal;


public class vistaLogIn extends JPanel{
	
	public JTextField txtCedula;
	public JPasswordField txtContrasenia;
	public JButton btnEntrar;
	public JButton btnRegistrarme;
	public JLabel label;
	public JPanel panel;
	
	public vistaLogIn() {
		setSize(1280, 720);
		setBackground(new Color(179, 209, 202));
		setLayout(null);
		setFocusable(true);
		setRequestFocusEnabled(true);
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel.setBackground(null);
		panel.setBounds(278, 155, 723, 410);
		add(panel);
		panel.setLayout(null);
		
		btnRegistrarme = new JButton("Registrarme");
		btnRegistrarme.setBounds(346, 307, 301, 54);
		panel.add(btnRegistrarme);
		btnRegistrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtCedula.getText().equals("Usuario") && 
						!txtContrasenia.getText().equals("Contrasenia")){ limpiarDatos(); }
					
				vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "vistaRegistrarme");
				getParent().revalidate();
				getParent().repaint();
			}
		});
		btnRegistrarme.setOpaque(false);
		btnRegistrarme.setForeground(Color.WHITE);
		btnRegistrarme.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRegistrarme.setContentAreaFilled(false);
		btnRegistrarme.setBorder(null);
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(346, 251, 301, 54);
		panel.add(btnEntrar);
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "PrincipalNormal");
//				PrincipalNormal.listaMenu.setSelectedIndex(0);
				PrincipalNormal.listaMenu.requestFocus();
				getParent().revalidate();
				getParent().repaint();
			}
		});
		btnEntrar.setOpaque(false);
		btnEntrar.setContentAreaFilled(false);
		btnEntrar.setBorder(null);
		btnEntrar.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnEntrar.setForeground(new Color(255, 255, 255));
		
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(359, 197, 288, 28);
		panel.add(txtContrasenia);
		txtContrasenia.setText("Contrasenia");
		txtContrasenia.setOpaque(false);
		txtContrasenia.setBorder(null);
		txtContrasenia.setForeground(Color.WHITE);
		txtContrasenia.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtContrasenia.setColumns(10);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(359, 138, 288, 28);
		panel.add(txtCedula);
		txtCedula.setOpaque(false);
		txtCedula.setBorder(null);
		txtCedula.setForeground(new Color(255, 255, 255));
		txtCedula.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtCedula.setText("C�dula");
		txtCedula.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            	if (txtCedula.getText().equals("C�dula")){
            		txtCedula.setText("");
            	}
            }
            public void focusLost(FocusEvent e) {
            	if (txtCedula.getText().equals("")){
            		txtCedula.setText("C�dula");
            	}
            }
        });
		txtCedula.setColumns(10);
		
		JLabel lblLog = new JLabel("");
		lblLog.setBounds(257, 62, 460, 341);
		panel.add(lblLog);
		lblLog.setIcon(new ImageIcon(vistaLogIn.class.getResource("/recursos/Log.png")));
		
		label = new JLabel("");
		label.setBounds(6, 16, 253, 237);
		panel.add(label);
		label.setIcon(new ImageIcon(vistaLogIn.class.getResource("/recursos/logo.png")));
		txtContrasenia.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            	if (txtContrasenia.getText().equals("Contrasenia")){
            		txtContrasenia.setText("");
            		
            	}
            }
            public void focusLost(FocusEvent e) {
            	if (txtContrasenia.getText().equals("")){
            		txtContrasenia.setText("Contrasenia");
            	}
            }
        });

	}
	
	public void limpiarDatos(){
		txtCedula.setText("");
		txtContrasenia.setText("");
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(new vistaLogIn());
		
		f.setVisible(true);
		
	}
}