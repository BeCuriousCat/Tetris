package ui;

import java.awt.Graphics;

public class LayButton extends Lay{
	protected LayButton(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
	}

	public void paint(Graphics g){
		this.createWindow(g);
	}
}
