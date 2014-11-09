package clasificacion.animales;

import java.io.*;
import java.util.*;

import javax.swing.JOptionPane;

import com.google.gson.*;

public class ControlEspecie {

	public static List<Especie> especiesRegistradas = new ArrayList<Especie>();
	protected static final String dirFileEspecies = "Pet_Saviors/data/especies.json";
	private static ControlEspecie instance = null;
	final static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
	
	public ControlEspecie() {	} // Disimular instancia 
	public static ControlEspecie getInstance() {
		if (instance == null) {	instance = new ControlEspecie(); cargarEspecies(); }
		return instance;
	}
	
	public void addEspecie(Especie pEspecie){
		especiesRegistradas.add(pEspecie);
	}
	
	public void actualizarJsonEspecies(){
		final String representacionJson = prettyGson.toJson(especiesRegistradas);
	    System.out.println(representacionJson);
	    try {
			FileWriter w = new FileWriter(dirFileEspecies);
			BufferedWriter bw = new BufferedWriter(w);
			PrintWriter wr = new PrintWriter(bw);
			wr.write(representacionJson);
			wr.close();
			bw.close();}
		catch(IOException e){
			e.printStackTrace();
		} 
	}
	
	private static void cargarEspecies(){
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
		        Especie individuo = prettyGson.fromJson( obj , Especie.class);
		        especiesRegistradas.add(individuo);
		    }
		}
		
	}
	
	private static String representacion() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(dirFileEspecies));
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
		File file = new File(dirFileEspecies);
		
		
    	if (!file.exists() && !file.isDirectory()) {
    		file.getParentFile().mkdirs();
    		file.createNewFile();
    		JOptionPane.showMessageDialog(null, "Directorio CREADO: "+file.getCanonicalPath());
    	} 
	}

}
