package registrar.mascota;

import javax.swing.JLabel;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.DefaultStyledDocument;
import clasificacion.animales.ControlEspecie;
import fabrica.botones.FabricaBotones;
import filtros.document.DocumentSizeFilter;

import javax.swing.JRadioButton;

public class VistaEtapaDatos extends JPanel{
	private static final long serialVersionUID = 1L;
	JTextField txtNombre;
	JTextField txtChip;
	JComboBox<String> cbColor;
	JEditorPane txtDescripcion;
	DefaultStyledDocument doc;
	JLabel remaningLabel;
	JButton btnSiguiente;
	JButton btnAtras;
	JComboBox<String> cbEspecie;
	JComboBox<String> cbRaza;
	JRadioButton rdbtnHembra;
	JRadioButton rdbtnMacho;
	
	String[] colores= {"Rojo","Azul","Verde","Amarillo","Naranja","Morado","Rosa","Marrón","Blanco","Negro"};
	
	final static Font fontTextos = new Font("Segoe UI", Font.BOLD, 13);
	
	//Instancia de suma relevancia debido a la carga de especies
	public ControlEspecie controlEspecie = ControlEspecie.getInstance();
	
	//singleton
	
	
	public VistaEtapaDatos() {
		setLayout(null);
		setSize(600, 600);
		JPanel panelDatos = new JPanel();
		panelDatos.setBounds(57, 5, 470, 563);
		add(panelDatos);
		panelDatos.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 75, 299, 30);
		txtNombre.setBorder(null);
		txtNombre.setOpaque(false);
		txtNombre.setFont(fontTextos);
		txtNombre.setForeground(new Color(27,39,51));
		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtChip = new JTextField();
		txtChip.setOpaque(false);
		txtChip.setForeground(new Color(27, 39, 51));
		txtChip.setFont(fontTextos);
		txtChip.setColumns(10);
		txtChip.setBorder(null);
		txtChip.setBounds(87, 135, 130, 30);
		panelDatos.add(txtChip);
		
		cbColor = new JComboBox();
		cbColor.setModel(new DefaultComboBoxModel<String>(colores));
		cbColor.setBorder(null);
		cbColor.setBackground(Color.WHITE);
		cbColor.setForeground(new Color(27,39,51));
		cbColor.setFont(fontTextos);
		cbColor.setBounds(250, 135, 140, 30);
		cbColor.setUI(ColorArrowUI.createUI(cbColor));
		panelDatos.add(cbColor);
		
		cbRaza = new JComboBox();
		cbRaza.setBorder(null);
		cbRaza.setBackground(Color.WHITE);
		cbRaza.setForeground(new Color(27,39,51));
		cbRaza.setFont(fontTextos);
		cbRaza.setBounds(87, 256, 290, 27);
		cbRaza.setUI(ColorArrowUI.createUI(cbRaza));
		panelDatos.add(cbRaza);
		
		cbEspecie = new JComboBox<String>();
		cbEspecie.setModel(new DefaultComboBoxModel<String>());
		controlEspecie.especiesRegistradas.forEach(p->cbEspecie.addItem(p.getNombre()));
		cbEspecie.setBounds(87, 196, 290, 27);
		cbEspecie.setForeground(new Color(27,39,51));
		cbEspecie.setFont(fontTextos);
		cbEspecie.setBackground(Color.white);
		cbEspecie.setBorder(null);
		cbEspecie.setUI(ColorArrowUI.createUI(cbEspecie));
		panelDatos.add(cbEspecie);
		
		ButtonGroup groupGenero = new ButtonGroup();
		
		
		rdbtnMacho = new JRadioButton("");
		rdbtnMacho.setContentAreaFilled(false);
		rdbtnMacho.setBounds(159, 318, 21, 23);
		rdbtnMacho.setSelected(true);
		panelDatos.add(rdbtnMacho);
		
		rdbtnHembra = new JRadioButton("");
		rdbtnHembra.setContentAreaFilled(false);
		rdbtnHembra.setBounds(260, 318, 21, 23);
		panelDatos.add(rdbtnHembra);
		groupGenero.add(rdbtnMacho);
		groupGenero.add(rdbtnHembra);
		
		
		remaningLabel = new JLabel();
		txtDescripcion = new JEditorPane();
		doc = new DefaultStyledDocument();
		doc.setDocumentFilter(new DocumentSizeFilter(200));
		doc.addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateCount();
			}
			public void insertUpdate(DocumentEvent e) {
				updateCount();
			}
			public void removeUpdate(DocumentEvent e) {
				updateCount();
			}
		});
		txtDescripcion.setDocument(doc);
		
		txtDescripcion.setFont(new Font("Segoe UI", Font.BOLD, 12));
		txtDescripcion.setForeground(new Color(27,39,51));
		remaningLabel.setBackground(new Color(0,0,0,0.0f));
		remaningLabel.setForeground(new Color(27,39,51));
		updateCount();
		
		JPanel panelTextPane = new JPanel();
		panelTextPane.setBounds(87, 373, 290, 104);
		panelTextPane.setBackground(new Color(0,0,0,0.0f));
		panelTextPane.setLayout(new BorderLayout());
		panelTextPane.add(txtDescripcion, BorderLayout.CENTER);
		panelTextPane.add(remaningLabel, BorderLayout.SOUTH);
		panelDatos.add(panelTextPane);
		
		btnSiguiente = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Siguiente");
		btnSiguiente.setFont(fontTextos);
		btnSiguiente.setForeground(Color.WHITE);
		btnSiguiente.setBounds(264, 503, 131, 41);
		panelDatos.add(btnSiguiente);
		
		btnAtras = FabricaBotones.crearBoton(FabricaBotones.TRANSPARENTE, "Atrás");
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setFont(fontTextos);
		btnAtras.setBounds(130, 503, 131, 41);
		panelDatos.add(btnAtras);

		JLabel lblBGDatos = new JLabel("");
		lblBGDatos.setBounds(0, 0, 470, 560);
		panelDatos.add(lblBGDatos);
		lblBGDatos.setIcon(new ImageIcon(VistaEtapaDatos.class.getResource("/recursos/RegistrarMascota.png")));
		setVisible(true);
	}
	
	
	
	
	
	private void updateCount() {
		remaningLabel.setText((200 - doc.getLength()) + " caracteres restantes");
		revalidate();
		repaint();
	}
	
	public void limpiarRegistros(){
		txtNombre.setText("");
		txtChip.setText("");
		cbColor.setSelectedIndex(0);
		rdbtnMacho.setSelected(true);
		txtDescripcion.setText("");
		
	}
	
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
}
