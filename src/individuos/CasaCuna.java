package individuos;

public class CasaCuna {

	public CasaCuna(String pUbicacionCasa,
					String pTipoMascota,
					String pTamaño,
					String pRequiereAlimento, 
					String pRequerimientosAdicionales)
	{
		setUbicacionCasa(pUbicacionCasa);
		setTipoMascota(pTipoMascota);
		setTamaño(pTamaño);
		setRequiereAlimento(Boolean.parseBoolean(pRequiereAlimento));
		setRequerimientosAdicionales(pRequerimientosAdicionales);
	}
	
	private String ubicacionCasa,tipoMascota,tamaño = null;
	private boolean requiereAlimento = false;
	private String requerimientosAdicionales = null;
	
	public String getUbicacionCasa() {
		return ubicacionCasa;}
	public void setUbicacionCasa(String ubicacionCasa) {
		this.ubicacionCasa = ubicacionCasa;}
	public String getTipoMascota() {
		return tipoMascota;}
	public void setTipoMascota(String tipoMascota) {
		this.tipoMascota = tipoMascota;}
	public String getTamaño() {
		return tamaño;}
	public void setTamaño(String tamaño) {
		this.tamaño = tamaño;}
	public boolean isRequiereAlimento() {
		return requiereAlimento;}
	public void setRequiereAlimento(boolean requiereAlimento) {
		this.requiereAlimento = requiereAlimento;}
	public String getRequerimientosAdicionales() {
		return requerimientosAdicionales;}
	public void setRequerimientosAdicionales(String requerimientosAdicionales) {
		this.requerimientosAdicionales = requerimientosAdicionales;}
	
	@Override
	public String toString() {
		return "Individuo;CasaCuna;" 
				+ ubicacionCasa + ";"
				+ tipoMascota + ";"
				+ tamaño + ";"
				+ requiereAlimento + ";"
				+ requerimientosAdicionales;
	}
}
