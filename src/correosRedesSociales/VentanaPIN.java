package correosRedesSociales;

import javax.swing.*;
import correosRedesSociales.*;
import java.awt.Color;
import java.awt.event.*;
public class VentanaPIN extends JFrame implements ActionListener{
    private JTextField textfield;
    private JLabel label1;
    private JButton boton1;
    private JButton boton2;
    private String pin;
    TwitterPost post;
    
    public VentanaPIN() {
        setLayout(null);
        pin = "";
        getContentPane().setBackground(new Color(100, 166, 155));
        label1=new JLabel("PIN:");
        label1.setBounds(50,24,100,30);
        add(label1);
        textfield=new JTextField();
        textfield.setBounds(80,30,150,20);
        add(textfield);
        boton1=new JButton("Validar");
        boton1.setBounds(170,60,100,30);
        add(boton1);
        boton2=new JButton("Generar Autorización");
        boton2.setBounds(15,60,160,30);
        add(boton2);
        //post = new TwitterPost();
        boton1.addActionListener(this);
        boton2.addActionListener(this);
        //post = new TwitterPost();
        
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            pin = textfield.getText();
            post.validarPIN(pin);
            setVisible(false);
        }
        if (e.getSource()==boton2){
        	post = new TwitterPost();
        }
    }
    
    public static void main(String [] args) {
        VentanaPIN VentanaPIN1=new VentanaPIN();
        VentanaPIN1.setBounds(500,300,300,150);
        VentanaPIN1.setVisible(true);
        
    }
    public String getPIN(){
    	return pin;
    }
}