package reportesActivos;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import correosRedesSociales.VentanaCorreo;
import logicaExterna.Mascotas;
import menu.principal.VistaPrincipal;

public class VentanaOpciones extends JDialog {
	public VentanaOpciones(String Identificacion) {
		getContentPane().setBackground(new Color(153, 204, 204));
		getContentPane().setLayout(null);
		
		JButton btnContactar = new JButton("");
		btnContactar.setIcon(new ImageIcon(VentanaOpciones.class.getResource("/recursos/Lupa.png")));
		btnContactar.setBounds(48, 31, 71, 68);
		getContentPane().add(btnContactar);
		btnContactar.setBorder(null);
		btnContactar.setContentAreaFilled(false);
		btnContactar.setOpaque(false);
		btnContactar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String correo = obtenerAnimal(Identificacion);
				if(!correo.equals("")) {
					new VentanaCorreo(correo);
					dispose();
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "No existe la mascota que desea adoptar");
				}
			}
		});
		
		JButton btnAdoptar = new JButton("");
		btnAdoptar.setIcon(new ImageIcon(VentanaOpciones.class.getResource("/recursos/corazon.png")));
		btnAdoptar.setBounds(171, 31, 77, 68);
		getContentPane().add(btnAdoptar);
		btnAdoptar.setBorder(null);
		btnAdoptar.setContentAreaFilled(false);
		btnAdoptar.setOpaque(false);
		btnAdoptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(VistaPrincipal.getUsuario().isAdoptante()) {
					String correo = obtenerAnimal(Identificacion);
					if(!correo.equals("")) {
						new VentanaCorreo(correo);
						dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "Usted no es adoptante, por lo tanto no puede adoptar");
				}
					
			}
		});
		
		JLabel Contactar = new JLabel("Contactar Due\u00F1o");
		Contactar.setHorizontalAlignment(SwingConstants.CENTER);
		Contactar.setBounds(20, 97, 114, 37);
		getContentPane().add(Contactar);
		
		JLabel lblAdoptar = new JLabel("Adoptar");
		lblAdoptar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdoptar.setBounds(171, 97, 89, 37);
		getContentPane().add(lblAdoptar);
		setSize(300, 200);
		setModal (true);
		setAlwaysOnTop(true);
		setModalityType (ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public String obtenerAnimal(String identificacion) {
		Mascotas totalMascotas = Mascotas.getInstance();
		String nuevoDato = "";
		for(int i = 0; i < totalMascotas.mascotasRegistradas.size(); i++) {
			if(totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getChipIdentificacion().equals(identificacion) && 
					totalMascotas.mascotasRegistradas.get(i).getCondicionEntrada().toLowerCase().equals("encontrado")) {
				nuevoDato = totalMascotas.mascotasRegistradas.get(i).getCorreoContacto();
			}
		}
		return nuevoDato;	
	}
}
