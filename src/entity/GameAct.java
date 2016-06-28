package entity;

import java.awt.Point;

public class GameAct {
	private Point[] actPoints;
	
	public GameAct(){
		actPoints = new Point[]{
				new Point(3,0),
				new Point(4,0),
				new Point(5,0),
				new Point(5,1)
		};
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	/**
	 * �����ƶ�����
	 * @param moveX X���ƶ�ƫ��
	 * @param moveY Y���ƶ�ƫ��
	 */
	public void move(int moveX ,int moveY){
		//�ƶ�����
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x = actPoints[i].x + moveX;
			actPoints[i].y = actPoints[i].y + moveY;
		}
	}
}
