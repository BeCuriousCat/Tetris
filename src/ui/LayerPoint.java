package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerPoint extends Layer {
	/**
	 * ���ڱ���
	 */
	private static Image IMG_POINT = new ImageIcon("graphics/string/point.png")
			.getImage();
	/**
	 * ���ڱ��⣨���У�
	 */
	private static Image IMG_RMLINE = new ImageIcon(
			"graphics/string/rmline.png").getImage();
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
	private final int rmLineY ;

	/**
	 * ����ֵ��y����
	 */
	private final int expY;
	/**
	 * ����ֵ�ۿ��
	 */
	private final int expW;
	
	public LayerPoint(int x, int y, int w, int h) {
		super(x, y, w, h);
		// TODO Auto-generated constructor stub
		//��ʼ������x���꣬Ϊ��ͬx����
		this.pointX = this.w - IMG_NUM_W * POINT_BIT - PADDING;
		//��ʼ����������y����
		this.pointY = PADDING;
		//��ʼ��������ʾ��y����
		this.rmLineY = this.pointY + IMG_POINT.getHeight(null)+PADDING;
		//��ʼ������ֵ��ʾy����
		this.expY = this.rmLineY + IMG_RMLINE.getHeight(null)+PADDING;
		//���Ʋ�ֵ���
		this.expW = this.w - (PADDING << 1);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		// ���ڱ��⣨������
		g.drawImage(IMG_POINT, this.x + PADDING, this.y + PADDING, null);
		// ���Ʒ���
		this.drawNumberLeftPad(pointX, pointY, this.dto.getNowlevel(), POINT_BIT, g);
		
		// ���ڱ��⣨���У�
		g.drawImage(IMG_RMLINE, this.x + PADDING, this.y + rmLineY,null);
		// ��������
		this.drawNumberLeftPad(pointX, rmLineY, this.dto.getRemoveLine(), POINT_BIT, g);
	
		//���Ʋ�ֵ������ֵ��
		int h = 32;
		g.setColor(Color.BLACK);
		g.fillRect(this.x + PADDING , this.y + expY ,this.expW, h);
		g.setColor(Color.WHITE);
		g.fillRect(this.x + PADDING + 2 , this.y + expY +2 , this.expW -4, h-4);
		g.setColor(Color.WHITE);
		g.fillRect(this.x + PADDING + 4 , this.y + expY +4 , this.expW -8, h-8);
	}
}
