package pruebaListas;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.*;

import net.coobird.thumbnailator.Thumbnails;
import logicaExterna.Mascotas;
import logicaInterna.ReporteAnimal;
import menu.principal.*;

public class VentanaMisMascotas extends JFrame {
	private static final long serialVersionUID = 1L;
	//Esta clase va a contener una JTable con los animales que tiene el usuario.
	public static JTable tabla;
	private  MyTableModel modelo;
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
		setVisible(true);
	}
	
	public void hacerTabla() {
		
		panelContenedor.removeAll();
		
		String col[] = {"Tipo", "Raza", "Color", "Sexo", "Chip ID", "Nombre"};
		modelo = new MyTableModel();
		modelo.setData(Mascotas.getInstance().mascotasRegistradas, col);
		
		tabla = new JTable(modelo);
		
		//Aquí se usa un ciclo para llenar la tabla
//		llenarTabla();
		
		//Se supone que le debería pasar una lista o algo así
		//Ejemplo:
		//Object[] datos = {"222341", "Perro", "Komondor", "Negro", "Macho", "44RT12", "Peludito :3"};
//		String path1 = "/recursos/Peludito.jpg";
//		String path2 = "/recursos/Miaucito.jpg";
//		listaPath.add(path1);
//		listaPath.add(path2);
		//modelo.addRow(datos);
		//Object[] datos1 = {"333333", "Gato", "Peterbald", "Blanco", "Hembra", "33EE212", "Miaucito <3"};
		//modelo.addRow(datos1);
//		sorter = new TableRowSorter<DefaultTableModel>(modelo);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setPreferredScrollableViewportSize(new Dimension(766, 458));
//		tabla.setRowSorter(sorter);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setRowHeight(60);
		tabla.setRowSelectionAllowed(true);
				
//		NormalCellRenderer normal = new NormalCellRenderer();
//		tabla.getColumn("Tipo").setCellRenderer(normal);
//		tabla.getColumn("Raza").setCellRenderer(normal);
//		tabla.getColumn("Color").setCellRenderer(normal);
//		tabla.getColumn("Sexo").setCellRenderer(normal);
//		tabla.getColumn("Chip ID").setCellRenderer(normal);
//		tabla.getColumn("Nombre").setCellRenderer(normal);
		panelContenedor.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPanel = new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		grid.fill = GridBagConstraints.BOTH;
		panelContenedor.add(scrollPanel, "name_181078707065095");
				
		JTableHeader cabecera = tabla.getTableHeader();
		cabecera.setForeground(new Color(255, 255, 255));
		cabecera.setBackground(new Color(69, 147, 160));
	}
	
//	public void llenarTabla() { 
//		Mascotas totalMascotas = Mascotas.getInstance();
//		//VistaPrincipal instanciaVP = VistaPrincipal.getInstance();
//		for(int i = 0; i < totalMascotas.mascotasRegistradas.size(); i++) {
//			//if(instanciaVP.getUsuario().getIdentificacion().equals(totalMascotas.mascotasRegistradas.get(i).getIdentificacionReportante())) {
//			//	System.out.println("Diay pos soy yo");
//			//}
//			String Tipo = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getTipoMascota();
//			String Raza = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getRaza();
//			String Color = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getColor();
//			String Sexo = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getSexo();
//			String Chip = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getChipIdentificacion();
//			String Nombre = totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getNombreMascota();
//			
//			String pathImagen = totalMascotas.mascotasRegistradas.get(i).getFotosAnimal().get(0);
//			if(!pathImagen.isEmpty()) {
//				listaPath.add(pathImagen);
//			}
//			else {
//				listaPath.add("");
//			}
//			Object[] nuevaFila = {Tipo, Raza, Color, Sexo, Chip, Nombre};
//			modelo.addRow(nuevaFila);
//		}
//	}
	
	public static void main(String[] args){
		new VentanaMisMascotas();
	}
	
	public static class NormalCellRenderer extends JLabel implements TableCellRenderer {
		private static final long serialVersionUID = 1L;
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {

				setToolTipText("<html><p>"+(String)value+"</p></html>");
				setHorizontalAlignment(SwingConstants.CENTER);
				setText((String)value);
				setForeground(new Color(14, 28, 29));
				setOpaque(true);
				setBackground(new Color(127, 200, 176));
				if(isSelected) {
					setBackground(new Color(200, 232, 221));
					String path = VentanaMisMascotas.listaPath.get(tabla.convertRowIndexToModel(tabla.getSelectedRow()));
					if(!path.equals("")) {
						VistaPrincipal.panelImagenAnimal.removeAll();
						JLabel labelImagen = new JLabel();
						BufferedImage imagen = null;
						try {
							imagen = Thumbnails.of(getClass().getResource(path))
									.size(227, 230)
									.asBufferedImage();
						} catch (IOException e) {
							e.printStackTrace();
						}
						labelImagen.setIcon(new ImageIcon(imagen));
						VistaPrincipal.panelImagenAnimal.add(labelImagen, BorderLayout.CENTER);
						VistaPrincipal.panelImagenAnimal.setVisible(true);
						VistaPrincipal.panelImagenAnimal.repaint();
						VistaPrincipal.panelImagenAnimal.revalidate();
					}
				}
		  
		       return this;
		}
	}
}

class MyTableModel extends AbstractTableModel {
	private String[] columnNames ;
	

	private List<ReporteAnimal> data = new ArrayList<ReporteAnimal>();
	/**
	 * @param data the data to set
	 */
	public void setData(List<ReporteAnimal> data,String[] col) {
		this.data = data;
		this.columnNames = col;
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public Object getValueAt(int row, int col) {
		return data.get(row).getAnimalReportado();
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}

	/*
	 * Don't need to implement this method unless your table's editable.
	 */
	public boolean isCellEditable(int row, int col) {
		// Note that the data/cell address is constant,
		// no matter where the cell appears onscreen.
		if (col < 2) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Don't need to implement this method unless your table's data can change.
	 */
	public void setValueAt(Object value, int row, int col) {
//		data.get(row).setNom((String) value); 
		fireTableCellUpdated(row, col);
	}

}
