package petFinder;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.*;

import menu.principal.*;

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
		setLayout(new CardLayout(0, 0));
		add(panelContenedor, "name_181084789481483");
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
		String path1 = "/recursos/Peludito.jpg";
		String path2 = "/recursos/Miaucito.jpg";
		ArrayList<String> listaPath = new ArrayList<>();
		listaPath.add(path1);
		listaPath.add(path2);
		modelo.addRow(datos);
		Object[] datos1 = {"333333", "Gato", "Peterbald", "Blanco", "Hembra", "33EE212", "Miaucito <3"};
		modelo.addRow(datos1);
		sorter = new TableRowSorter<DefaultTableModel>(modelo);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tabla.setPreferredScrollableViewportSize(new Dimension(766, 458));
		tabla.setRowSorter(sorter);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.setRowHeight(60);
		tabla.setRowSelectionAllowed(true);
		
		tabla.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				PrincipalNormal.panelImagenAnimal.removeAll();
				JLabel labelImagen = new JLabel();
				String path = listaPath.get(tabla.getSelectedRow());
				System.out.println(path);
				labelImagen.setIcon(new ImageIcon(getClass().getResource(path)));
				PrincipalNormal.panelImagenAnimal.add(labelImagen, BorderLayout.CENTER);
				PrincipalNormal.panelImagenAnimal.setVisible(true);
				PrincipalNormal.panelImagenAnimal.repaint();
				PrincipalNormal.panelImagenAnimal.revalidate();
			}
		});
		
		NormalCellRenderer normal = new NormalCellRenderer();
		tabla.getColumn("ID").setCellRenderer(normal);
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
	
	public static class NormalCellRenderer extends JLabel implements TableCellRenderer {
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
				}
		  
		       return this;
		}
	}
}
