package logicaExterna;

import java.io.*;
import com.google.gson.*;

public abstract class Archivos implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	final static Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();
	protected abstract void actualizarJson( );
	protected abstract void cargar();
	protected abstract String representacion() throws IOException;
	protected abstract void verificarArchivo() throws IOException;
	
	
	public static void guardarConfiguracion () {}
	
}
