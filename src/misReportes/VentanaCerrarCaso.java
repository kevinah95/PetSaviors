package misReportes;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import logicaExterna.Mascotas;
import menu.principal.VistaPrincipal;
import reportesActivos.VentanaOpciones;
import correosRedesSociales.VentanaCorreo;



public class VentanaCerrarCaso extends JDialog {
	public VentanaCerrarCaso(String Identificacion) {
		getContentPane().setBackground(new Color(166, 214, 204));
		getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(VentanaCerrarCaso.class.getResource("/recursos/Cerrar.png")));
		btnNewButton.setBounds(95, 11, 89, 80);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				boolean condicion = cambiarEstadoAnimal(Identificacion);
				if(condicion) {
					JOptionPane.showMessageDialog(getContentPane(), "El cambio se hizo correctamente");
				}
				else {
					JOptionPane.showMessageDialog(getContentPane(), "No se hizo el cambio");
				}
			}
		});
		
		JLabel lblNewLabel = new JLabel("CERRAR CASO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 102, 180, 41);
		getContentPane().add(lblNewLabel);
		setSize(300, 200);
		setModal (true);
		setAlwaysOnTop(true);
		setModalityType (ModalityType.APPLICATION_MODAL);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
	
	public boolean cambiarEstadoAnimal(String identificacion) {
		Mascotas totalMascotas = Mascotas.getInstance();
		boolean condicion = false;
		for(int i = 0; i < totalMascotas.mascotasRegistradas.size(); i++) {
			if(totalMascotas.mascotasRegistradas.get(i).getAnimalReportado().getChipIdentificacion().equals(identificacion)) {
				totalMascotas.mascotasRegistradas.get(i).setCondicionSalida("true");
				condicion = true;
			}
		}
		return condicion;
	}
}

