package petFinder;

import individuos.Individuo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.function.Predicate;

import logicaExterna.Mascotas;
import logicaInterna.ReporteAnimal;
import petFinder.buscarMascota.ControladorMisMascotasPerdidas;
import petFinder.buscarMascota.ModeloMisMascotasPerdidas;
import petFinder.buscarMascota.VistaMisMascotasPerdidas;




public class ControladorMisMascotas{
	
	VentanaMisMascotas vista;
	ReporteAnimal animalSeleccionado;

	public ControladorMisMascotas(VentanaMisMascotas vista) {
		this.vista = vista;
		setAcciones();
	}
	
	public void setAcciones(){
		vista.tabla.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int indexfila = vista.tabla
						.convertRowIndexToModel(vista.tabla
								.getSelectedRow());
				int indexcol = 5;
				System.out.println();
				String IDseleccionado = (String) vista.tabla.getModel().getValueAt(indexfila, indexcol);
				
				Predicate<ReporteAnimal> filtroID = new Predicate<ReporteAnimal>() {
					public boolean test(ReporteAnimal t) {
						return t.getAnimalReportado().getChipIdentificacion().equals(IDseleccionado);
					}
				};
				Mascotas.mascotasRegistradas.stream().filter(filtroID).forEach(p->animalSeleccionado = p);
				
				VistaMisMascotasPerdidas nuevoPetFinder = new VistaMisMascotasPerdidas(animalSeleccionado);
				ModeloMisMascotasPerdidas modelonuevo = new ModeloMisMascotasPerdidas();
				new ControladorMisMascotasPerdidas(nuevoPetFinder, modelonuevo);
				
				
			}
		});
	}
	
	


}
