package registrar.mascota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import clasificacion.animales.ControlEspecie;

public class ControladorEtapaDatos implements ActionListener{

	ModeloEtapaDatos modelo = null;
	VistaEtapaDatos vista = null;
	
	
	public ControladorEtapaDatos() {
		this.modelo = ModeloEtapaDatos.getInstance();
		this.vista = VistaEtapaDatos.getInstance();
		setAcciones(this);
	}
	
	private void setAcciones(ActionListener escuchador){
		vista.btnCancelar.addActionListener(escuchador);
		vista.btnSiguiente.addActionListener(escuchador);
		vista.cbEspecie.addActionListener(new accionCBEspecie(vista.cbEspecie));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "Cancelar"){
			RegistrarMascota.getInstance().dispose();
		}
		
		if (e.getActionCommand().equals("Siguiente")){
			RegistrarMascota.getInstance().cardlayout.show(RegistrarMascota.getInstance().panelCards,"VistaEtapaImagenes");
			vista.getParent().repaint();
			vista.getParent().revalidate();
		}
		
	}

}

class accionCBEspecie implements ActionListener {
    JComboBox<String> cbEspecie;
    ModeloEtapaDatos modelo = new ModeloEtapaDatos();
    VistaEtapaDatos vista = VistaEtapaDatos.getInstance();
    public accionCBEspecie(JComboBox<String> cbEspecie) {
        this.cbEspecie = cbEspecie;
    }
 
    public void actionPerformed(ActionEvent e) {
    	JComboBox cb = (JComboBox)e.getSource();
        String especieElegida = (String)cb.getSelectedItem();
        
		vista.cbRaza.setModel(new DefaultComboBoxModel( modelo.llenarComboRaza(especieElegida) ));
    }
}
