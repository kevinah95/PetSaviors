package login;

import individuos.Individuo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.Predicate;

import javax.swing.JOptionPane;

import menu.principal.PrincipalNormal;





public class ControladorLogIn implements ActionListener{
	
	ModeloLogIn modelo=null;
	vistaLogIn vista = null;
	
	
	public ControladorLogIn() {
		this.modelo = ModeloLogIn.getInstance();
		this.vista = vistaLogIn.getInstance();
		setAcciones(this);
	}
	
	private void setAcciones(ActionListener escuchador){
		vista.btnRegistrarme.addActionListener(escuchador);
		vista.btnEntrar.addActionListener(escuchador);
	}
	
	Predicate<Individuo> predicadoCedula = new Predicate<Individuo>() {
		public boolean test(Individuo t) {
			return t.getIdentificacion().equals(vista.txtCedula.getText());
		}
	};
	Predicate<Individuo> predicadoContrasena = new Predicate<Individuo>() {
		public boolean test(Individuo t) {
			return t.getContrasena().equals(vista.txtContrasenia.getText());
		}
	};
	Predicate<Individuo> predicadoFull = predicadoCedula.and(predicadoContrasena);

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==vista.btnRegistrarme){
			if (!vista.txtCedula.getText().equals("Usuario") && 
					!vista.txtContrasenia.getText().equals("Contrasenia")){ limpiarDatos(); }
			vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "vistaRegistrarme");
			vista.getParent().revalidate();
			vista.getParent().repaint();
		}
		
		if (e.getSource()==vista.btnEntrar){
			modelo.verificarDatos(predicadoFull);
			if (modelo.ACCESO_CONCEDIDO==true){
				entrarASistema();
			}else{
				JOptionPane.showMessageDialog(null, "Datos Incorrectos");
			}
		}
		
	}
	
	private void entrarASistema(){
		vistaIngreso.cardlayout.show(vistaIngreso.panelCards, "PrincipalNormal");
		PrincipalNormal.listaMenu.requestFocus();
		vista.getParent().revalidate();
		vista.getParent().repaint();
	}

	public void limpiarDatos(){
		vista.txtCedula.setText("");
		vista.txtContrasenia.setText("");
	}

}
