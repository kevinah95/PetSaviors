package logicaInterna;

import java.util.ArrayList;

public class Comparaciones {
	//Pet Finder
	public static ArrayList<ReporteAnimal> resultadoPetFinder = new ArrayList<ReporteAnimal>();
	
	private static ArrayList<String> todosDatosDisponibles ( ReporteAnimal animalAnalizado ){
		String condicion =  animalAnalizado.getCondicionEntrada();
		ArrayList<String> datosPorComparar = new ArrayList<String>();
		datosPorComparar.add("");
		datosPorComparar.add(Integer.toString(animalAnalizado.getAnimalReportado().getIdAnimal()));
		datosPorComparar.add(condicion);
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getTipoMascota());
		datosPorComparar.add(animalAnalizado.getTelefonoContacto());
		datosPorComparar.add(animalAnalizado.getCorreoContacto());
		datosPorComparar.add(Integer.toString(animalAnalizado.getDiasSistema()));
		int cantidadDatos = 1; //No comienza en 0 porque automáticamente evalúa los dias en el sistema.
		if (!animalAnalizado.getAnimalReportado().getRaza().equals("No")){//System.out.println(animalAnalizado.getRaza());
			cantidadDatos ++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getRaza());
		if (!animalAnalizado.getAnimalReportado().getColor().equals("No")){//System.out.println(animalAnalizado.getColor());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getColor());
		if (!animalAnalizado.getLugarContacto().equals("No")){//System.out.println(animalAnalizado.getLugarContacto());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getLugarContacto());
		if (!animalAnalizado.getAnimalReportado().getChipIdentificacion().equals("No")){//System.out.println(animalAnalizado.getChipIdentificacion());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getChipIdentificacion());
		if (!animalAnalizado.getAnimalReportado().getNombreMascota().equals("No")){//System.out.println(animalAnalizado.getNombreMascota());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getNombreMascota());
		System.out.println(cantidadDatos);
		datosPorComparar.set(0,Integer.toString(cantidadDatos));
		return datosPorComparar;}
	
	private static int cantidadSemejanzas(ArrayList<String>datosComparar, ReporteAnimal comparacionContra){
		int contadorSemejanzas = 0;
		int contadorComparaciones = 0;
		for (String dato : datosComparar ){//System.out.println(dato);
			if (!dato.equals("No")){
				if (contadorComparaciones == 3) {//System.out.println("Comparando Tipo: "+dato+ " vs "+comparacionContra.getTipoMascota());
					if (!dato.equals(comparacionContra.getAnimalReportado().getTipoMascota())){	
						contadorSemejanzas = -1;break;}} //Si el dato Tipo de mascota es diferente, no hace falta comparar más
				if (contadorComparaciones == 6) { //Dias //Hacer cálculo entre cantidad de dias (tolerancia Comparacion)
					if (comparacionContra.getDiasSistema() - Integer.parseInt(dato) < 30) //Cambiar 30 por variable de tolerancia
						contadorSemejanzas++;}
				if (contadorComparaciones == 7) { //Raza //System.out.println("Comparando Raza: "+dato+ " vs "+comparacionContra.getRaza());
					if (dato.equals(comparacionContra.getAnimalReportado().getRaza())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 8) { //Color //System.out.println("Comparando Color: "+dato+ " vs "+comparacionContra.getColor());
					if (dato.equals(comparacionContra.getAnimalReportado().getColor())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 9) { //Lugar //System.out.println("Comparando Lugar: "+dato+" vs "+comparacionContra.getLugarContacto());
					if (dato.equals(comparacionContra.getLugarContacto())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 10) { //Chip  //System.out.println("Comparando Chip: "+dato+" vs "+comparacionContra.getChipIdentificacion());
					if (dato.equals(comparacionContra.getAnimalReportado().getChipIdentificacion())){
						contadorSemejanzas = -2;break;}} //Si el chip es igual, se trata diferente (Es 95% probable que se trate de la mascota
				if (contadorComparaciones == 11) {	//Nombre //System.out.println("Comparando Nombre: "+dato+ " vs "+comparacionContra.getNombreMascota());
					if (dato.equals(comparacionContra.getAnimalReportado().getNombreMascota())){
						contadorSemejanzas++;}}
			}//System.out.println("Contador C "+contadorComparaciones + "\nContador S "+contadorSemejanzas);
			contadorComparaciones++;}
		return contadorSemejanzas;}
	
	public static void PetFinder(ReporteAnimal animalPorComparar){
		ArrayList<String> datos = todosDatosDisponibles(animalPorComparar);
		resultadoPetFinder.clear();
		for ( ReporteAnimal animal : ReporteAnimal.animalesSistema ){
			if (!datos.get(1).equals(Integer.toString(animal.getAnimalReportado().getIdAnimal()))){
				animal.getAnimalReportado().setContadorSemejanzas(cantidadSemejanzas (datos, animal)); //Setea la variable para ordenamiento de cada animal
				if ( cantidadSemejanzas (datos, animal) > 0 ){
					resultadoPetFinder.add(animal);}
				if ( cantidadSemejanzas (datos, animal) == -2){
					resultadoPetFinder.add(0,animal);}	}}
		ordenarResultados();
		porcentajeSimilitud(Integer.parseInt(datos.get(0)));}
	
	private static void porcentajeSimilitud (int semejanzasAnimalAnalizado){
		for (ReporteAnimal animal : resultadoPetFinder ){
			if (animal.getAnimalReportado().getContadorSemejanzas() != -2){
				float contadorSeteadoSemejanzas = animal.getAnimalReportado().getContadorSemejanzas();
				animal.getAnimalReportado().setContadorSemejanzas((contadorSeteadoSemejanzas*100)/semejanzasAnimalAnalizado);}}}
	
	private static void ordenarResultados ( ) {
		//Bubble sort comparando los contadores de semejanzas
		for(int i = 0; i<resultadoPetFinder.size(); i++){
			for(int j = i; j<resultadoPetFinder.size(); j++){
				if( resultadoPetFinder.get(i).getAnimalReportado().getContadorSemejanzas() 
						< resultadoPetFinder.get(j).getAnimalReportado().getContadorSemejanzas() ) { //La posición 1 es el contador de Semejanzas 
					ReporteAnimal aux = resultadoPetFinder.get(i); 
					resultadoPetFinder.set(i,resultadoPetFinder.get(j)); 
					resultadoPetFinder.set(j,aux); }}} 
		for (ReporteAnimal animal : resultadoPetFinder){
			if (animal.getAnimalReportado().getContadorSemejanzas() == -2){
				resultadoPetFinder.remove(resultadoPetFinder.indexOf(animal));
				resultadoPetFinder.add(0,animal);}}}
	
	public static void main (String[] args){
		ReporteAnimal perrito1 = new ReporteAnimal ("Perro","Pastor Alemán","Negro",
									  "22152150", "menoc.sk27@gmail.com",
									  "Pavas", "Encontrado", "No","direccionFoto",
									  "Maximus Gorrerus", "0","Macho");
		ReporteAnimal perrito2 = new ReporteAnimal ("Perro","Pastor Italiano","Rojo",
				 					  "22152150", "menoc.sk27@gmail.com",
				 					  "No", "Encontrado", "011","direccionFoto",
				 					  "Maximus", "0","Macho");
		ReporteAnimal perrito3 = new ReporteAnimal ("Perro", "Pastor Alemán", "Negro",
									  "22222222", "jasc!gmail.com", 
									  "Pavas", "Nada", "No", "ashskdf", 
									  "Maximus Gorrerus", "002","Macho");
		ReporteAnimal perrito4 = new ReporteAnimal ("Perro", "Pastor Alemán", "Tirando a Rojo",
				 					  "22222222", "jasc!gmail.com", 
				 				      "Pavas", "Nada", "010", "ashskdf", 
				 					  "Maximus Gorrerus", "002","Macho");
		
		ReporteAnimal.animalesSistema.add(perrito1);
		ReporteAnimal.animalesSistema.add(perrito2);
		ReporteAnimal.animalesSistema.add(perrito3);
		ReporteAnimal.animalesSistema.add(perrito4);
		
		PetFinder(perrito1);
		System.out.println("Pet Finder: ");
		for (ReporteAnimal animal : resultadoPetFinder){
			System.out.println(animal.toString() +"\n" + animal.getAnimalReportado().getContadorSemejanzas() + "%");}
	}
}
