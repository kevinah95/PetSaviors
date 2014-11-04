package logicaInterna;

import java.util.ArrayList;

public class Comparaciones {
	//Pet Finder
	private static ArrayList<String> todosDatosDisponibles ( Animal animalAnalizado ){
		String condicion =  animalAnalizado.getCondicionEntrada();
		ArrayList<String> datosPorComparar = new ArrayList<String>();
		datosPorComparar.add("");
		datosPorComparar.add(Integer.toString(animalAnalizado.getIdAnimal()));
		datosPorComparar.add(condicion);
		datosPorComparar.add(animalAnalizado.getTipoMascota());
		datosPorComparar.add(animalAnalizado.getTelefonoContacto());
		datosPorComparar.add(animalAnalizado.getCorreoContacto());
		datosPorComparar.add(Integer.toString(animalAnalizado.getDiasSistema()));
		int cantidadDatos = 1;  //Siempre debe compararse el Tipo de Mascota
		if (!animalAnalizado.getRaza().equals("No")){//System.out.println(animalAnalizado.getRaza());
			cantidadDatos ++;}
		datosPorComparar.add(animalAnalizado.getRaza());
		if (!animalAnalizado.getColor().equals("No")){//System.out.println(animalAnalizado.getColor());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getColor());
		if (!animalAnalizado.getLugarContacto().equals("No")){//System.out.println(animalAnalizado.getLugarContacto());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getLugarContacto());
		if (!animalAnalizado.getChipIdentificacion().equals("No")){//System.out.println(animalAnalizado.getChipIdentificacion());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getChipIdentificacion());
		if (!animalAnalizado.getNombreMascota().equals("No")){//System.out.println(animalAnalizado.getNombreMascota());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getNombreMascota());

		datosPorComparar.set(0,Integer.toString(cantidadDatos));
		return datosPorComparar;}
	
	private static int cantidadSemejanzas(ArrayList<String>datosComparar,Animal comparacionContra){
		int contadorSemejanzas = 0;
		int contadorComparaciones = 0;
		for (String dato : datosComparar ){//System.out.println(dato);
			if (!dato.equals("No")){
				if (contadorComparaciones == 3) {//System.out.println("Comparando Tipo: "+dato+ " vs "+comparacionContra.getTipoMascota());
					if (!dato.equals(comparacionContra.getTipoMascota())){	
						contadorSemejanzas = -1;break;}} //Si el dato Tipo de mascota es diferente, no hace falta comparar más
				if (contadorComparaciones == 6) { //Dias //Hacer cálculo entre cantidad de dias (tolerancia Comparacion)
					if (comparacionContra.getDiasSistema() - Integer.parseInt(dato) < 30) //Cambiar 30 por variable de tolerancia
						contadorSemejanzas++;}
				if (contadorComparaciones == 7) { //Raza //System.out.println("Comparando Raza: "+dato+ " vs "+comparacionContra.getRaza());
					if (dato.equals(comparacionContra.getRaza())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 8) { //Color //System.out.println("Comparando Color: "+dato+ " vs "+comparacionContra.getColor());
					if (dato.equals(comparacionContra.getColor())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 9) { //Lugar //System.out.println("Comparando Lugar: "+dato+" vs "+comparacionContra.getLugarContacto());
					if (dato.equals(comparacionContra.getLugarContacto())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 10) { //Chip  //System.out.println("Comparando Chip: "+dato+" vs "+comparacionContra.getChipIdentificacion());
					if (dato.equals(comparacionContra.getChipIdentificacion())){
						contadorSemejanzas = -2;break;}} //Si el chip es igual, se trata diferente (Es 95% probable que se trate de la mascota
				if (contadorComparaciones == 11) {	//Nombre //System.out.println("Comparando Nombre: "+dato+ " vs "+comparacionContra.getNombreMascota());
					if (dato.equals(comparacionContra.getNombreMascota())){
						contadorSemejanzas++;}}
			}//System.out.println("Contador C "+contadorComparaciones + "\nContador S "+contadorSemejanzas);
			contadorComparaciones++;}
		return contadorSemejanzas;}
	
	public static void PetFinder(Animal animalPorComparar){
		ArrayList<String> datos = todosDatosDisponibles(animalPorComparar);
		Animal.resultadoPetFinder.clear();
		for ( Animal animal : Animal.animalesSistema ){
			if (!datos.get(1).equals(Integer.toString(animal.getIdAnimal()))){
				animal.setContadorSemejanzas(cantidadSemejanzas (datos, animal)); //Setea la variable para ordenamiento de cada animal
				if ( cantidadSemejanzas (datos, animal) > 0 ){
					Animal.resultadoPetFinder.add(animal);}
				if ( cantidadSemejanzas (datos, animal) == -2){
					Animal.resultadoPetFinder.add(0,animal);}	}}
		ordenarResultados();}
	
	private static void ordenarResultados ( ) {
		//Bubble sort comparando los contadores de semejanzas
		for(int i = 0; i<Animal.resultadoPetFinder.size(); i++){ 
			for(int j = i; j<Animal.resultadoPetFinder.size(); j++){
				if( Animal.resultadoPetFinder.get(i).getContadorSemejanzas() 
						< Animal.resultadoPetFinder.get(j).getContadorSemejanzas() ) { //La posición 1 es el contador de Semejanzas 
					Animal aux = Animal.resultadoPetFinder.get(i); 
					Animal.resultadoPetFinder.set(i,Animal.resultadoPetFinder.get(j)); 
					Animal.resultadoPetFinder.set(j,aux); }}} 
		for (Animal animal : Animal.resultadoPetFinder){
			if (animal.getContadorSemejanzas() == -2){
				Animal.resultadoPetFinder.remove(Animal.resultadoPetFinder.indexOf(animal));
				Animal.resultadoPetFinder.add(0,animal);}}}
	
	public static void main (String []args){
		Animal perrito1 = new Animal ("Perro","Pastor Alemán","Negro",
									  "22152150", "menoc.sk27@gmail.com",
									  "Pavas", "Encontrado", "012","direccionFoto",
									  "Maximus Gorrerus", "0");
		Animal perrito2 = new Animal ("Perro","Pastor Italiano","Rojo",
				 					  "22152150", "menoc.sk27@gmail.com",
				 					  "No", "Encontrado", "012","direccionFoto",
				 					  "Maximus", "0");
		Animal perrito3 = new Animal ("Perro", "Pastor Mundano", "Tirando a Rojo",
									  "22222222", "jasc!gmail.com", 
									  "Pavas", "Nada", "010", "ashskdf", 
									  "Maximus Gorrerus", "002");
		Animal perrito4 = new Animal ("Perro", "Pastor Alemán", "Tirando a Rojo",
				 					  "22222222", "jasc!gmail.com", 
				 				      "Pavas", "Nada", "010", "ashskdf", 
				 					  "Maximus Gorrerus", "002");
		
		Animal.animalesSistema.add(perrito1);
		Animal.animalesSistema.add(perrito2);
		Animal.animalesSistema.add(perrito3);
		Animal.animalesSistema.add(perrito4);
		
		PetFinder(perrito1);
		System.out.println("Pet Finder: ");
		for (Animal animal : Animal.resultadoPetFinder){
			System.out.println(animal.toString() +"\n" + animal.getContadorSemejanzas());}
		
	}
}
