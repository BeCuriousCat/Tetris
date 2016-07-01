package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	/**
	 * 窗口标题
	 */
	private static Image IMG_LEVEL = new  ImageIcon("graphics/string/level.png").getImage();
	/**
	 * 数字图片 230 36
	 */
	private static Image IMG_NUM = new ImageIcon("graphics/string/num.png").getImage();
	private static final int  IMG_NUM_W = 26;
	private static final int  IMG_NUM_H = 36;
	
	
	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题 
		g.drawImage(IMG_LEVEL, this.x+PADDING, this.y+PADDING, null);
		//显示等级
		drawNumber(48,64,1, g);
	}
	/**
	 * 显示数字
	 * @param g
	 */
	public void drawNumber(int x,int y,int num,Graphics g){
		//把数组number中的每一位取出来
		String strNum = Integer.toString(num);
		for (int i = 0; i < strNum.length(); i++) {
			int bit = strNum.charAt(i) - '0';
			g.drawImage(IMG_NUM, 
					this.x + x + IMG_NUM_W * i ,this.y + y, 
					this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
					num * IMG_NUM_W, 0,
					(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
		}
	}
}
