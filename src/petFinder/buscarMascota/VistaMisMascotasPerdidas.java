package petFinder.buscarMascota;


import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Dialog.ModalityType;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.JScrollPane;

import petFinder.NormalCellRenderer;
import logicaExterna.Mascotas;
import logicaInterna.Comparaciones;
import logicaInterna.ReporteAnimal;
import menu.principal.VistaPrincipal;


public class VistaMisMascotasPerdidas extends JDialog {
	public JTable tablaMascotasPerdidas;
	public DefaultTableModel modeloMascotasPerdidas;
	
	public static ArrayList<String> listaPath = new ArrayList<>();

	public VistaMisMascotasPerdidas(ReporteAnimal animalSeleccionado) {
		setSize(800, 600);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 93, 747, 384);
		getContentPane().add(scrollPane);
		
		Comparaciones.PetFinder(animalSeleccionado);
		Comparaciones.resultadoPetFinder.forEach(p->System.out.println(p.getAnimalReportado().getContadorSemejanzas()));
		
		tablaMascotasPerdidas = new JTable();
		llenarTabla();
		scrollPane.setViewportView(tablaMascotasPerdidas);
		tablaMascotasPerdidas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		setModal (true);
		setAlwaysOnTop(true);
		setModalityType (ModalityType.APPLICATION_MODAL);
		setResizable(false);
		setVisible(true);
		
		
	}
	
	public void setMascotaReportada(ReporteAnimal mascota){
		
	}
	
	public void llenarTabla(){
		String col[] = {"Tipo", "Raza", "Color", "Sexo", "Chip ID", "Nombre"};
		modeloMascotasPerdidas = new DefaultTableModel(col, 0) {
			
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {
				return columna > 8;
			}
		};
		tablaMascotasPerdidas = new JTable(modeloMascotasPerdidas);
		cargarDatos();
		
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
	
	public void cargarDatos() { 
		listaPath.clear();
		Mascotas totalMascotas = Mascotas.getInstance();
		for(int i = 0; i < totalMascotas.mascotasRegistradas.size(); i++) {
			if(VistaPrincipal.getUsuario().getIdentificacion().equals(totalMascotas.mascotasRegistradas.get(i).getIdentificacionReportante())) {
				if(totalMascotas.mascotasRegistradas.get(i).getCondicionEntrada().toLowerCase().equals("encontrado")) {
				
					String Tipo = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getTipoMascota();
					String Raza = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getRaza();
					String Color = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getColor();
					String Sexo = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getSexo();
					String Chip = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getChipIdentificacion();
					String Nombre = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getNombreMascota();
					
					String pathImagen = totalMascotas.mascotasRegistradas.get(i).getFotosAnimal().get(0);
					if(!pathImagen.isEmpty()) {
						listaPath.add(pathImagen);
						System.out.println(listaPath);
					}
					else {
						listaPath.add("");
					}
					Object[] nuevaFila = {Tipo, Raza, Color, Sexo, Chip, Nombre};
					modeloMascotasPerdidas.addRow(nuevaFila);
				}
			}
		}
	}
	
}
