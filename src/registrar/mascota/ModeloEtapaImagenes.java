package registrar.mascota;

import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.commons.io.FileUtils;

import logicaExterna.Mascotas;
import logicaInterna.ReporteAnimal;
import menu.principal.VistaPrincipal;
import net.coobird.thumbnailator.Thumbnails;

public class ModeloEtapaImagenes {

	String path="";
	private static final boolean CORRECTA = true;
	private static final boolean INCORRECTA = false;
	
	private static final File dirTemporal = new File("Pet_Saviors/temp");
	private static final File dirImagenes = new File("Pet_Saviors/imagenes");
	private int indexBoton = 0;
	int partirDe = 0;
	private ArrayList<String> imagenes;
	Predicate<ReporteAnimal> predicadoChipAnimal;
	Predicate<ReporteAnimal> predicadoFull;
	
	
	
	public ModeloEtapaImagenes() {
		try {
			verificarArchivo();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		limpiarDirTemporal();
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
		
		int returnValue = fileChooser.showOpenDialog(RegistrarMascota.vistaetapaimagenes);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			path = selectedFile.getPath();
			
		}
		
	}
	
	private void guardarCopiaRedimensionada() throws IOException{
		Thumbnails.of(path)
        .size(300, 300)
        .outputFormat("png")
        .toFile(new File( ""+dirTemporal+"\\img"+String.valueOf(partirDe+indexBoton) ));
		path= ""+dirTemporal+"\\img"+String.valueOf(partirDe+indexBoton)+".png";
		System.out.println(path);
	}
	
	public BufferedImage obtenerImagen(int indiceBoton) throws IOException{
		BufferedImage originalImage = null;
		BufferedImage thumbnail = null;
		indexBoton = indiceBoton;
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
		
		
		 predicadoChipAnimal = new Predicate<ReporteAnimal>() {
			public boolean test(ReporteAnimal t) {
				
				return t.getAnimalReportado().getChipIdentificacion().equals(chip);
			}
		};

			VistaPrincipal
			.getUsuario()
			.reportarMascota(tipoMascota, razaMascota, color, lugar,
					modoRegistro, chip, nombre, recompensa, sexo);
		
			
		
		
	}
	
	
	
	Predicate<ReporteAnimal> predicadoCedula = new Predicate<ReporteAnimal>() {
		public boolean test(ReporteAnimal t) {
			
			return t.getIdentificacionReportante().equals(VistaPrincipal.getUsuario().getIdentificacion());
		}
	};
	
	public void cargarFullPredicado(){
		predicadoFull = predicadoCedula.and(predicadoChipAnimal);
	}
	
	
	
	public void cargarImagenes(){
		cargarFullPredicado();
		Mascotas.mascotasRegistradas.stream().filter(predicadoFull).forEach(p->p.setFotosAnimal(imagenes));
		Mascotas.mascotasRegistradas.stream().filter(predicadoFull).forEach(p->System.out.println(p.toString()));
	}
	
	
	
	
	
	public void limpiarDirTemporal(){
		for(File file: dirTemporal.listFiles()) 
			file.delete();
	}
	
	public int getIndice(){
		int indice = dirImagenes.listFiles().length;
		return indice;
	}
	
	public void copiarTempToImagenes() throws IOException{
		imagenes = new ArrayList<String>();
		FileUtils.copyDirectory(dirTemporal, dirImagenes);
		for (File file : dirTemporal.listFiles()) {
			String temp = file.getPath();
			imagenes.add(temp.replace("temp", "imagenes"));
		}
		if( dirTemporal.listFiles().length == 0){
			for(int i=0;i<6;i++){
				imagenes.add("");
			}
		}
	}
	
	public static void verificarArchivo() throws IOException { 
		
    	if (!dirTemporal.exists()) {
    		dirTemporal.mkdirs();
    	    
    	    JOptionPane.showMessageDialog(null, "Directorio CREADO: "+dirTemporal.getCanonicalPath());
    	} 
    	
    	if (!dirImagenes.exists()) {
    		dirImagenes.mkdirs();
    	    JOptionPane.showMessageDialog(null, "Directorio CREADO: "+dirImagenes.getCanonicalPath());
    	}
	}
	
	

}
