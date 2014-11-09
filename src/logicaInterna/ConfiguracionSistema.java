package logicaInterna;

import individuos.Individuo;
import java.util.ArrayList;

public class ConfiguracionSistema 
//Esta clase encapsula las variables globales de configuración
{

	public static int toleranciaAdopcion = 0;
	public static int toleranciaComparacion = 30;
	public static ArrayList<Individuo> listaNegra = new ArrayList<Individuo>();
	public static ArrayList<Individuo> administradores = new ArrayList<Individuo>();
	
}
