package registrar.mascota;

import individuos.Individuo;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.function.Predicate;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import logicaInterna.ReporteAnimal;
import menu.principal.VistaPrincipal;
import net.coobird.thumbnailator.Thumbnails;

public class ModeloEtapaImagenes {

	private static ModeloEtapaImagenes instance = null;
	String path="";
	private static final boolean CORRECTA = true;
	private static final boolean INCORRECTA = false;
	private static final File dirTemporal = new File("Pet_Saviors/temp");
	private String indexImagen = null;
	private ArrayList<String> imagenes = new ArrayList<String>();
	protected ModeloEtapaImagenes() {
		
	}
	
	public static ModeloEtapaImagenes getInstance() {
		if (instance == null) {
			instance = new ModeloEtapaImagenes();
			limpiarDirTemporal();
		}
		return instance;
	}
	
	public boolean verificarImagen(){
		path="";
		ElegirImagen();
		if (!path.equals("")){
			return CORRECTA;
		}else{
			return INCORRECTA;
		}
	}
	
	public void ElegirImagen() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images",
				"jpg", "png", "gif", "bmp");
		
		fileChooser.setFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			path = selectedFile.getPath();
			
		}
		
	}
	
	private void guardarCopiaRedimensionada() throws IOException{
		indexImagen = String.valueOf(ControladorEtapaImagenes.btnTemp.getName());
		Thumbnails.of(path)
        .size(300, 300)
        .outputFormat("png")
        .toFile(new File( ""+dirTemporal+"\\img"+String.valueOf(indexImagen) ));
		path= ""+dirTemporal+"\\img"+String.valueOf(indexImagen)+".png";
	}
	
	public BufferedImage obtenerImagen() throws IOException{
		BufferedImage originalImage = null;
		BufferedImage thumbnail = null;
		
		guardarCopiaRedimensionada();
		
		originalImage = ImageIO.read(new File(path));
		thumbnail = Thumbnails.of(originalImage)
		        .size(56, 56)
		        .asBufferedImage();
		return thumbnail;
	}
	
	
	public BufferedImage obtenerImagenPrincipal() throws IOException{
		BufferedImage imagenTemp = null;
		imagenTemp = ImageIO.read(new File(path));			
		return imagenTemp;
	}
	
	public boolean verificarLugar(String lugar){
		if (lugar.trim().isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor ingrese el lugar.");
			return false;
		}
		return true;
	}
	
	public void cargarDatos(String modoRegistro, String nombre, String chip,
			String color, String tipoMascota, String razaMascota, String sexo,
			String descripcion, String lugar, String recompensa) {
		VistaPrincipal
				.getInstance()
				.getUsuario()
				.reportarMascota(tipoMascota, razaMascota, color, lugar,
						modoRegistro, chip, nombre, recompensa, sexo);

	}
	
	Predicate<ReporteAnimal> predicadoCedula = new Predicate<ReporteAnimal>() {
		public boolean test(ReporteAnimal t) {
			return t.getIdentificacionReportante().equals(VistaPrincipal.getInstance().getUsuario().getIdentificacion());
		}
	};
	
	public void cargarImagenes(){
		ReporteAnimal.animalesSistema.stream().filter(predicadoCedula).forEach(p->p.setFotosAnimal(imagenes));
		ReporteAnimal.animalesSistema.stream().filter(predicadoCedula).forEach(p->System.out.println(p.toString()));
		
	}
	
	public void anadirImagenes(String imagen0, String imagen1, String imagen2,
			String imagen3, String imagen4, String imagen5) {
		imagenes.clear();
		imagenes.add(imagen0);
		imagenes.add(imagen1);
		imagenes.add(imagen2);
		imagenes.add(imagen3);
		imagenes.add(imagen4);
		imagenes.add(imagen5);

	}
	
	private static void limpiarDirTemporal(){
		for(File file: dirTemporal.listFiles()) 
			file.delete();
	}
	
	

}
