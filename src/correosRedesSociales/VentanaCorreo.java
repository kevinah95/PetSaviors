package correosRedesSociales;

import javax.swing.*;
import javax.swing.border.Border;

import correosRedesSociales.Email;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.event.*;
public class VentanaCorreo extends JFrame implements ActionListener{
    private JTextField textfield;
    private JEditorPane areafield;
    private JLabel label1;
    private JLabel label2;
    private JButton boton1;
    private JButton salir;
    private String pin;
    private String destinatario;
    public VentanaCorreo(String destinatario) {
    	setBounds(450,200,375,500);
    	this.destinatario = destinatario;
    	Border border = BorderFactory.createLineBorder(new Color(192, 192, 192),2,true);
        setLayout(null);
        getContentPane().setBackground(new Color(100, 166, 155));
        label1=new JLabel("Asunto:");
        label1.setBounds(10,24,100,30);
        add(label1);
        label2=new JLabel("Mensaje:");
        label2.setBounds(10,80,100,30);
        add(label2);
        textfield=new JTextField();
        textfield.setBounds(90,30,250,20);
        textfield.setBorder(border);
        add(textfield);
        areafield=new JEditorPane();
        areafield.setBounds(90,83,250,300);
        areafield.setBorder(border);
        add(areafield);
        boton1=new JButton("Enviar");
        boton1.setBounds(90,400,100,30);
        add(boton1);
        boton1.addActionListener(this);
        salir = new JButton("Salir");
        salir.setBounds(200, 400, 100, 30);
        add(salir);
        salir.addActionListener(this);
        setVisible(true);
		setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setFocusableWindowState(true);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            Email mail = new Email();
            boolean isEnviado = mail.enviarMensaje(destinatario, textfield.getText(), areafield.getText());
            if(isEnviado) {
            	JOptionPane.showMessageDialog(this, "Su correo fue enviado con éxito");
            }
            else {
            	JOptionPane.showMessageDialog(this, "Su correo no fue enviado con éxito");
            }
            setVisible(false);
        }
        if(e.getSource() == salir) {
        	dispose();
        }
    }
  
    public String getPIN(){
    	return pin;
    }
    
}