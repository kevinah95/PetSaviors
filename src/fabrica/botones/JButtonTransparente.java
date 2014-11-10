package fabrica.botones;

import java.awt.Color;
import javax.swing.JButton;

public class JButtonTransparente extends JButton {
	
	private static final long serialVersionUID = 1L;
	private String dirImagen="";
	private int indiceBoton=0;

	public JButtonTransparente(String nombreBoton) {
		super(nombreBoton);
		setOpaque(false);
		setContentAreaFilled(false);
		setBorder(null);
		setBackground(new Color(0,0,0,0));
	}

	
	public String getDirImagen() {
		return dirImagen;
	}

	
	public void setDirImagen(String dirImagen) {
		this.dirImagen = dirImagen;
	}


	/**
	 * @return the indiceBoton
	 */
	public int getIndiceBoton() {
		return indiceBoton;
	}


	/**
	 * @param indiceBoton the indiceBoton to set
	 */
	public void setIndiceBoton(int indiceBoton) {
		this.indiceBoton = indiceBoton;
	}

	
}
