package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {

	/**
	 * �������λ��
	 */
	private static final int POINT_BIT = 5;
	/**
	 * ����x����
	 */
	private int pointX = 0;
	/**
	 * ����y����
	 */
	private final int pointY;
	/**
	 * ����y����
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
		// ��ʼ������x���꣬Ϊ��ͬx����
		this.pointX = this.w - IMG_NUM_W * POINT_BIT - PADDING;
		// ��ʼ����������y����
		this.pointY = PADDING;
		// ��ʼ��������ʾ��y����
		this.rmLineY = this.pointY + Img.POINT.getHeight(null) + PADDING;
		// ��ʼ������ֵ��ʾy����
		this.expY = this.rmLineY + Img.RMLINE.getHeight(null) + PADDING;
		// ���Ʋ�ֵ���
		
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// ���ڱ��⣨������
		g.drawImage(Img.POINT, this.x + PADDING, this.y + PADDING, null);
		// ���Ʒ���
		this.drawNumberLeftPad(pointX, pointY, this.dto.getNowlevel(),
				POINT_BIT, g);

		// ���ڱ��⣨���У�
		g.drawImage(Img.RMLINE, this.x + PADDING, this.y + rmLineY, null);
		// ��������
		this.drawNumberLeftPad(pointX, rmLineY, this.dto.getRemoveLine(),
				POINT_BIT, g);

		// ���Ʋ�ֵ������ֵ��
		int rmLine = this.dto.getRemoveLine();
		double precent = (double) (rmLine % LEVERL_UP)/(double) LEVERL_UP;
		drawRect("��һ��",this.expY,precent, g);
	}


}
