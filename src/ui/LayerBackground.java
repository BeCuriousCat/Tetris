package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerBackground extends Layer {
	//TODO ��ʱ����
	
	public LayerBackground(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(Img.tmp_bg, 0, 0,1200,700, null);
	}

}
