package logicaInterna;

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
		Individuo manolo = new Individuo ("0101123", "Juli�n","M�ndez","Oconitrillo","22152150", "menoc.sk27@gmail.com", "contrase�a12345", "false");	
		System.out.println(manolo.toString());
		
		manolo.reportarMascota("Perro","Huski",
								"Blanco","Afuerita de mi chante",
								"Encontrado","0101","No","124124","macho");
		
		for (ReporteAnimal animal : ReporteAnimal.animalesSistema)
			System.out.println(animal.toString());
	}
}
