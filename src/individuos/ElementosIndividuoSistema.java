package individuos;

import java.util.ArrayList;

import logicaInterna.Actividad;
import logicaInterna.Animal;

public class ElementosIndividuoSistema {

	public ElementosIndividuoSistema() 
	{
		cantIndividuos++;
		setIdentificadorIndividuo(cantIndividuos);
		setReportes(new ArrayList<Animal>());
	}
	
	protected static int cantIndividuos = 0;
	protected int identificadorIndividuo = 0;
	protected ArrayList<Actividad> eventosParticipado = new ArrayList<Actividad>();
	private ArrayList<Animal> reportes;	
	
	public static int getCantIndividuos() {
		return cantIndividuos;}
	public static void setCantIndividuos(int cantClientes) {
		cantIndividuos = cantClientes;}
	public int getIdentificadorIndividuo() {
		return identificadorIndividuo;}
	public void setIdentificadorIndividuo(int identificadorCliente) {
		this.identificadorIndividuo = identificadorCliente;}
	public ArrayList<Actividad> getEventosParticipado() {
		return eventosParticipado;}
	public void setEventosParticipado(ArrayList<Actividad> eventosParticipado) {
		this.eventosParticipado = eventosParticipado;}
	public ArrayList<Animal> getReportes() {
		return reportes;}
	public void setReportes(ArrayList<Animal> reportes) {
		this.reportes = reportes;}
	
	@Override
	public String toString() {
		return "ElementosIndividuoSistema [identificadorIndividuo="
				+ identificadorIndividuo + ", eventosParticipado="
				+ eventosParticipado + ", reportes=" + reportes + "]";
	}
	
}
