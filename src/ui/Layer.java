package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 创建窗口
 * 
 * @author chenzewei
 *
 */
public abstract class Layer {
	
	// 内边距
	protected static final int PADDING = 16;
	// 边框宽度
	protected static final int BORDER = 7;
	
	private static Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();
	private static int IMG_W = WINDOW_IMG.getWidth(null);
	private static int IMG_H = WINDOW_IMG.getHeight(null);
	/*static {
		FrameConfig fCfg = GameConfig.getFrameConfig();

	}*/
	// 窗口图片宽度
	// private static final int IMG_W = Img.

	// 窗口所在的X坐标
	protected int x;
	// 窗口所在的Y坐标
	protected int y;
	// 窗口所在的高度
	protected int h;
	// 窗口所在的宽度
	protected int w;

	public Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	protected void createWindow(Graphics g) {
		// 左上
		g.drawImage(WINDOW_IMG, x, y, x + BORDER, y + BORDER, 0, 0, BORDER,
				BORDER, null);
		// 中上
		g.drawImage(WINDOW_IMG, x + BORDER, y, w + x - BORDER, y + BORDER,
				BORDER, 0, IMG_W - BORDER, BORDER, null);
		// 右上
		g.drawImage(WINDOW_IMG, w + x - BORDER, y, w + x, y + BORDER, IMG_W
				- BORDER, 0, IMG_W, BORDER, null);
		// 左中
		g.drawImage(WINDOW_IMG, x, y + BORDER, x + BORDER, h + y - BORDER, 0,
				BORDER, BORDER, IMG_H - BORDER, null);
		// 中间
		g.drawImage(WINDOW_IMG, x + BORDER, y + BORDER, x + w - BORDER, y + h
				- BORDER, BORDER, BORDER, IMG_W - BORDER, IMG_H - BORDER, null);
		// 右中
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + BORDER, w + x, h + y
				- BORDER, IMG_W - BORDER, BORDER, IMG_W, IMG_H - BORDER, null);
		// 左下
		g.drawImage(WINDOW_IMG, x, y + h - BORDER, x + BORDER, h + y, 0, IMG_H
				- BORDER, BORDER, IMG_H, null);
		// 中下
		g.drawImage(WINDOW_IMG, x + BORDER, y + h - BORDER, x + w - BORDER, h
				+ y, BORDER, IMG_H - BORDER, IMG_W - BORDER, IMG_H, null);
		// 右下
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + h - BORDER, x + w, y + h,
				IMG_W - BORDER, IMG_H - BORDER, IMG_W, IMG_H, null);
	}
	abstract public void paint(Graphics g);
}
