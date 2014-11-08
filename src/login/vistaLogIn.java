/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : vistaLogIn.java » Paquete: login » Proyecto: PetSaviors 
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Sistema para mascotas pérdidas - encontradas
 **==================================================================================== 
 */

package login;

import individuos.Individuo;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.function.Predicate;
import javax.swing.border.EmptyBorder;
import logicaExterna.Usuarios;
import menu.principal.PrincipalNormal;

public class vistaLogIn extends JPanel{
	
	public JTextField txtCedula;
	public JPasswordField txtContrasenia;
	public JButton btnEntrar;
	public JButton btnRegistrarme;
	public JLabel lblLogo;
	public JPanel panel;
	Usuarios usuarios = Usuarios.getInstance();
	boolean entrarSistema = false;
	
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
				verificarDatos();
				if (entrarSistema==false){
					JOptionPane.showMessageDialog(null, "Datos Incorrectos");
				}
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
		txtCedula.setText("Cédula");
		txtCedula.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            	if (txtCedula.getText().equals("Cédula")){
            		txtCedula.setText("");
            	}
            }
            public void focusLost(FocusEvent e) {
            	if (txtCedula.getText().equals("")){
            		txtCedula.setText("Cédula");
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
	
	Predicate<Individuo> predicadoCedula = new Predicate<Individuo>() {
		@Override
		public boolean test(Individuo t) {
			return t.getIdentificacion().equals(txtCedula.getText());
		}
	};
	Predicate<Individuo> predicadoContrasena = new Predicate<Individuo>() {
		@Override
		public boolean test(Individuo t) {
			return t.getContrasena().equals(txtContrasenia.getText());
		}
	};
	Predicate<Individuo> predicadoFull = predicadoCedula.and(predicadoContrasena);
	
	
	
	private void verificarDatos(){
		if (usuarios.usuariosRegistrados == null){
			JOptionPane.showMessageDialog(null, "No hay usuarios registrados en el sistema");
			entrarSistema = false;
		}else{
			
			usuarios.usuariosRegistrados.stream().filter(predicadoFull).forEach(p->entrarASistema());
			
		}
		
	}
	
	
	
	private void entrarASistema(){
		entrarSistema = true;
		vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "PrincipalNormal");
		PrincipalNormal.listaMenu.requestFocus();
		getParent().revalidate();
		getParent().repaint();
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
