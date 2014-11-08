package registrar.mascota;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.coobird.thumbnailator.Thumbnails;

public class ModeloEtapaImagenes {

	private static ModeloEtapaImagenes instance = null;
	String path="";
	private static final boolean CORRECTA = true;
	private static final boolean INCORRECTA = false;
	protected ModeloEtapaImagenes() {
		
	}
	
	public static ModeloEtapaImagenes getInstance() {
		if (instance == null) {	instance = new ModeloEtapaImagenes(); }
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
	
	public BufferedImage obtenerImagen() throws IOException{
		BufferedImage originalImage = null;
		BufferedImage thumbnail = null;
		
			originalImage = ImageIO.read(new File(path));
		thumbnail = Thumbnails.of(originalImage)
		        .size(56, 56)
		        .asBufferedImage();
		
		return thumbnail;
	}
	
	public BufferedImage obtenerImagenPrincipal() throws IOException{
		BufferedImage originalImage = null;
		BufferedImage thumbnail = null;
		
			originalImage = ImageIO.read(new File(path));
		thumbnail = Thumbnails.of(originalImage)
		        .size(300, 300)
		        .asBufferedImage();
		
		return thumbnail;
	}
	
	

}
