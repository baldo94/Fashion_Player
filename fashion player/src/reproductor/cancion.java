/*package reproductor;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.print.DocFlavor.URL;
import javax.print.attribute.standard.Media;

import javazoom.jl.player.Player;

public class cancion {
	private String ruta;
	private Player player;
	
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public cancion(String ruta) throws Exception{
	

		  File file=new File(ruta);
		  FileInputStream fis     = new FileInputStream(file);
		  BufferedInputStream bis = new BufferedInputStream(fis);

		  player = new Player(bis);
		 	

	}
	public void play() throws Exception{
		  player.play();
	}
	
	public void stop(){
		player.close();
	}

}
*/