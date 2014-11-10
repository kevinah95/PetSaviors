package editar.usuario;

import individuos.Individuo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import logicaExterna.Usuarios;
import menu.principal.VistaPrincipal;
import net.coobird.thumbnailator.Thumbnails;
import registrar.mascota.RegistrarMascota;
import registrar.usuario.RegistarUsuario;

public class ModeloEditarTipo {
	
	String path="";
	private static final boolean CORRECTA = true;
	private static final boolean INCORRECTA = false;
	private static final File dirImagenes = new File("Pet_Saviors/perfiles");
	
	Usuarios usuarios = Usuarios.getInstance();
	private Individuo usuario = null;
	
	public ModeloEditarTipo() {
		
	}
	
	
	
	private void ElegirImagen() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Images",
				"jpg", "png", "gif", "bmp");
		
		fileChooser.setFileFilter(filter);
		
		int returnValue = fileChooser.showOpenDialog(RegistarUsuario.panelCards);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			
			path = selectedFile.getPath();
			
		}
		
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
	
	public BufferedImage obtenerImagen() throws IOException{
		BufferedImage originalImage = null;
		BufferedImage thumbnail = null;
		
		
		originalImage = ImageIO.read(new File(path));
		thumbnail = Thumbnails.of(originalImage)
		        .size(120, 120)
		        .asBufferedImage();
		return thumbnail;
	}
	
	public void copiarImgToPerfiles() throws IOException{
		Thumbnails.of(path)
        .size(84, 84)
        .outputFormat("png")
        .toFile(new File(""+dirImagenes+"\\"+VistaPrincipal.getUsuario().getIdentificacion()));
		
		path = ""+dirImagenes+"\\"+VistaPrincipal.getUsuario().getIdentificacion()+".png";
		System.out.println(path);
	}
	
	
	
	public void registrarNuevoUsuario(String nombre, String pApellido,
			String sApellido, String telefono, String cedula, String correo,
			String contrasenia,String casaCuna, String adoptante,String dirImgPerfil) {

//		JOptionPane.showMessageDialog(null, "Cambiar función");
//		Usuarios.usuariosRegistrados.stream().filter(
//				p -> p.getIdentificacion().equals(
//						VistaPrincipal.getUsuario().getIdentificacion())).forEach(p->usuario = p);
//		usuario.setNombre(nombre);
//		usuario.setpApellido(pApellido);
//		usuario.setsApellido(sApellido);
//		usuario.setTelefono(telefono);
//		usuario.setCorreo(correo);
//		usuario.setContrasena(contrasenia);
//		usuario.setCasaCuna(casaCuna);
//		usuario.setAdministrador(adoptante);
//		usuario.setDirFotoPerfil(dirImgPerfil);
		
		
//		Individuo nuevoUsuario = new Individuo(cedula, nombre, pApellido,
//				sApellido, telefono, correo, contrasenia, casaCuna, adoptante,
//				"false", dirImgPerfil);
//		usuarios.agregarUsuario(nuevoUsuario);
//		usuarios.actualizarJson();

	}
	
	public void verificarArchivo() throws IOException { 
    	if (!dirImagenes.exists()) {
    		dirImagenes.mkdirs();
    	    JOptionPane.showMessageDialog(RegistarUsuario.panelCards, "Directorio CREADO: "+dirImagenes.getCanonicalPath());
    	}
	}

}
