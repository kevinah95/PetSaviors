package petFinder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.TableCellRenderer;

import menu.principal.VistaPrincipal;
import net.coobird.thumbnailator.Thumbnails;

public class NormalCellRenderer extends JLabel implements TableCellRenderer {
	
	JTable tabla;
	ArrayList<String> listaPath;
	public NormalCellRenderer(JTable tabla, ArrayList<String> listaPath) {
		this.tabla = tabla;
		this.listaPath = listaPath;
	}
	
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
				String path = listaPath.get(tabla.convertRowIndexToModel(tabla.getSelectedRow()));
				if(!path.equals("")) {
					VistaPrincipal.panelImagenAnimal.removeAll();
					JLabel labelImagen = new JLabel();
					BufferedImage imagen = null;
					try {
						imagen = Thumbnails.of(path)
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
