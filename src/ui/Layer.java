package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ��������
 * 
 * @author chenzewei
 *
 */
public abstract class Layer {
	
	// �ڱ߾�
	protected static final int PADDING = 16;
	// �߿���
	protected static final int BORDER = 7;
	
	private static Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();
	private static int IMG_W = WINDOW_IMG.getWidth(null);
	private static int IMG_H = WINDOW_IMG.getHeight(null);
	/*static {
		FrameConfig fCfg = GameConfig.getFrameConfig();

	}*/
	// ����ͼƬ���
	// private static final int IMG_W = Img.

	// �������ڵ�X����
	protected int x;
	// �������ڵ�Y����
	protected int y;
	// �������ڵĸ߶�
	protected int h;
	// �������ڵĿ��
	protected int w;

	public Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	protected void createWindow(Graphics g) {
		// ����
		g.drawImage(WINDOW_IMG, x, y, x + BORDER, y + BORDER, 0, 0, BORDER,
				BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x + BORDER, y, w + x - BORDER, y + BORDER,
				BORDER, 0, IMG_W - BORDER, BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, w + x - BORDER, y, w + x, y + BORDER, IMG_W
				- BORDER, 0, IMG_W, BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x, y + BORDER, x + BORDER, h + y - BORDER, 0,
				BORDER, BORDER, IMG_H - BORDER, null);
		// �м�
		g.drawImage(WINDOW_IMG, x + BORDER, y + BORDER, x + w - BORDER, y + h
				- BORDER, BORDER, BORDER, IMG_W - BORDER, IMG_H - BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + BORDER, w + x, h + y
				- BORDER, IMG_W - BORDER, BORDER, IMG_W, IMG_H - BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x, y + h - BORDER, x + BORDER, h + y, 0, IMG_H
				- BORDER, BORDER, IMG_H, null);
		// ����
		g.drawImage(WINDOW_IMG, x + BORDER, y + h - BORDER, x + w - BORDER, h
				+ y, BORDER, IMG_H - BORDER, IMG_W - BORDER, IMG_H, null);
		// ����
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + h - BORDER, x + w, y + h,
				IMG_W - BORDER, IMG_H - BORDER, IMG_W, IMG_H, null);
	}
	abstract public void paint(Graphics g);
}
