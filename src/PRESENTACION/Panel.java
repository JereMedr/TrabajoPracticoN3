package PRESENTACION;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Panel extends JPanel {

	private static final long serialVersionUID = 1L;

	ImageIcon imagen;
	String direccion;
	JButton musica;

	public Panel(String direccion) {
		this.direccion = direccion;
	}

	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagen = new ImageIcon(getClass().getResource(direccion));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		super.paint(g);
	}
	
	public void configMusica(boolean estado){
		if (estado == true) {
			musica.setIcon(new ImageIcon("imagenes\\musica.png"));
			
		} else {
			musica.setIcon(new ImageIcon("imagenes\\musicaOff.png"));
			
		}
	}

}