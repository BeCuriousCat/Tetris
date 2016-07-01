package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

import org.omg.CORBA.TypeCode;

public class LayerGame extends Layer {

	private static final Image ACT = new ImageIcon("graphics/game/rect1.png").getImage();
	/**
	 * ���ֺ�2�йصģ���ƫ���������Ч��
	 */
	private static final int  SIZE_ROL = 5;

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	
	public void paint(Graphics g) {
		this.createWindow(g);
		//��÷����������
		Point[] points = this.dto.getGameAct().getActPoints();
		//��÷������ͱ�ţ�0~6��
		int typeCode = this.dto.getGameAct().getTypeCode();
		//��ӡ����
		//�ȳ˳���Ӽ���λ��
		for (int i = 0; i < points.length; i++) {
			drawActByPoint(points[i].x, points[i].y, typeCode, g);
		}
		
		//��ӡ��ͼ
		boolean[][] map = this.dto.getGameMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if(map[x][y]){
					drawActByPoint(x, y, -1, g);
				}
			}
		}
	}
	
	/**
	 * ���������ο�
	 */
	private void drawActByPoint(int x,int y,int imgId, Graphics g){
		g.drawImage(ACT, 
				this.x + (x <<SIZE_ROL) + BORDER, 
				this.y + (y <<SIZE_ROL) + BORDER, 
				this.x + (x +1<<SIZE_ROL) + BORDER, 
				this.y + (y +1<<SIZE_ROL) + BORDER, 
				((imgId+1)<<SIZE_ROL),0, ((imgId+2)<<SIZE_ROL), 1<<SIZE_ROL, null);
	}
	
}
