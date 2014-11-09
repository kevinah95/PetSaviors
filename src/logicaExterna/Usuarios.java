package logicaExterna;

import individuos.Individuo;

import java.io.*;
import java.util.*;

import javax.swing.*;

import com.google.gson.*;

public class Usuarios extends Archivos implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	public static List<Individuo> usuariosRegistrados = new ArrayList<Individuo>();
	private static Usuarios instance = null;
	protected static final String dirFileUsuarios = "Pet_Saviors/data/usuarios.json";
	
	public static Usuarios getInstance() {
		if (instance == null) {	instance = new Usuarios(); instance.cargar(); }
		return instance;
	}
	
	public void agregarUsuario(Individuo nuevoUsuario){
		usuariosRegistrados.add(nuevoUsuario);
	}

	public void actualizarJson() {
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
			e.printStackTrace();
		}    
	}
	
	public void cargar(){
		try {
			verificarArchivo();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String representacion = null;
		try { representacion = representacion(); } catch (IOException e) { e.printStackTrace();}
		if(!representacion.trim().isEmpty()){
			JsonParser parser = new JsonParser();
		    JsonArray jArray = parser.parse(representacion).getAsJsonArray();
		    for(JsonElement obj : jArray )
		    {
		        Individuo individuo = prettyGson.fromJson( obj , Individuo.class);
		        usuariosRegistrados.add(individuo);
		    }
		}
		
	}
	
	public String representacion() throws IOException {
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
	
	public void verificarArchivo() throws IOException { 
		File file = new File(dirFileUsuarios);
		
		
    	if (!file.exists() && !file.isDirectory()) {
    		file.getParentFile().mkdirs();
    		file.createNewFile();
    		JOptionPane.showMessageDialog(null, "Directorio CREADO: "+file.getCanonicalPath());
    	} 
	}
}
