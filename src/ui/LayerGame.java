package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public class LayerGame extends Layer {
	private static Image IMG_GAME = new  ImageIcon("graphics/string/db.png").getImage();
	protected LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
	}
}
