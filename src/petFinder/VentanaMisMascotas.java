package petFinder;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class VentanaMisMascotas extends JPanel {
	//Esta clase va a contener una JTable con los animales que tiene el usuario.
	
	public VentanaMisMascotas() {
		setSize(766, 458);
		setBackground(new Color(155, 196, 188));
		setLayout(null);
		
		JLabel lblAquVaUna = new JLabel("Aqu\u00ED va una JTable :)");
		lblAquVaUna.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 17));
		lblAquVaUna.setBounds(244, 148, 278, 161);
		add(lblAquVaUna);
		
	}
}
