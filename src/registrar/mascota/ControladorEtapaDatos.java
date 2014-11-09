package registrar.mascota;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

public class ControladorEtapaDatos implements ActionListener{

	ModeloEtapaDatos modelo = null;
	VistaEtapaDatos vista = null;
	
	
	public ControladorEtapaDatos() {
		this.modelo = ModeloEtapaDatos.getInstance();
		this.vista = VistaEtapaDatos.getInstance();
		setAcciones(this);
	}
	
	private void setAcciones(ActionListener escuchador){
		vista.btnAtras.addActionListener(escuchador);
		vista.btnSiguiente.addActionListener(escuchador);
		vista.cbEspecie.addActionListener(new accionCBEspecie(vista.cbEspecie));
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==vista.btnAtras){
			RegistrarMascota.getInstance().cardlayout.show(RegistrarMascota.getInstance().panelCards,"VistaEtapaSeleccion");
			vista.limpiarRegistros();
			VistaEtapaImagenes.getInstance().limpiarDatos();
		}
		
		if (e.getActionCommand().equals("Siguiente")){
			if (modelo.verificarDatos(vista.txtNombre.getText(),
					vista.txtChip.getText(), vista.txtDescripcion.getText())) {
				RegistrarMascota.getInstance().cardlayout.show(
						RegistrarMascota.getInstance().panelCards,
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
