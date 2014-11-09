package logicaExterna;

import logicaInterna.ReporteAnimal;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import com.google.gson.*;

public class Mascotas extends Archivos implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	public static ArrayList<ReporteAnimal> mascotasRegistradas = new ArrayList<ReporteAnimal>();
	private static Mascotas instance = null;
	protected static final String dirFileMascotas = "Pet_Saviors/data/mascotas.json";
	
	public static Mascotas getInstance() {
		if (instance == null) {	instance = new Mascotas(); instance.cargar(); }
		return instance;
	}
	
	public void agregarMascotas(ReporteAnimal nuevaMascota){
		mascotasRegistradas.add(nuevaMascota);
	}

	public void actualizarJson() {
		final String representacionJson = prettyGson.toJson(mascotasRegistradas);
	    System.out.println(representacionJson);
		try {
			FileWriter w = new FileWriter(dirFileMascotas);
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
		JsonParser parser = new JsonParser();
		String representacion = null;
		try { representacion = representacion(); } catch (IOException e) { e.printStackTrace();}
	    JsonArray jArray = parser.parse(representacion).getAsJsonArray();
	    for(JsonElement obj : jArray )
	    {
	        ReporteAnimal mascota = prettyGson.fromJson( obj , ReporteAnimal.class);
	        mascotasRegistradas.add(mascota);
	    }
	}
	
	public String representacion() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dirFileMascotas));
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
		File file = new File(dirFileMascotas);
    	if (file.getParentFile().mkdirs()) {
    	    file.createNewFile();
    	    System.out.println(file.getParentFile());
    	    JOptionPane.showMessageDialog(null, "Directorio CREADO: "+file.getCanonicalPath());
    	} 
	}
}

