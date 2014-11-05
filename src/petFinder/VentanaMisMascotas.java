package petFinder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import java.awt.Font;

public class VentanaMisMascotas extends JPanel {
	//Esta clase va a contener una JTable con los animales que tiene el usuario.
	private JTable tabla;
	private DefaultTableModel modelo;
	private JPanel panelContenedor = new JPanel();
	private TableRowSorter<DefaultTableModel> sorter;
	private GridBagConstraints grid = new GridBagConstraints();
	
	public VentanaMisMascotas() {
		setSize(766, 458);
		setBackground(new Color(155, 196, 188));
		//setLayout(null);
		hacerTabla();
		add(panelContenedor);
	}
	
	public void hacerTabla() {
		
		panelContenedor.removeAll();
		
		String col[] = {"ID", "Tipo", "Raza", "Color", "Sexo", "Chip ID", "Nombre"};
		modelo = new DefaultTableModel(col, 0){
			public boolean isCellEditable(int fila, int columna) {
				return columna > 8;
			}
		};
		
		tabla = new JTable(modelo);
		
		//Aquí se usa un ciclo para llenar la tabla
		//Se supone que le debería pasar una lista o algo así
		//Ejemplo:
		Object[] datos = {"222341", "Perro", "Komondor", "Negro", "Macho", "44RT12", "Peludito :3"};
		modelo.addRow(datos);
		sorter = new TableRowSorter<DefaultTableModel>(modelo);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tabla.setPreferredScrollableViewportSize(new Dimension(766, 458));
		tabla.setRowSorter(sorter);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		NormalCellRenderer normal = new NormalCellRenderer();
		tabla.getColumn("ID").setCellRenderer(normal);
		tabla.getColumn("Tipo").setCellRenderer(normal);
		tabla.getColumn("Raza").setCellRenderer(normal);
		tabla.getColumn("Color").setCellRenderer(normal);
		tabla.getColumn("Sexo").setCellRenderer(normal);
		tabla.getColumn("Chip ID").setCellRenderer(normal);
		tabla.getColumn("Nombre").setCellRenderer(normal);
		
		JScrollPane scrollPanel = new JScrollPane(tabla,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		grid.fill = GridBagConstraints.BOTH;
		panelContenedor.add(scrollPanel, grid);
	}
	
	public static class NormalCellRenderer extends JLabel implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value,
				boolean isSelected, boolean hasFocus, int row, int column) {

				setToolTipText("<html><p>"+(String)value+"</p></html>");
				setHorizontalAlignment(SwingConstants.CENTER);
				setText((String)value);
				setForeground(Color.WHITE);
				setOpaque(true);
				setBackground(Color.DARK_GRAY);
		  
		       return this;
		}
	}
}
