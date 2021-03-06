package logicaInterna;

import java.util.ArrayList;
import logicaExterna.Mascotas;

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
		int cantidadDatos = 1; //No comienza en 0 porque autom�ticamente eval�a los dias en el sistema.
		if (!animalAnalizado.getAnimalReportado().getRaza().equals("No")){//
			//System.out.println(animalAnalizado.getAnimalReportado().getRaza());
			cantidadDatos ++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getRaza());
		if (!animalAnalizado.getAnimalReportado().getColor().equals("No")){//
			//System.out.println(animalAnalizado.getAnimalReportado().getColor());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getColor());
		if (!animalAnalizado.getLugarContacto().equals("No")){//
			//System.out.println(animalAnalizado.getLugarContacto());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getLugarContacto());
		if (!animalAnalizado.getAnimalReportado().getChipIdentificacion().equals("No")){//
			//System.out.println(animalAnalizado.getAnimalReportado().getChipIdentificacion());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getChipIdentificacion());
		if (!animalAnalizado.getAnimalReportado().getNombreMascota().equals("No")){//
			//System.out.println(animalAnalizado.getAnimalReportado().getNombreMascota());
			cantidadDatos++;}
		datosPorComparar.add(animalAnalizado.getAnimalReportado().getNombreMascota());
		//System.out.println(cantidadDatos);
		datosPorComparar.set(0,Integer.toString(cantidadDatos));
		return datosPorComparar;}
	
	private static int cantidadSemejanzas(ArrayList<String>datosComparar, ReporteAnimal comparacionContra){
		int contadorSemejanzas = 0;
		int contadorComparaciones = 0;
		for (String dato : datosComparar ){//System.out.println(dato);
			if (!dato.equals("No")){
				if (contadorComparaciones == 3) {//System.out.println("Comparando Tipo: "+dato+ " vs "+comparacionContra.getTipoMascota());
					if (!dato.equals(comparacionContra.getAnimalReportado().getTipoMascota())){	
						contadorSemejanzas = -1;break;}} //Si el dato Tipo de mascota es diferente, no hace falta comparar m�s
				if (contadorComparaciones == 6) { //Dias //Hacer c�lculo entre cantidad de dias (tolerancia Comparacion)
					if (comparacionContra.getDiasSistema() - Integer.parseInt(dato) < ConfiguracionSistema.toleranciaComparacion)
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
						contadorSemejanzas = -2;break;}}
				if (contadorComparaciones == 11) {	//Nombre //System.out.println("Comparando Nombre: "+dato+ " vs "+comparacionContra.getNombreMascota());
					if (dato.equals(comparacionContra.getAnimalReportado().getNombreMascota())){
						contadorSemejanzas++;}}
				if (contadorComparaciones == 12) {	//Sexo //System.out.println("Comparando Sexo: "+dato+ " vs "+comparacionContra.getAnimalReportado().getSexo());
					if (!dato.equals(comparacionContra.getAnimalReportado().getSexo())){
						contadorSemejanzas = -1;break;}} //No es necesario comparar sexos opuestos
			}//System.out.println("Contador C "+contadorComparaciones + "\nContador S "+contadorSemejanzas);
			contadorComparaciones++;}
		return contadorSemejanzas;}
	
	public static void PetFinder(ReporteAnimal animalPorComparar){
		ArrayList<String> datos = todosDatosDisponibles(animalPorComparar);
		resultadoPetFinder.clear();
		for ( ReporteAnimal animal : Mascotas.mascotasRegistradas ){
			if (!datos.get(1).equals(Integer.toString(animal.getAnimalReportado().getIdAnimal()))){
				if (animalPorComparar.getCondicionEntrada() != animal.getCondicionEntrada()){
					if (animal.getCondicionSalida().equals("false") ){
						animal.getAnimalReportado().setContadorSemejanzas(cantidadSemejanzas (datos, animal)); //Setea la variable para ordenamiento de cada animal
						if ( cantidadSemejanzas (datos, animal) > 0 ){
							resultadoPetFinder.add(animal);}
						if ( cantidadSemejanzas (datos, animal) == -2){
							resultadoPetFinder.add(0,animal);}}}}}
		ordenarResultados();
		porcentajeSimilitud(Integer.parseInt(datos.get(0)));}
	
	private static void porcentajeSimilitud (int semejanzasAnimalAnalizado){
		for (ReporteAnimal animal : resultadoPetFinder ){
			if (animal.getAnimalReportado().getContadorSemejanzas() != -2){
				float contadorSeteadoSemejanzas = animal.getAnimalReportado().getContadorSemejanzas();
				//System.out.println(contadorSeteadoSemejanzas);
				animal.getAnimalReportado().setContadorSemejanzas((contadorSeteadoSemejanzas*100)/semejanzasAnimalAnalizado);}
			if (animal.getAnimalReportado().getContadorSemejanzas() == -2)
				animal.getAnimalReportado().setContadorSemejanzas(100);}}
	
	private static void ordenarResultados ( ) {
		//Bubble sort comparando los contadores de semejanzas
		for(int i = 0; i<resultadoPetFinder.size(); i++){
			for(int j = i; j<resultadoPetFinder.size(); j++){
				if( resultadoPetFinder.get(i).getAnimalReportado().getContadorSemejanzas() 
						< resultadoPetFinder.get(j).getAnimalReportado().getContadorSemejanzas() ) { //La posici�n 1 es el contador de Semejanzas 
					ReporteAnimal aux = resultadoPetFinder.get(i); 
					resultadoPetFinder.set(i,resultadoPetFinder.get(j)); 
					resultadoPetFinder.set(j,aux); }}} 
		for (ReporteAnimal animal : resultadoPetFinder){
			if (animal.getAnimalReportado().getContadorSemejanzas() == -2){
				resultadoPetFinder.remove(resultadoPetFinder.indexOf(animal));
				resultadoPetFinder.add(0,animal);}}}
	
	public static void main (String[] args){
		ReporteAnimal perrito1 = new ReporteAnimal ("Perro","Pastor Alem�n","Negro",
									  "22152150", "menoc.sk27@gmail.com",
									  "Pavas", "Encontrado", "010",
									  "Maximus Gorrerus", "0","Macho","001");
		ReporteAnimal perrito2 = new ReporteAnimal ("Perro","Pastor Italiano","Rojo",
				 					  "22152150", "menoc.sk27@gmail.com",
				 					  "No", "Extraviado", "011",
				 					  "Maximus", "0","Macho","002");
		ReporteAnimal perrito3 = new ReporteAnimal ("Perro", "Pastor Alem�n", "Negro",
									  "22222222", "jasc!gmail.com", 
									  "Pavas", "Extraviado", "No",  
									  "Maximus Gorrerus", "002","Macho","004");
		ReporteAnimal perrito4 = new ReporteAnimal ("Perro", "Pastor Alem�n", "Tirando a Rojo",
				 					  "22222222", "jasc!gmail.com", 
				 				      "Pavas", "Extraviado", "010", 
				 					  "Maximus Gorrerus", "002","Macho","005");
		
		Mascotas.mascotasRegistradas.add(perrito1);
		Mascotas.mascotasRegistradas.add(perrito2);
		Mascotas.mascotasRegistradas.add(perrito3);
		Mascotas.mascotasRegistradas.add(perrito4);
		
		PetFinder(perrito1);
		System.out.println("Pet Finder: ");
		for (ReporteAnimal animal : resultadoPetFinder){
			System.out.println(animal.toString() +"\n" + animal.getAnimalReportado().getContadorSemejanzas() + "%");}
	}
}
