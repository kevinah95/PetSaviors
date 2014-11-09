package individuos;

import logicaInterna.ConfiguracionSistema;

public class FuncionesAdministrador {
	
	//Variables
	public void cambiarToleranciaAdopcion (int nuevaTolerancia) {
		ConfiguracionSistema.toleranciaAdopcion = nuevaTolerancia;}
	public void cambiarToleranciaComparacion (int nuevaTolerancia){
		ConfiguracionSistema.toleranciaComparacion = nuevaTolerancia;}
	
	//Lista negra
	public void agregarListaNegra (Individuo usuarioMalCalificado){
		ConfiguracionSistema.listaNegra.add(usuarioMalCalificado);}
	public void sacarDeListaNegro (Individuo usuarioRedimido){
		for (Individuo usuario : ConfiguracionSistema.listaNegra)
			if (usuario == usuarioRedimido)
				ConfiguracionSistema.listaNegra.remove(usuario);}
	
	//Administradores
	public void ascenderAdmin (Individuo usuario){
		if (!usuario.isAdministrador())
			usuario.setAdministrador(true);
			ConfiguracionSistema.administradores.add(usuario);}
	public void degradarAdministrador (Individuo usuarioAdministrador){
		if (usuarioAdministrador.isAdministrador()){
			if (!ConfiguracionSistema.administradores.isEmpty()){
				usuarioAdministrador.setAdministrador(false);
				ConfiguracionSistema.administradores.remove(usuarioAdministrador);}}}
}
