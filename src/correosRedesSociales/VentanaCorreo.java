package correosRedesSociales;

import javax.swing.*;
import javax.swing.border.Border;
import correosRedesSociales.Email;
import java.awt.Color;
import java.awt.event.*;
public class VentanaCorreo extends JFrame implements ActionListener{
    private JTextField textfield;
    private JTextArea areafield;
    private JLabel label1;
    private JLabel label2;
    private JButton boton1;
    private String pin;
    public VentanaCorreo() {
    	Border border = BorderFactory.createLineBorder(new Color(192, 192, 192),2,true);
        setLayout(null);
        getContentPane().setBackground(new Color(100, 166, 155));
        label1=new JLabel("Destinatario:");
        label1.setBounds(10,24,100,30);
        add(label1);
        label2=new JLabel("Mensaje:");
        label2.setBounds(10,80,100,30);
        add(label2);
        textfield=new JTextField();
        textfield.setBounds(90,30,250,20);
        textfield.setBorder(border);
        add(textfield);
        areafield=new JTextArea();
        areafield.setBounds(90,83,250,300);
        areafield.setBorder(border);
        add(areafield);
        boton1=new JButton("Enviar");
        boton1.setBounds(90,400,100,30);
        add(boton1);
        boton1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            Email mail = new Email();
            mail.enviarMensaje(textfield.getText(), areafield.getText());
            setVisible(false);
        }
    }
    
    public static void main(String[] ar) {
        llamarVentana();
    }
    public String getPIN(){
    	return pin;
    }
    public static void llamarVentana() {
        VentanaCorreo VentanaCorreo1=new VentanaCorreo();
        VentanaCorreo1.setBounds(450,200,375,500);
        VentanaCorreo1.setVisible(true);
    }
    
}