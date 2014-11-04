package logicaExterna;

import java.text.SimpleDateFormat;
import java.util.*;

public class Tiempo {
	
	//Generaci�n de un calendario ficticio para la aplicaci�n
	private static final String[] meses = {"Enero","Febrero","Marzo", "Abril", 
									"Mayo", "Junio", "Julio", "Agosto",
									"Setiembre", "Octubre", "Noviembre", "Diciembre"};
	//Las variables que se usan para la simulaci�n
	private static int contadorDias = 0; 
	private static int diaSistema = 0;
	private static int mesSistema = 0;
	private static int a�oSistema = 0;
	private static String mesMuestraSistema = "";
	private static Date fechaReal;
	
	//Los d�as que se sumar�n
	public static int getContadorDias() {return contadorDias;}
	public static void setContadorDias(int contadorDias) {Tiempo.contadorDias = contadorDias;}
	
	//La fecha real, con tiempo. 
	public static String getFechaReal() {
		SimpleDateFormat mascara = new SimpleDateFormat ("dd;MM;yyyy");
		return mascara.format(fechaReal);}
	public static void setFechaReal() {
		Calendar calendario;
		calendario = Calendar.getInstance();
		fechaReal = (Date) calendario.getTime();}
	
	//Para hacer las simulaciones
	public static void simularCambioDia () {
		setContadorDias(getContadorDias() + 1);
		calcularFechaSistema();}
	public static void simularCambioDia (int cantDias) {
		setContadorDias(getContadorDias() + cantDias);
		calcularFechaSistema();}
	
	//Auxiliar para determinar si un a�o es bisiesto o no
	public static boolean isBisiesto (int a�o) {
		int cont = 0;
		while ( cont < a�o ){
			cont += 4;
			if ( cont == a�o ) {
				return true; }}
		return false;}
	
	//El c�lculo de c�mo queda la nueva fecha del sistema.
	//Primero, obtengo la fecha real y la descompongo
	public static void calcularFechaReal () {
			setFechaReal();
			String[] descomposici�nFecha = getFechaReal().split(";");
			String diaReal = descomposici�nFecha[0];
			String mesReal = descomposici�nFecha[1];
			String a�oReal = descomposici�nFecha[2];
			
			//Luego seteo los valores enteros para el c�lculo
			diaSistema = Integer.parseInt(diaReal);
			mesSistema = Integer.parseInt(mesReal)-1;
			mesMuestraSistema = meses[mesSistema];
			a�oSistema = Integer.parseInt(a�oReal);
			//Muestro que se obtuvo la fecha real
			/*
			System.out.println("Fecha real: ");
			System.out.println("Dia del sistema: "+diaSistema+
								", Mes del sistema: "+mesMuestraSistema+
								", A�o del sistema: "+a�oSistema);*/
	}
	public static void calcularFechaSistema (){
		if ( contadorDias > 0 ){
			int diaObjetivo = contadorDias;
			int diasSumados = 0;
			while ( diaObjetivo > diasSumados ) {
			 	//Si me encuentro en un mes de 30 dias
				if (mesSistema == 3 || mesSistema == 5 || mesSistema == 8 || mesSistema == 10 ){
					while ( diaObjetivo > diasSumados ) {
						diaSistema ++;
						diasSumados ++;
						if ( diaSistema > 30 ){ //Se produce un cambio de mes
							mesSistema ++;
							diaSistema = 1;
							break;}}}
				//Si estoy en un mes de 31 dias
				if (mesSistema == 0 || mesSistema == 2 || mesSistema == 4 || mesSistema == 6 		
						|| mesSistema == 7 || mesSistema == 9 || mesSistema == 10 || mesSistema == 11){
					while ( diaObjetivo > diasSumados ) {
						diaSistema ++;
						diasSumados ++;
						if ( diaSistema > 31 && mesSistema == 0 ){ //Se produce un cambio de mes hacia febrero
							mesSistema = 1;
							diaSistema = 1;
							break;}
						if ( diaSistema > 31 && mesSistema != 0 && mesSistema != 11 ){ //Se produce un cambio de mes hacia cualquiera menos febrero
							mesSistema ++;
							diaSistema = 1;
							break;}
						if ( diaSistema > 31 && mesSistema == 11  ){ //Se produce un cambio de a�o
							mesSistema = 0;
							diaSistema = 1;
							a�oSistema ++;
							break;}}}
				//Si estoy en febrero
				if (mesSistema == 1) {
					while ( diaObjetivo > diasSumados ) {
						diaSistema ++;
						diasSumados ++;
						if (isBisiesto(a�oSistema) == true) { //Si el a�o es bisiesto
							if ( diaSistema > 29 && a�oSistema != 0 ){ 	//Se produce un cambio de mes
								mesSistema ++;
								diaSistema = 1;
								break;}}
						if (isBisiesto(a�oSistema) == false) { //Si el a�o no es bisiesto
							if ( diaSistema > 28 && a�oSistema != 0 ){ 	//Se produce un cambio de mes
								mesSistema ++;
								diaSistema  = 1;
								break;}}}}
			}	//Fin del ciclo while para sumar dias
		}	//Fin del if (contadorDias > 0 )
		//Presento los cambios
		mesMuestraSistema = meses[mesSistema];
		//Muestro el resultado del c�lculo
		/*
		System.out.println("Fecha generada");
		System.out.println("Dia del sistema: "+diaSistema+
							", Mes del sistema: "+mesMuestraSistema+
							", A�o del sistema: "+a�oSistema);*/
		setContadorDias(0);} //Finalizado el proceso, reseteo el contador de d�as
	
	public static String fechaSistema () { //Retorna la fecha del sistema cada vez, tomando en cuenta los cambios
		String msg = diaSistema + "/" +
					 mesMuestraSistema + "/" +
					 a�oSistema;
		return msg;}
	
}
