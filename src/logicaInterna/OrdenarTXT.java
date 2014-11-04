package logicaInterna;

import java.io.*;
import java.util.*;

public class OrdenarTXT {

	public OrdenarTXT() {}
	
	private static String dirFile  = OrdenarTXT.class.getResource("/razasMascotas.txt").getFile();
	private static String dirFile2  = OrdenarTXT.class.getResource("/regMascotas.txt").getFile(); 
			
	public static ArrayList<String> lineas = new ArrayList<String>();
	
	public static void editarInformacion () {
		File archivo = new File(dirFile);
		try {
			FileWriter w = new FileWriter(archivo.getAbsolutePath() + java.io.File.separator);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			for (String mascotaS : lineas) {
				wr.write(mascotaS);
				bw.newLine();}
			wr.close();
			bw.close();}
		catch(IOException e){
			e.printStackTrace();}}
	
	public static void cargarInformacion (){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File (dirFile); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea;
			String [] entrada = null;
			lineas.clear();
			while((linea=br.readLine()) != null){
				entrada = linea.split(";");
			    lineas.add(entrada[0]);}
			fr.close(); }
		catch(Exception e){
			e.printStackTrace();}}
	
	public static void cargarInformacionR (){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			archivo = new File (dirFile2); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea;
			lineas.clear();
			while((linea=br.readLine()) != null){
			    lineas.add(linea);}
			fr.close(); }
		catch(Exception e){
			e.printStackTrace();}}
	
	public static void ordenarAlfabeticamente () {
		String datos[] = new String[lineas.size()]; 
		String D = "";
		int cont = 0;
		for(String masc : lineas){ 
			datos[cont]= masc;
			cont++;}  
		for(int i = 0; i<datos.length; i++){ 
			D=D+ " "+(datos[i]); 
			D=D +";"; } 
		//Bubble sort usando compareTo (que devuelve un entero con la valoración de los String)
		for(int i = 0; i<datos.length; i++){ 
			for(int j = i; j<datos.length; j++){ 
				if(datos[i].toUpperCase().compareTo(datos[j].toUpperCase())>0) { 
					String aux = datos[i]; 
					datos[i] = datos[j]; 
					datos[j] = aux; }}} 
		lineas.clear();
		for(int j = 0; j<datos.length; j++){ 
			lineas.add(datos[j]); }}
	
	public static void main (String [] args){
		cargarInformacion();
		for (String d : lineas){
			System.out.println(d);
		}
		
		cargarInformacionR();
		for (String d : lineas){
			System.out.println(d);
		}
		
//		editarInformacion();
	}
}
