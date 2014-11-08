package registrar.mascota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.ImageIcon;

public class ControladorEtapaImagenes implements ActionListener{

	ModeloEtapaImagenes modelo = null;
	VistaEtapaImagenes vista = null;
	public ControladorEtapaImagenes() {
		this.modelo = ModeloEtapaImagenes.getInstance();
		this.vista = VistaEtapaImagenes.getInstance();
		setAcciones(this);
		
	}
	
	private void setAcciones(ActionListener escuchador){
		vista.btnAtras.addActionListener(escuchador);
		vista.btnGuardar.addActionListener(escuchador);
		vista.btnImagen0.addActionListener(escuchador);
		vista.btnImagen1.addActionListener(escuchador);
		vista.btnImagen2.addActionListener(escuchador);
		vista.btnImagen3.addActionListener(escuchador);
		vista.btnImagen4.addActionListener(escuchador);
		vista.btnImagen5.addActionListener(escuchador);
	}
	
	

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==vista.btnAtras){
			Registrar.getInstance().cardlayout.show(Registrar.getInstance().panelCards,"VistaEtapaDatos");
		}
		
		if (e.getSource()==vista.btnGuardar){
			
		}
		
		if (e.getSource()==vista.btnImagen0){
			if (modelo.verificarImagen()){
				try {
					vista.btnImagen0.setIcon(new ImageIcon(modelo.obtenerImagen()));
					vista.btnImagen1.setIcon(new ImageIcon(vista.ICONO_DEFAULT));
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
		if (e.getSource()==vista.btnImagen1){
			if (modelo.verificarImagen()){
				try {
					vista.btnImagen1.setIcon(new ImageIcon(modelo.obtenerImagen()));
					vista.btnImagen2.setIcon(new ImageIcon(vista.ICONO_DEFAULT));
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
		if (e.getSource()==vista.btnImagen2){
			if (modelo.verificarImagen()){
				try {
					vista.btnImagen2.setIcon(new ImageIcon(modelo.obtenerImagen()));
					vista.btnImagen3.setIcon(new ImageIcon(vista.ICONO_DEFAULT));
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
		if (e.getSource()==vista.btnImagen3){
			if (modelo.verificarImagen()){
				try {
					vista.btnImagen3.setIcon(new ImageIcon(modelo.obtenerImagen()));
					vista.btnImagen4.setIcon(new ImageIcon(vista.ICONO_DEFAULT));
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
		if (e.getSource()==vista.btnImagen4){
			if (modelo.verificarImagen()){
				try {
					vista.btnImagen4.setIcon(new ImageIcon(modelo.obtenerImagen()));
					vista.btnImagen5.setIcon(new ImageIcon(vista.ICONO_DEFAULT));
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
		if (e.getSource()==vista.btnImagen5){
			if (modelo.verificarImagen()){
				try {
					vista.btnImagen5.setIcon(new ImageIcon(modelo.obtenerImagen()));
					vista.lblImagenPrincipal.setIcon(new ImageIcon(modelo.obtenerImagenPrincipal()));
					vista.lblImagenPrincipal.setText("");
				} catch (IOException e1) { e1.printStackTrace(); }
			}
		}
		
		
		
		
	}

	
	
	
	

}
