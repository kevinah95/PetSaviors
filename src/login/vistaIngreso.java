/**====================================================================================
 * Proyecto     : PetSaviors
 * Archivo      : vistaIngreso.java » Paquete: login » Proyecto: PetSaviors 
 * Autores      : Kevin Hernández Rostrán, Jasson Moya Álvarez, 
 *				  Julián Méndez Oconitrillo, José Aguilar Quesada.
 * Curso        : Programación Orientada a Objetos - Instituto Tecnológico de Costa Rica
 * Descripcion  : Sistema para mascotas pérdidas - encontradas
 **==================================================================================== 
 */

package login;

import javax.swing.*;
import menu.principal.PrincipalNormal;
import java.awt.*;

public class vistaIngreso extends JFrame {
	static CardLayout cardlayout = new CardLayout();
	static JPanel panelCards;
	
	public vistaIngreso() {
		setSize(1280, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		panelCards = new JPanel();
		panelCards.setBounds(0, 0, 784, 561);
		setContentPane(panelCards);
		panelCards.setLayout(cardlayout);
		
		
		agregarPaneles();
		
		setVisible(true);
	}
	
	
	public void agregarPaneles(){
		
		vistaLogIn login = new vistaLogIn();
		panelCards.add("Ingresar",login);
		
		vistaRegistrarme registrarme = new vistaRegistrarme();
		panelCards.add("vistaRegistrarme",registrarme);
		
		PrincipalNormal principalnormal = new PrincipalNormal();
		panelCards.add("PrincipalNormal",principalnormal);
		
		cardlayout.show(panelCards, "Ingresar");
	}

	
	public static void main(String[] args) {
		new vistaIngreso();
	}

}
