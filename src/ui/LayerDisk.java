package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerDisk extends LayerDate{
	
	
	public LayerDisk(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
		this.showDate(Img.DISK, this.dto.getDb(), g);
		
	}
}
