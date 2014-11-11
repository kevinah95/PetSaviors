package petFinder.buscarMascota;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;

import correosRedesSociales.VentanaCorreo;
import logicaExterna.Mascotas;
import logicaInterna.Animal;
import logicaInterna.Comparaciones;
import logicaInterna.ReporteAnimal;


public class VistaMisMascotasPerdidas extends JFrame {
	public JTable tablaMascotasPerdidas;
	public DefaultTableModel modeloMascotasPerdidas;
	
	public static ArrayList<String> listaPath = new ArrayList<>();
	String correoDueno="";

	public VistaMisMascotasPerdidas(ReporteAnimal animalSeleccionado) {
		setSize(800, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 747, 384);
		getContentPane().add(scrollPane);
		
		
		llenarTabla(animalSeleccionado);
		//tablaMascotasPerdidas = new JTable();
		scrollPane.setViewportView(tablaMascotasPerdidas);
		tablaMascotasPerdidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaMascotasPerdidas.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				int indexfila = tablaMascotasPerdidas
						.convertRowIndexToModel(tablaMascotasPerdidas
								.getSelectedRow());
				int indexcol = 5;
				String IDseleccionado = (String) tablaMascotasPerdidas.getModel().getValueAt(indexfila, indexcol);
				Predicate<ReporteAnimal> filtroID = new Predicate<ReporteAnimal>() {
					public boolean test(ReporteAnimal t) {
						return t.getAnimalReportado().getChipIdentificacion().equals(IDseleccionado);
					}
				};
				
				Mascotas.mascotasRegistradas.stream().filter(filtroID).forEach(p->correoDueno=p.getCorreoContacto());
				new VentanaCorreo(correoDueno);
				
			}
		});
		
//		setModal (true);
		setAlwaysOnTop(true);
//		setModalityType (ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setVisible(true);
		
		
	}
	
	
	
	public void llenarTabla(ReporteAnimal animalSeleccionado){
		String col[] = {"Tipo", "Raza", "Color", "Sexo", "Chip ID", "Nombre"};
		modeloMascotasPerdidas = new DefaultTableModel(col, 0) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {
				return columna > 8;
			}
		};
		System.out.println(animalSeleccionado.getAnimalReportado().getNombreMascota());
		if(animalSeleccionado!=null){
			cargarDatos(animalSeleccionado);
		}
		
		tablaMascotasPerdidas = new JTable(modeloMascotasPerdidas);
		
		tablaMascotasPerdidas.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablaMascotasPerdidas.setPreferredScrollableViewportSize(new Dimension(766, 458));
		tablaMascotasPerdidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaMascotasPerdidas.setRowHeight(60);
		tablaMascotasPerdidas.setRowSelectionAllowed(true);
		
		NormalCellRenderer normal = new NormalCellRenderer(tablaMascotasPerdidas, listaPath);
		tablaMascotasPerdidas.getColumn("Tipo").setCellRenderer(normal);
		tablaMascotasPerdidas.getColumn("Raza").setCellRenderer(normal);
		tablaMascotasPerdidas.getColumn("Color").setCellRenderer(normal);
		tablaMascotasPerdidas.getColumn("Sexo").setCellRenderer(normal);
		tablaMascotasPerdidas.getColumn("Chip ID").setCellRenderer(normal);
		tablaMascotasPerdidas.getColumn("Nombre").setCellRenderer(normal);
		
		JTableHeader cabecera = tablaMascotasPerdidas.getTableHeader();
		cabecera.setForeground(new Color(255, 255, 255));
		cabecera.setBackground(new Color(69, 147, 160));
		
		
	}
	
	public void anadirAlModel(Animal animal){
		String Tipo = animal.getTipoMascota();
		String Raza = animal.getRaza();
		String Color = animal.getColor();
		String Sexo = animal.getSexo();
		String Chip = animal.getChipIdentificacion();
		String Nombre = animal.getNombreMascota();
		
		Object[] nuevaFila = {Tipo, Raza, Color, Sexo, Chip, Nombre};
		modeloMascotasPerdidas.addRow(nuevaFila);
	}
	public void cargarDatos(ReporteAnimal animalSeleccionado) { 
		listaPath.clear();
		Mascotas totalMascotas = Mascotas.getInstance();
		
		Comparaciones.PetFinder(animalSeleccionado);
		Comparaciones.resultadoPetFinder.forEach(p->anadirAlModel(p.getAnimalReportado()));
		
	}

	
	
	
}
