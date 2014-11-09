package registrar.mascota;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.coobird.thumbnailator.Thumbnails;

public class ModeloEtapaImagenes {

	private static ModeloEtapaImagenes instance = null;
	String path="";
	private static final boolean CORRECTA = true;
	private static final boolean INCORRECTA = false;
	private static final File dirTemporal = new File("Pet_Saviors/temp");
	private String indexImagen =null;
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
	
	
	
	private static void limpiarDirTemporal(){
		for(File file: dirTemporal.listFiles()) 
			file.delete();
	}
	
	

}
