/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : vistaRegistrarme.java » Paquete: login » Proyecto: PetSaviors 
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Sistema para mascotas pérdidas - encontradas
 **==================================================================================== 
 */

package login;

import individuos.Regular;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import logicaExterna.Usuarios;


public class vistaRegistrarme extends JPanel {
	private JTextField txtNombre;
	private JTextField txtPApellido;
	private JTextField txtCorreo;
	private JPasswordField txtContrasenia;
	private JButton btnRegistrarme;
	private JButton btnCancelar;
	private JTextField txtCedula;
	private JPanel panel;
	private JTextField txtSApellido;
	Usuarios usuarios = Usuarios.getInstance();
	private JTextField txtTelefono;

	public vistaRegistrarme(){
		setBackground(new Color(179, 209, 202));
		setSize(1280, 720);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(405, 110, 470, 522);
		panel.setBackground(null);
		add(panel);
		panel.setLayout(null);
		
		btnRegistrarme = new JButton("Reg\u00EDstrarme");
		btnRegistrarme.setBounds(269, 458, 130, 39);
		panel.add(btnRegistrarme);
		btnRegistrarme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (verificarDatos()){
					boolean cedAprobada = false;
					cedAprobada	= verificarCedula( txtCedula.getText() );
					
					if (cedAprobada){
						registrarNuevoUsuario();
						JOptionPane.showMessageDialog(null, "Exito");
						accionVolver();
					}else{
						JOptionPane.showMessageDialog(null, "La Cédula ya se encuentra registrada en el sistema");
					}
				}
				
			}
		});
		btnRegistrarme.setForeground(new Color(240, 240, 240));
		btnRegistrarme.setOpaque(false);
		btnRegistrarme.setContentAreaFilled(false);
		btnRegistrarme.setBorder(null);
		btnRegistrarme.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(129, 458, 130, 39);
		panel.add(btnCancelar);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorder(null);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				accionVolver();
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(78, 76, 312, 28);
		panel.add(txtNombre);
		txtNombre.setOpaque(false);
		txtNombre.setBorder(null);
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNombre.setColumns(10);
		
		
		txtPApellido = new JTextField();
		txtPApellido.setBounds(78, 138, 312, 28);
		panel.add(txtPApellido);
		txtPApellido.setOpaque(false);
		txtPApellido.setBorder(null);
		txtPApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPApellido.setColumns(10);
		
		
		txtSApellido = new JTextField();
		txtSApellido.setOpaque(false);
		txtSApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSApellido.setColumns(10);
		txtSApellido.setBorder(null);
		txtSApellido.setBounds(78, 200, 312, 28);
		panel.add(txtSApellido);
		
		txtTelefono = new JTextField();
		txtTelefono.setOpaque(false);
		txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(78, 267, 312, 28);
		panel.add(txtTelefono);
		
		txtCedula = new JTextField();
		txtCedula.setBounds(78, 332, 125, 28);
		panel.add(txtCedula);
		txtCedula.setOpaque(false);
		txtCedula.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCedula.setColumns(10);
		txtCedula.setBorder(null);
		txtCedula.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            	
            }
            public void focusLost(FocusEvent e) {
            	txtCedula.setCaretPosition(0);
            }
        });
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(227, 332, 163, 28);
		panel.add(txtCorreo);
		txtCorreo.setOpaque(false);
		txtCorreo.setBorder(null);
		txtCorreo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCorreo.setColumns(10);
		txtCorreo.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
            	
            }
            public void focusLost(FocusEvent e) {
            	txtCorreo.setCaretPosition(0);
            }
        });
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(78, 397, 312, 28);
		panel.add(txtContrasenia);
		txtContrasenia.setOpaque(false);
		txtContrasenia.setBorder(null);
		txtContrasenia.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtContrasenia.setColumns(10);
		
		JLabel lblBG = new JLabel("");
		lblBG.setBounds(0, 0, 470, 520);
		panel.add(lblBG);
		lblBG.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBG.setIcon(new ImageIcon(vistaRegistrarme.class.getResource("/recursos/Registrar.png")));
		
		
		
		
	}
	
	public void registrarNuevoUsuario(){
		String pIdentificacion = txtCedula.getText();
		String pNombre = txtNombre.getText();
		String primerApellido = txtPApellido.getText();
		String segundoApellido = txtSApellido.getText();
		String pTelefono = txtTelefono.getText();
		String pCorreo = txtCorreo.getText();
		String pContrasena = txtContrasenia.getText();
		
		Regular nuevoUsuario = new Regular(pIdentificacion, pNombre, primerApellido, 
				segundoApellido,pTelefono, pCorreo, pContrasena, "false");
		usuarios.agregarUsuario(nuevoUsuario);
		usuarios.actualizarJsonUsuarios();
		
	}
	
	public void accionVolver(){
		limpiarTextos();
		vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "Ingresar");
		getParent().revalidate();
		getParent().repaint();
	}
	
	public void limpiarTextos(){
		txtNombre.setText("");
		txtPApellido.setText("");
		txtSApellido.setText("");
		txtTelefono.setText("");
		txtCedula.setText("");
		txtCorreo.setText("");
		txtContrasenia.setText("");
		
	}
	
	
	public boolean verificarCedula(String pCedula){
		if (usuarios.usuariosRegistrados == null){
			return true;
		}else{
			int coincidencias = (int) usuarios.usuariosRegistrados.stream().filter(p -> p.getIdentificacion().equals(pCedula)).count();
			if (coincidencias==0){
				return true; //Pasó la prueba
			}
		}
		return false;
	}
	
	/**
	 * Método para verificar si la dirección ingresada sea un email válido
	 */
	public boolean verificarEmail() {

		// Establecer el patrón
		Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
		// Asociar el string al patrón
		Matcher matchCorreo = p.matcher(txtCorreo.getText());
		// Comprobar si encaja
		if (matchCorreo.matches()) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null,
					"La dirección de correo no es válida");
			return false;
		}

	}
	
	public boolean verificarDatos(){
		//Comprobar Nombre
		if ( txtNombre.getText().matches("\\s*") ){ //Verifica si tiene espacios en blanco
			JOptionPane.showMessageDialog(null, "El dato Nombre no ha sido ingresado");	return false;}
		//Comprobar pApellido
		if ( txtPApellido.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Primer Apellido no ha sido ingresado"); return false;}
		//Comprobar sApellido
		if ( txtSApellido.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Segundo Apellido no ha sido ingresado"); return false;}
		if (!txtTelefono.getText().matches("\\d*") || txtTelefono.getText().matches("\\s*")){
			JOptionPane.showMessageDialog(null, "El dato Teléfono solo acepta digitos");	return false;}
		//Comprobar cédula
		if (!txtCedula.getText().matches("\\d*") || txtCedula.getText().matches("\\s*")){
			JOptionPane.showMessageDialog(null, "El dato Cédula solo acepta digitos");	return false;}
		//Comprobar Correo
		if ( txtCorreo.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Correo no ha sido ingresado");	return false;}
		else{
			if (verificarEmail() == false){ return false; }
		}
		//Comprobar segundo apellido
		if ( txtContrasenia.getText().matches("\\s*") ){
			JOptionPane.showMessageDialog(null, "El dato Contraseña no ha sido ingresado");	return false;}
		
		return true;
		
	}
	
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(800,600);
		f.setLocationRelativeTo(null);
		f.getContentPane().add(new vistaRegistrarme());
		
		f.setVisible(true);

	}
}
