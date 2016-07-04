package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class LayerLevel extends Layer {
	/**
	 * ���ڱ���
	 */
	private static Image IMG_LEVEL = new  ImageIcon("graphics/string/level.png").getImage();
	/**
	 * ����ͼƬ 230 36
	 */
	private static Image IMG_NUM = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * ������Ƭ�Ŀ��
	 */
	private static final int  IMG_NUM_W = IMG_NUM.getWidth(null) / 10;
	/**
	 * ������Ƭ�ĸ߶�
	 */
	private static final int  IMG_NUM_H = IMG_NUM.getHeight(null);
	
	
	public LayerLevel(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public void paint(Graphics g){
		this.createWindow(g);
		//���ڱ��� 
		g.drawImage(IMG_LEVEL, this.x+PADDING, this.y+PADDING, null);
		//��ʾ�ȼ�
		
		drawNumberLeftPad(64,32,1, 3,g);
	}
	/**
	 * ��ʾ����
	 * @param x ���Ͻ�x����
	 * @param y ���Ͻ�y����
	 * @param num Ҫ��ʾ������
	 * @param maxBit ����λ�� 
	 * @param g	���ʶ���
	 */
	public void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g){
		//������num�е�ÿһλȡ����
		String strNum = Integer.toString(num);
		//ѭ�����������Ҷ���
		for (int i = 0; i < maxBit; i++) {
			//�ж��Ƿ������������
			if( i >= maxBit - strNum.length()) return ;
			//������num��ÿһλȡ��
			int bit = strNum.charAt(i) - '0';
			//��������
			g.drawImage(IMG_NUM, 
					this.x + x + IMG_NUM_W * i ,this.y + y, 
					this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
					bit * IMG_NUM_W, 0,
					(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
		}
	}
}
