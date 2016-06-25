package ui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;



public class LayerGame extends Layer {
	private static Image IMG_GAME = new  ImageIcon("graphics/string/db.png").getImage();
	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}
	public void paint(Graphics g){
		this.createWindow(g);
		g.setFont(new Font("ºÚÌå",Font.BOLD,64));
		String tmp = Integer.toString(this.dto.getNowPoint());
		g.drawString(tmp, this.x+PADDING, this.y+PADDING);
	}
}
