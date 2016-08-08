package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {
	//TODO ¡Ÿ ±±≥æ∞
	
	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		int index = this.dto.getNowlevel()%(Img.BG_LIST.size());
		g.drawImage(Img.BG_LIST.get(index), 0, 0,1200,700, null);
	}

}
