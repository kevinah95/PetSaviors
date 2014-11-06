package registrar.mascota;

import javax.swing.JDialog;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Consumer;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ComboBoxUI;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.DefaultComboBoxModel;

import clasificacion.animales.ControlEspecie;

import com.sun.org.apache.xerces.internal.impl.RevalidationHandler;

import filtros.document.DocumentSizeFilter;

import javax.swing.JRadioButton;

public class EtapaDatos extends JDialog{
	private JTextField txtNombre;
	private JTextField txtChip;
	private JEditorPane textField;
	private DefaultStyledDocument doc;
	private JLabel remaningLabel;
	public ControlEspecie controlEspecie = ControlEspecie.getInstance();
	String[] listaRaza;
	public EtapaDatos() {
		getContentPane().setLayout(null);
		setSize(600, 600);
		JPanel panelDatos = new JPanel();
		panelDatos.setBounds(57, 5, 470, 550);
		getContentPane().add(panelDatos);
		panelDatos.setLayout(null);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 70, 299, 30);
		txtNombre.setBorder(null);
		txtNombre.setOpaque(false);
		txtNombre.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtNombre.setForeground(new Color(27,39,51));
		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtChip = new JTextField();
		txtChip.setOpaque(false);
		txtChip.setForeground(new Color(27, 39, 51));
		txtChip.setFont(new Font("Segoe UI", Font.BOLD, 15));
		txtChip.setColumns(10);
		txtChip.setBorder(null);
		txtChip.setBounds(87, 130, 299, 30);
		panelDatos.add(txtChip);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBorder(null);
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(87, 251, 290, 27);
		comboBox_1.setUI(ColorArrowUI.createUI(comboBox_1));
		panelDatos.add(comboBox_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel());
		controlEspecie.especiesRegistradas.forEach(p->comboBox.addItem(p.getNombre()));
		comboBox.setBounds(87, 191, 290, 27);
		comboBox.setBackground(Color.white);
		comboBox.setBorder(null);
		comboBox.setUI(ColorArrowUI.createUI(comboBox));
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
		        String especieElegida = (String)cb.getSelectedItem();
		        controlEspecie.especiesRegistradas.stream().filter(
		        		p->p.getNombre().equals(especieElegida)).forEach(
		        				p->listaRaza = p.getListaRazas().toArray(new String[p.getListaRazas().size()]) );
				comboBox_1.setModel(new DefaultComboBoxModel(listaRaza));
			}
		});
		
		
		panelDatos.add(comboBox);
		
		ButtonGroup groupGenero = new ButtonGroup();
		
		
		JRadioButton rdbtnMacho = new JRadioButton("");
		rdbtnMacho.setContentAreaFilled(false);
		rdbtnMacho.setBounds(159, 313, 21, 23);
		panelDatos.add(rdbtnMacho);
		
		JRadioButton rdbtnHembra = new JRadioButton("");
		rdbtnHembra.setContentAreaFilled(false);
		rdbtnHembra.setBounds(260, 313, 21, 23);
		panelDatos.add(rdbtnHembra);
		groupGenero.add(rdbtnMacho);
		groupGenero.add(rdbtnHembra);
		
		
		remaningLabel = new JLabel();
		textField = new JEditorPane();
		doc = new DefaultStyledDocument();
		doc.setDocumentFilter(new DocumentSizeFilter(200));
		doc.addDocumentListener(new DocumentListener() {
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateCount();
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				updateCount();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				updateCount();
			}
		});
		textField.setDocument(doc);
		
		textField.setFont(new Font("Segoe UI", Font.BOLD, 12));
		textField.setForeground(new Color(27,39,51));
		remaningLabel.setOpaque(false);
		remaningLabel.setBackground(new Color(0,0,0,0.0f));
		remaningLabel.setForeground(new Color(27,39,51));
		updateCount();
		
		JPanel panelTextPane = new JPanel();
		panelTextPane.setBounds(87, 368, 290, 104);
		panelTextPane.setBackground(new Color(0,0,0,0.0f));
		panelTextPane.setLayout(new BorderLayout());
		panelTextPane.add(textField, BorderLayout.CENTER);
		panelTextPane.add(remaningLabel, BorderLayout.SOUTH);
		panelDatos.add(panelTextPane);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(264, 498, 131, 41);
		btnSiguiente.setOpaque(false);
		btnSiguiente.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnSiguiente.setContentAreaFilled(false);
		btnSiguiente.setBorder(null);
		btnSiguiente.setForeground(Color.WHITE);
		panelDatos.add(btnSiguiente);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setOpaque(false);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setBorder(null);
		btnCancelar.setBounds(130, 498, 131, 41);
		panelDatos.add(btnCancelar);
		
		
		
		JLabel lblBGDatos = new JLabel("");
		lblBGDatos.setBounds(0, 0, 470, 550);
		panelDatos.add(lblBGDatos);
		lblBGDatos.setIcon(new ImageIcon(EtapaDatos.class.getResource("/recursos/RegistrarMascota2.png")));
		
		setVisible(true);
	}
	
	private void updateCount() {
		remaningLabel.setText((200 - doc.getLength()) + " caracteres restantes");
		revalidate();
		repaint();
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
	public static void main(String[] args){
		new EtapaDatos();
	}
}
