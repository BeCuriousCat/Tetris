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
	/**
	 * 数字切片的宽度
	 */
	private static final int  IMG_NUM_W = IMG_NUM.getWidth(null) / 10;
	/**
	 * 数字切片的高度
	 */
	private static final int  IMG_NUM_H = IMG_NUM.getHeight(null);
	
	
	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//窗口标题 
		g.drawImage(IMG_LEVEL, this.x+PADDING, this.y+PADDING, null);
		//显示等级
		
		drawNumberLeftPad(64,32,1, 3,g);
	}
	/**
	 * 显示数字
	 * @param x 左上角x坐标
	 * @param y 左上角y坐标
	 * @param num 要显示的数字
	 * @param maxBit 数字位数 
	 * @param g	画笔对象
	 */
	public void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g){
		//把数组num中的每一位取出来
		String strNum = Integer.toString(num);
		//循环绘制数字右对齐
		for (int i = 0; i < maxBit; i++) {
			//判断是否满足绘制条件
			if( i >= maxBit - strNum.length()) return ;
			//把数字num中每一位取出
			int bit = strNum.charAt(i) - '0';
			//绘制数字
			g.drawImage(IMG_NUM, 
					this.x + x + IMG_NUM_W * i ,this.y + y, 
					this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
					bit * IMG_NUM_W, 0,
					(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
		}
	}
}
