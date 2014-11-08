package fabrica.botones;

import java.awt.Color;

import javax.swing.JButton;

public class JButtonTransparente extends JButton {
	public String dirImagen=null;

	public JButtonTransparente(String nombreBoton) {
		super(nombreBoton);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(null);
		setBackground(new Color(0,0,0,0));
	}

	
}
