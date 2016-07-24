package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import dto.Player;

public class LayerDataBase extends LayerDate{

	
	
	public LayerDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		this.showDate(Img.DB, this.dto.getDb(), g);
		
	}

	
}
