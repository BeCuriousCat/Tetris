package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	/**
	 * ���ڱ���
	 */
	private static Image IMG_POINT = new ImageIcon("graphics/string/point.png")
			.getImage();
	private static int POINT_X = 0;
	private static int POINT_Y = PADDING;
	/**
	 * ���ڱ��⣨���У�
	 */
	private static Image IMG_RMLINE = new ImageIcon(
			"graphics/string/rmline.png").getImage();
	private static int RMLINE_Y = IMG_RMLINE.getWidth(null)
			+ (PADDING << 1);
	/*
	 * �������λ�� 
	 */
	private static final int POINT_BIT = 5;
	
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		POINT_X = this.w - IMG_NUM_W * POINT_BIT - PADDING;
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// ���ڱ��⣨������
		g.drawImage(IMG_POINT, this.x + PADDING, this.y + PADDING, null);
		this.drawNumberLeftPad(POINT_X, POINT_Y, this.dto.getNowlevel(), POINT_BIT, g);
		
		// ���ڱ��⣨���У�
		g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + RMLINE_Y,null);
		this.drawNumberLeftPad(POINT_X, RMLINE_Y, this.dto.getRemoveLine(), POINT_BIT, g);
	}
}
