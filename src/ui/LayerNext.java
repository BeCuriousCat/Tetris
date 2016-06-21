package ui;

import java.awt.Graphics;

public class LayerNext extends Layer {

	protected LayerNext(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}
	public void paint(Graphics g){
		this.createWindow(g);
	}
}
