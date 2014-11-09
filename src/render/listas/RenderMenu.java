package render.listas;

import java.awt.*;
import javax.swing.*;
import menu.principal.VistaPrincipal;

public class RenderMenu implements ListCellRenderer{
	
		  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
		
		  public Component getListCellRendererComponent(JList list, Object value, int index,
		      boolean isSelected, boolean cellHasFocus) {
			  
		    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
		        isSelected, cellHasFocus);
		   
		    renderer.setBackground(new Color(130, 177, 166));
		    renderer.setPreferredSize(new Dimension(50, 30));
		    renderer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		    renderer.setBorder(null);
		    if (!cellHasFocus){
		    	
		    }else{
		    	renderer.setForeground(new Color(255, 255, 255));
		    	renderer.setBackground(new Color(68, 108, 98));
		    }
		    return renderer;
	}
}
