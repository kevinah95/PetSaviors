package logicaExterna;


import individuos.Regular;







import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;





public class Usuarios implements java.io.Serializable{
	public static List<Regular> usuariosRegistrados = new ArrayList<Regular>();
	private static Usuarios instance = null;
	protected static final String dirFileUsuarios = "Pet_Saviors/data/usuarios.json";
	final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
	
	
	protected Usuarios() {	// Disimular instancia 
	}
	public static Usuarios getInstance() {
		if (instance == null) {	instance = new Usuarios(); }
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
	
	public static void verificarArchivo() throws IOException { 
		File file = new File(dirFileUsuarios);
    	if (file.getParentFile().mkdirs()) {
    	    file.createNewFile();
    	    System.out.println(file.getParentFile());
    	    JOptionPane.showMessageDialog(null, "Directorio CREADO: "+file.getCanonicalPath());
    	} 
	}
	
	
	

}
