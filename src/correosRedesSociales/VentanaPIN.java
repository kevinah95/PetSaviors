package correosRedesSociales;

import javax.swing.*;

import java.awt.Color;
import java.awt.event.*;
public class VentanaPIN extends JFrame implements ActionListener{
    private JTextField textfield;
    private JLabel label1;
    private JButton boton1;
    private String pin;
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
        boton1.setBounds(90,60,100,30);
        add(boton1);
        boton1.addActionListener(this);
        
    }
    
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==boton1) {
            pin = textfield.getText();
            setVisible(false);
        }
    }
    
    public static void main(String[] ar) {
        VentanaPIN VentanaPIN1=new VentanaPIN();
        VentanaPIN1.setBounds(500,300,300,150);
        VentanaPIN1.setVisible(true);
    }
    public String getPIN(){
    	return pin;
    }
}