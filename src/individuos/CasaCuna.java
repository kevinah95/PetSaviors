package individuos;

public class CasaCuna {

	public CasaCuna(String pUbicacionCasa,
					String pTipoMascota,
					String pTama�o,
					String pRequiereAlimento, 
					String pRequerimientosAdicionales)
	{
		setUbicacionCasa(pUbicacionCasa);
		setTipoMascota(pTipoMascota);
		setTama�o(pTama�o);
		setRequiereAlimento(Boolean.parseBoolean(pRequiereAlimento));
		setRequerimientosAdicionales(pRequerimientosAdicionales);
	}
	
	private String ubicacionCasa,tipoMascota,tama�o = null;
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
	public String getTama�o() {
		return tama�o;}
	public void setTama�o(String tama�o) {
		this.tama�o = tama�o;}
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
				+ tama�o + ";"
				+ requiereAlimento + ";"
				+ requerimientosAdicionales;
	}
}
