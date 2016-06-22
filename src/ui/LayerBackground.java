package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {
	//TODO ¡Ÿ ±±≥æ∞
	private static Image img_tmp_bg = new ImageIcon("graphics/background/Fish.jpg").getImage();
	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(img_tmp_bg, 0, 0,1200,700, null);
	}

}
