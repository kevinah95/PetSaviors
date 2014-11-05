package render.listas;

import java.awt.*;
import javax.swing.*;
import menu.principal.PrincipalNormal;

public class RenderPrincipal implements ListCellRenderer{
	
		  protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();
		
		  public Component getListCellRendererComponent(JList list, Object value, int index,
		      boolean isSelected, boolean cellHasFocus) {
			  
		    JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index,
		        isSelected, cellHasFocus);
		   
			renderer.setIcon(new ImageIcon(PrincipalNormal.class.getResource("/recursos/punta.png")));
		    renderer.setBackground(new Color(130, 177, 166));
		    renderer.setPreferredSize(new Dimension(79, 50));
		    renderer.setBorder(null);
		    if (!cellHasFocus){
		    	renderer.setIcon(null);
		    }else{
		    	renderer.setForeground(new Color(255, 255, 255));
		    	renderer.setBackground(new Color(68, 108, 98));
		    }
		    return renderer;
	}
}
