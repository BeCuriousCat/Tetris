package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {

	/**
	 * 分数最大位数
	 */
	private static final int POINT_BIT = 5;
	/**
	 * 分数x坐标
	 */
	private int pointX = 0;
	/**
	 * 分数y坐标
	 */
	private final int pointY;
	/**
	 * 消行y坐标
	 */
	private final int rmLineY;


	/**
	 * 
	 */
	// TODO
	private final int LEVERL_UP = 20;
	
	private int expY;



	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		// 初始化分数x坐标，为共同x坐标
		this.pointX = this.w - IMG_NUM_W * POINT_BIT - PADDING;
		// 初始化分数线是y坐标
		this.pointY = PADDING;
		// 初始化消行显示的y坐标
		this.rmLineY = this.pointY + Img.POINT.getHeight(null) + PADDING;
		// 初始化经验值显示y坐标
		this.expY = this.rmLineY + Img.RMLINE.getHeight(null) + PADDING;
		// 绘制槽值宽度
		
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// 窗口标题（分数）
		g.drawImage(Img.POINT, this.x + PADDING, this.y + PADDING, null);
		// 绘制分数
		this.drawNumberLeftPad(pointX, pointY, this.dto.getNowlevel(),
				POINT_BIT, g);

		// 窗口标题（消行）
		g.drawImage(Img.RMLINE, this.x + PADDING, this.y + rmLineY, null);
		// 绘制消行
		this.drawNumberLeftPad(pointX, rmLineY, this.dto.getRemoveLine(),
				POINT_BIT, g);

		// 绘制槽值（经验值）
		int rmLine = this.dto.getRemoveLine();
		double precent = (double) (rmLine % LEVERL_UP)/(double) LEVERL_UP;
		drawRect("下一级",this.expY,precent, g);
	}


}
