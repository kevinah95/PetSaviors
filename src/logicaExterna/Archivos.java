package logicaExterna;

import individuos.*;
import logicaInterna.*;
import java.io.*;

public class Archivos {
	
	protected static final String dirFileRegist = "Pet_Saviors/data/regist.txt";  
	protected static final String dirFileConfig = "Pet_Saviors/data/config.txt";
	private static int toleranciaAdopcion = 0;
	private static int toleranciaComparacion = 0;
	
	public boolean verificarArchivoDatos() throws IOException { 
		File file = new File(dirFileRegist);
    	if (file.isFile())
    	    return true;
		return false; }
	
	public boolean verificarArchivoConfig() throws IOException { 
		File file = new File(dirFileConfig);
    	if (file.isFile())
    	    return true;
		return false; }
	
	public static void guardarEstadoActualSistema () {
		File archivo = new File(dirFileRegist);
		try {
			FileWriter w = new FileWriter(archivo.getAbsolutePath() + java.io.File.separator);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			for (Animal mascota : Animal.animalesSistema) {
				String entradaTxt = mascota.toString();
				wr.write(entradaTxt);
				bw.newLine();}
			for (Individuo persona : Individuo.individuosInvolucrados) {
				String entradaTxt = persona.toString();
				wr.write(entradaTxt);
				bw.newLine();}
			wr.close();
			bw.close();}
		catch(IOException e){
			e.printStackTrace();}}
	
	public static void recuperarEstadoSistema (){
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] novoEntrada = null;
		try {
			archivo = new File (dirFileRegist); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea;
			while((linea=br.readLine()) != null){
			    novoEntrada = linea.split(";");
			    if ("Individuo".equals(novoEntrada[0])){
			   		}
			   	if ("Animal".equals(novoEntrada[0])) {
			   		}
			    }
			fr.close();}
		catch(Exception e){
			e.printStackTrace();}}
	
	public static void cargarConfiguracion () {
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		String[] novoEntrada = null;
		try {
			archivo = new File (dirFileConfig); 
			fr = new FileReader (archivo.getAbsolutePath() + java.io.File.separator);
			br = new BufferedReader(fr);	 
			String linea;
			while((linea=br.readLine()) != null){
				novoEntrada = linea.split(";");
				if (novoEntrada[0].equals("Configuración") && novoEntrada[1].equals("false")){ //Implica que el sistema ya fue configurado una vez.
					System.out.println("El sistema tomará los datos necesarios de este txt. ");
				}
				else {
					System.out.println("El sistema debe configurarse desde la pantalla de inicio.");
					break;}
			}
			fr.close();}
		catch(Exception e){
			e.printStackTrace();}}
	
	public static void guardarConfiguracion () {
		
		
		
		//Inserte la función aquí. 
		
		
		
	}
	
}
