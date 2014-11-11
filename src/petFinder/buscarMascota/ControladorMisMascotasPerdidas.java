package petFinder.buscarMascota;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import logicaInterna.ReporteAnimal;

public class ControladorMisMascotasPerdidas {

	VistaMisMascotasPerdidas vista;
	ModeloMisMascotasPerdidas modelo;
	public ControladorMisMascotasPerdidas(VistaMisMascotasPerdidas vista, ModeloMisMascotasPerdidas modelo) {
		this.vista = vista;
		this.modelo = modelo;
		setAcciones();
	}
	
	private void setAcciones() {
		vista.tablaMascotasPerdidas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (evt.getClickCount() ==2){
					
					System.out.println("asdasdasd");
//					System.out.println(indexCliente);
				}
				
//				ReporteAnimal animal = vista.tablaMascotasPerdidas.getValueAt(0, indexCliente);
			}
		});
		
	}
	
	

}
