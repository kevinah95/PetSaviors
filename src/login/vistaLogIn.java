/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : VistaLogIn.java � Paquete: login � Proyecto: PetSaviors 
 * Autores      : Kevin Hern�ndez Rostr�n, Jasson Moya �lvarez, 
 *				  Juli�n M�ndez Oconitrillo, Jos� Aguilar Quesada.
 * Curso        : Programaci�n Orientada a Objetos - Instituto Tecnol�gico de Costa Rica
 * Descripcion  : Sistema para mascotas p�rdidas - encontradas
 **==================================================================================== 
 */

package login;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class vistaLogIn extends JPanel{
	
	public JTextField txtCedula;
	public JPasswordField txtContrasenia;
	JButton btnEntrar;
	JButton btnRegistrarme;
	JLabel lblLogo;
	JPanel panel;
	
	private static vistaLogIn instance = null;
	
	public static vistaLogIn getInstance() {
		if (instance == null) {	instance = new vistaLogIn(); }
		return instance;
	}
	
	protected vistaLogIn() {
	}
	
	public void crearVista(){
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

		btnRegistrarme.setOpaque(false);
		btnRegistrarme.setForeground(Color.WHITE);
		btnRegistrarme.setFont(new Font("Segoe UI", Font.BOLD, 15));
		btnRegistrarme.setContentAreaFilled(false);
		btnRegistrarme.setBorder(null);
		btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(346, 251, 301, 54);
		panel.add(btnEntrar);
	
		
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
		
		JLabel lblLogger = new JLabel("");
		lblLogger.setBounds(257, 62, 460, 341);
		panel.add(lblLogger);
		lblLogger.setIcon(new ImageIcon(vistaLogIn.class.getResource("/recursos/Log.png")));
		
		lblLogo = new JLabel("");
		lblLogo.setBounds(6, 16, 253, 237);
		panel.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(vistaLogIn.class.getResource("/recursos/logo.png")));
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
	
}
