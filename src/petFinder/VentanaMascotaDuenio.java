package petFinder;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import logicaExterna.Mascotas;
import menu.principal.VistaPrincipal;
import net.coobird.thumbnailator.Thumbnails;

public class VentanaMascotaDuenio extends JPanel{
	//Esta clase va a contener una JTable con los animales que tiene el usuario.
	public static JTable tabla;
	private DefaultTableModel modeloMascotasDuenio;
	private JPanel panelContenedor = new JPanel();
	private TableRowSorter<DefaultTableModel> sorter;
	private GridBagConstraints grid = new GridBagConstraints();
	
	public static ArrayList<String> listaPath = new ArrayList<>();
	
	public VentanaMascotaDuenio() {
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
		modeloMascotasDuenio = new DefaultTableModel(col, 0){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int fila, int columna) {
				return columna > 8;
			}
		};
		
		tabla = new JTable(modeloMascotasDuenio);
		
		//Aquí se usa un ciclo para llenar la tabla
		llenarTabla();
		
		sorter = new TableRowSorter<DefaultTableModel>(modeloMascotasDuenio);
		
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
	
	private void llenarTabla() {
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
					}
					else {
						listaPath.add("");
					}
					Object[] nuevaFila = {Tipo, Raza, Color, Sexo, Chip, Nombre};
					modeloMascotasDuenio.addRow(nuevaFila);
				}
			}
		}
	}
}
