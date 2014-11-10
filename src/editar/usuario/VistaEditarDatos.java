/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : VistaRegistrarme.java » Paquete: login » Proyecto: PetSaviors 
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Sistema para mascotas pérdidas - encontradas
 **==================================================================================== 
 */

package editar.usuario;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;



public class VistaEditarDatos extends JPanel {

	private static final long serialVersionUID = 1L;
	JTextField txtNombre;
	JTextField txtPApellido;
	JTextField txtCorreo;
	JPasswordField txtContrasenia;
	JButton btnSiguiente;
	JButton btnCancelar;
	JPanel panel;
	JTextField txtSApellido;
	
	JTextField txtTelefono;

	public VistaEditarDatos(String nombre,String pApellido,String sApellido,String telefono,String correo,String contrasenia){
		setBackground(new Color(179, 209, 202));
		setSize(600, 600);
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(65, 39, 470, 522);
		panel.setBackground(null);
		add(panel);
		panel.setLayout(null);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(269, 458, 130, 39);
		panel.add(btnSiguiente);
		btnSiguiente.setForeground(new Color(240, 240, 240));
		btnSiguiente.setOpaque(false);
		btnSiguiente.setContentAreaFilled(false);
		btnSiguiente.setBorder(null);
		btnSiguiente.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(129, 458, 130, 39);
		panel.add(btnCancelar);
		btnCancelar.setOpaque(false);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorder(null);
		btnCancelar.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		txtNombre = new JTextField(nombre);
		txtNombre.setBounds(78, 76, 312, 28);
		panel.add(txtNombre);
		txtNombre.setOpaque(false);
		txtNombre.setBorder(null);
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtNombre.setColumns(10);
		
		
		txtPApellido = new JTextField(pApellido);
		txtPApellido.setBounds(78, 138, 312, 28);
		panel.add(txtPApellido);
		txtPApellido.setOpaque(false);
		txtPApellido.setBorder(null);
		txtPApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtPApellido.setColumns(10);
		
		
		txtSApellido = new JTextField(sApellido);
		txtSApellido.setOpaque(false);
		txtSApellido.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtSApellido.setColumns(10);
		txtSApellido.setBorder(null);
		txtSApellido.setBounds(78, 200, 312, 28);
		panel.add(txtSApellido);
		
		txtTelefono = new JTextField(telefono);
		txtTelefono.setOpaque(false);
		txtTelefono.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtTelefono.setColumns(10);
		txtTelefono.setBorder(null);
		txtTelefono.setBounds(78, 267, 312, 28);
		panel.add(txtTelefono);
		
		txtCorreo = new JTextField(correo);
		txtCorreo.setBounds(78, 332, 312, 28);
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
		
		txtContrasenia = new JPasswordField(contrasenia);
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
		lblBG.setIcon(new ImageIcon(VistaEditarDatos.class.getResource("/recursos/EditarUsuario.png")));
	
	}
	
}
