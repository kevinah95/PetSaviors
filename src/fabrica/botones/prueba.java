package fabrica.botones;

import javax.swing.JFrame;

public class prueba extends JFrame {
	public prueba() {
		add(FabricaBotones.getInstance().crearBoton("Transparente", "Boton"));
		setVisible(true);
	}

	public static void main(String[] args) {
		new prueba();

	}

}
