package logicaInterna;

public class Actividad {
	public Actividad(String pTipoEvento, boolean pInvolucraDinero, 
					double pMonto, String pDescripcion) 
	{
		setTipoEvento(pTipoEvento);
		setInvolucraDinero(pInvolucraDinero);
		if (pInvolucraDinero)
			setMonto(pMonto);
		else
			setMonto(0);
		setDescripcion(pDescripcion);
	}
	
	public final String eventosPosibles[] = {"Adopción", "Donación", "Devolución"};
	protected String tipoEvento = null;
	protected boolean involucraDinero = false;
	protected double monto = 0;
	protected String descripcion = null;

	public String getTipoEvento() {
		return tipoEvento;}
	public void setTipoEvento(String tipoEvento) {
		this.tipoEvento = tipoEvento;}
	public boolean isInvolucraDinero() {
		return involucraDinero;}
	public void setInvolucraDinero(boolean involucraDinero) {
		this.involucraDinero = involucraDinero;}
	public double getMonto() {
		return monto;}
	public void setMonto(double monto) {
		this.monto = monto;}
	public String getDescripcion() {
		return descripcion;}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;}

}
