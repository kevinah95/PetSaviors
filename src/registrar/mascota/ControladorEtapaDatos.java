package registrar.mascota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import clasificacion.animales.ControlEspecie;

public class ControladorEtapaDatos implements ActionListener{

	ModeloEtapaDatos modelo = null;
	static VistaEtapaDatos vista = null;
	
	
	public ControladorEtapaDatos(VistaEtapaDatos etapadatos) {
		this.modelo = ModeloEtapaDatos.getInstance();
		this.vista = etapadatos;
		setAcciones(this);
	}
	
	private void setAcciones(ActionListener escuchador){
		vista.btnAtras.addActionListener(escuchador);
		vista.btnSiguiente.addActionListener(escuchador);
		vista.cbEspecie.addActionListener(new accionCBEspecie(vista.cbEspecie));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==vista.btnAtras){
			RegistrarMascota.cardlayout.show(RegistrarMascota.panelCards,"VistaEtapaSeleccion");
			vista.limpiarRegistros();
			RegistrarMascota.etapaimagenes.limpiarDatos();
		}
		
		if (e.getActionCommand().equals("Siguiente")){
			if (modelo.verificarDatos(vista.txtNombre.getText(),
					vista.txtChip.getText(), vista.txtDescripcion.getText())) {
				RegistrarMascota.cardlayout.show(
						RegistrarMascota.panelCards,
						"VistaEtapaImagenes");
				vista.getParent().repaint();
				vista.getParent().revalidate();
			}
			
			
		}
		
	}

}

class accionCBEspecie implements ActionListener {
    JComboBox<String> cbEspecie;
    ModeloEtapaDatos modelo = new ModeloEtapaDatos();
    VistaEtapaDatos vista = ControladorEtapaDatos.vista;
    public accionCBEspecie(JComboBox<String> cbEspecie) {
        this.cbEspecie = cbEspecie;
    }
 
    public void actionPerformed(ActionEvent e) {
    	JComboBox cb = (JComboBox)e.getSource();
        String especieElegida = (String)cb.getSelectedItem();
        
		vista.cbRaza.setModel(new DefaultComboBoxModel( modelo.llenarComboRaza(especieElegida) ));
    }
}
