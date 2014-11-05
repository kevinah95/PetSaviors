package logicaExterna;


import individuos.Regular;











import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;





public class Usuarios implements java.io.Serializable{
	public static List<Regular> usuariosRegistrados = new ArrayList<Regular>();
	private static Usuarios instance = null;
	protected static final String dirFileUsuarios = "Pet_Saviors/data/usuarios.json";
	final static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
	
	
	protected Usuarios() {	// Disimular instancia 
	}
	public static Usuarios getInstance() {
		if (instance == null) {	instance = new Usuarios(); cargarUsuarios(); }
		return instance;
	}
	
	public void agregarUsuario(Regular nuevoUsuario){
		usuariosRegistrados.add(nuevoUsuario);
	}

	public void actualizarJsonUsuarios() {
		final String representacionJson = prettyGson.toJson(usuariosRegistrados);
	    System.out.println(representacionJson);
		try {
			FileWriter w = new FileWriter(dirFileUsuarios);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write(representacionJson);
			wr.close();
			bw.close();}
		catch(IOException e){
			e.printStackTrace();}
	    
	}
	
	private static void cargarUsuarios(){
		JsonParser parser = new JsonParser();
		String representacion = null;
		try { representacion = representacion(); } catch (IOException e) { e.printStackTrace();}
	    JsonArray jArray = parser.parse(representacion).getAsJsonArray();
	    for(JsonElement obj : jArray )
	    {
	        Regular regular = prettyGson.fromJson( obj , Regular.class);
	        usuariosRegistrados.add(regular);
	    }
	}
	
	private static String representacion() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dirFileUsuarios));
		try {
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = br.readLine();
			}
			return sb.toString();
		} finally {
			br.close();
		}
	}
	
	public static void verificarArchivo() throws IOException { 
		File file = new File(dirFileUsuarios);
    	if (file.getParentFile().mkdirs()) {
    	    file.createNewFile();
    	    System.out.println(file.getParentFile());
    	    JOptionPane.showMessageDialog(null, "Directorio CREADO: "+file.getCanonicalPath());
    	} 
	}
	
	
	

}
