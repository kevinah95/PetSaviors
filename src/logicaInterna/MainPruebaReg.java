package logicaInterna;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;



import individuos.*;

public class MainPruebaReg {
	
	//Generar casos de prueba
	/* Principales: 
	 * 		-Log In.
	 * 		-RegistrarMascota Animal.
	 * 		-Editar Datos del Animal.
	 * 		-Revisar todos los animales reportados.
	 * 		-Revisar todos los animales en el sistema.
	 * 		-Adoptar animal.
	 * 		-Contactar usuarios casa Cuna (tirar el array de usuarios con los que tienen booleano Casa Cuna. 
	 * 		-Modificar datos del animal para colocarlo en una casa Cuna. 
	 * 		-Pet Finder.
	 */
	
	public static void main (String [] args){
		Individuo manolo = new Individuo ("0101123", "Julián","Méndez","Oconitrillo","22152150", "menoc.sk27@gmail.com", "contraseña12345", "false");	
		System.out.println(manolo.toString());
		
		manolo.reportarMascota("Perro","Huski",
								"Blanco","Afuerita de mi chante",
								"Encontrado","0101","No","124124","macho");
		
		String[] s = {"as.png","as.png","as.png"};
		ArrayList<String> fotos= new ArrayList<String>(); 
		Collections.addAll(fotos, s);
		for (ReporteAnimal animal : ReporteAnimal.animalesSistema){
			animal.setFotosAnimal(fotos);
			System.out.println(animal.toString());
		}
	}
}
