package registrar.CasaCuna;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.basic.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.*;

import logicaExterna.Mascotas;
import logicaInterna.ReporteAnimal;
import clasificacion.animales.ControlEspecie;
import fabrica.botones.FabricaBotones;
import filtros.document.DocumentSizeFilter;

public class VistaCasaCuna extends JFrame {
	private static final long serialVersionUID = 1L;
	public VistaCasaCuna() {
		setLayout(null);
		setSize(486, 600);
		setBackground(new Color(102, 204, 204));
		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(new Color(179, 209, 202));
		panelDatos.setBounds(0, 0, 470, 563);
		getContentPane().add(panelDatos);
		panelDatos.setLayout(null);
		
		txtLugar = new JTextField();
		txtLugar.setBounds(50, 101, 299, 30);
		txtLugar.setBorder(null);
		txtLugar.setOpaque(false);
		txtLugar.setFont(fontTextos);
		txtLugar.setForeground(new Color(27,39,51));
		panelDatos.add(txtLugar);
		txtLugar.setColumns(10);
		
		textField = new JEditorPane();
		doc = new DefaultStyledDocument();
		doc.setDocumentFilter(new DocumentSizeFilter(270));
		textField.setDocument(doc);
		textField.setFont(new Font("Segoe UI", Font.BOLD, 12));
		textField.setForeground(new Color(27,39,51));
		JPanel panelTextPane = new JPanel();
		panelTextPane.setBounds(47, 393, 350, 97);
		panelTextPane.setBackground(new Color(0,0,0,0.0f));
		panelTextPane.setLayout(new BorderLayout());
		panelTextPane.add(textField, BorderLayout.CENTER);
		panelDatos.add(panelTextPane);
		
		btnAceptar = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Aceptar");
		btnAceptar.setFont(fontTextos);
		btnAceptar.setForeground(Color.WHITE);
		btnAceptar.setBounds(334, 506, 131, 41);
		panelDatos.add(btnAceptar);
		
		btnCancelar = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(fontTextos);
		btnCancelar.setBounds(213, 506, 131, 41);
		panelDatos.add(btnCancelar);
		
		checkBox = new JCheckBox();
		checkBox.setBounds(370, 340, 24,20);
		checkBox.setOpaque(false);
		checkBox.setIcon(new ImageIcon(getClass().getResource("/recursos/notSelected.png")));
		checkBox.setSelectedIcon(new ImageIcon(getClass().getResource("/recursos/Selected.png")));
		panelDatos.add(checkBox);
		
		String col[] = {"Especie", "Seleccionar"};
		DefaultTableModel modelo = new DefaultTableModel(col, 0);
		for(int i = 0; i < controlEspecie.especiesRegistradas.size(); i++) {
			Object[] especie = {controlEspecie.especiesRegistradas.get(i).getNombre(), false};
			modelo.addRow(especie);
		}
		tabla = new JTable(modelo) {
	        public Class getColumnClass(int column) {
                switch (column) {
                	case 0: 
                		return String.class;
                	default:
                		return Boolean.class;
                }
	       }
		};
		tabla.setBounds(100, 200, 200, 200);
		JScrollPane panelLista = new JScrollPane(tabla, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panelLista.setBounds(50, 190, 357, 137);
		panelDatos.add(panelLista);
		
		JLabel lblCasaCuna = new JLabel("");
		lblCasaCuna.setBounds(0, 0, 470, 560);
		panelDatos.add(lblCasaCuna);
		lblCasaCuna.setIcon(new ImageIcon(VistaCasaCuna.class.getResource("/recursos/ImagenRegistroCasaCuna.png")));
		
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	JTextField txtLugar;
	JButton btnAceptar;
	JButton btnCancelar;
	JButton btnAgregar;
	JEditorPane textField;
	DefaultStyledDocument doc;
	JCheckBox checkBox;
	JTable tabla;
	final static Font fontTextos = new Font("Segoe UI", Font.BOLD, 13);
	public ControlEspecie controlEspecie = ControlEspecie.getInstance();
	private static VistaCasaCuna instance = null;
	
	
	
	
	static class ColorArrowUI extends BasicComboBoxUI {
	    public static ComboBoxUI createUI(JComponent c) { return new ColorArrowUI(); }
	    protected JButton createArrowButton() {
	    	BasicArrowButton boton = new BasicArrowButton(BasicArrowButton.SOUTH);
	    	boton.setBorder(BorderFactory.createEmptyBorder());
	    	boton.setBackground(Color.WHITE);
	    	boton.setRolloverEnabled(false);
	    	boton.setContentAreaFilled(false);
	        return boton;
	    }
	}

	public static void main(String[] arg) {
		VistaCasaCuna prueba = new VistaCasaCuna();
		
	}
}