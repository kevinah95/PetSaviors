package petFinder;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import net.coobird.thumbnailator.Thumbnails;
import logicaExterna.Mascotas;
import menu.principal.*;

public class VentanaMisMascotas extends JPanel {
	private static final long serialVersionUID = 1L;
	//Esta clase va a contener una JTable con los animales que tiene el usuario.
	public static JTable tabla;
	private DefaultTableModel modeloMisMascotas;
	private JPanel panelContenedor = new JPanel();
	private TableRowSorter<DefaultTableModel> sorter;
	private GridBagConstraints grid = new GridBagConstraints();
	
	public static ArrayList<String> listaPath = new ArrayList<>();
	
	public VentanaMisMascotas() {
		setSize(766, 458);
		setBackground(new Color(155, 196, 188));
		//setLayout(null);
		hacerTabla();
		setLayout(new CardLayout(0, 0));
		add(panelContenedor, "name_181084789481483");
	}
	
	public void hacerTabla() {
		
		panelContenedor.removeAll();
		
		String col[] = {"Tipo", "Raza", "Color", "Sexo", "Chip ID", "Nombre"};
		modeloMisMascotas = new DefaultTableModel(col, 0){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {
				return columna > 8;
			}
		};
		
		tabla = new JTable(modeloMisMascotas);
		
		//Aquí se usa un ciclo para llenar la tabla
		llenarTabla();

		sorter = new TableRowSorter<DefaultTableModel>(modeloMisMascotas);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setPreferredScrollableViewportSize(new Dimension(766, 458));
		tabla.setRowSorter(sorter);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setRowHeight(60);
		tabla.setRowSelectionAllowed(true);
				
		NormalCellRenderer normal = new NormalCellRenderer(tabla, listaPath);
		tabla.getColumn("Tipo").setCellRenderer(normal);
		tabla.getColumn("Raza").setCellRenderer(normal);
		tabla.getColumn("Color").setCellRenderer(normal);
		tabla.getColumn("Sexo").setCellRenderer(normal);
		tabla.getColumn("Chip ID").setCellRenderer(normal);
		tabla.getColumn("Nombre").setCellRenderer(normal);
		panelContenedor.setLayout(new CardLayout(0, 0));
		
		
		JScrollPane scrollPanel = new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		grid.fill = GridBagConstraints.BOTH;
		panelContenedor.add(scrollPanel, "name_181078707065095");
				
		JTableHeader cabecera = tabla.getTableHeader();
		cabecera.setForeground(new Color(255, 255, 255));
		cabecera.setBackground(new Color(69, 147, 160));
	}
	
	public void llenarTabla() { 
		listaPath.clear();
		Mascotas totalMascotas = Mascotas.getInstance();
		for(int i = 0; i < totalMascotas.mascotasRegistradas.size(); i++) {
			if(VistaPrincipal.getUsuario().getIdentificacion().equals(totalMascotas.mascotasRegistradas.get(i).getIdentificacionReportante())) {
				if(totalMascotas.mascotasRegistradas.get(i).getCondicionEntrada().toLowerCase().equals("extraviado") &&
						totalMascotas.mascotasRegistradas.get(i).getCondicionSalida().equals("false")) {
				
					String Tipo = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getTipoMascota();
					String Raza = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getRaza();
					String Color = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getColor();
					String Sexo = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getSexo();
					String Chip = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getChipIdentificacion();
					String Nombre = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getNombreMascota();
					
					String pathImagen = totalMascotas.mascotasRegistradas.get(i).getFotosAnimal().get(0);
					if(!pathImagen.isEmpty()) {
						listaPath.add(pathImagen);
					}
					else {
						listaPath.add("");
					}
					Object[] nuevaFila = {Tipo, Raza, Color, Sexo, Chip, Nombre};
					modeloMisMascotas.addRow(nuevaFila);
				}
			}
		}
	}
}
