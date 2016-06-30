package entity;

import java.awt.Point;

public class GameAct {
	/**
	 * ��������
	 */
	private Point[] actPoints;
	
	/**
	 * 
	 */
	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	
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
	public boolean move(int moveX ,int moveY){
		//�жϱ߽�
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverMap(newX, newY)){
				return false;
			}
		}
		//�ƶ�����
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x = actPoints[i].x + moveX;
			actPoints[i].y = actPoints[i].y + moveY;
		}
		return true;
	}
	/**
	 * ������ת
	 * ˳ʱ��
	 * A.x = 0.x + 0.y - B.y
	 * A.y = 0.y - 0.x + B.x
	 */
	public boolean round(){
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].x + actPoints[0].y - actPoints[i].y;
			int newY = actPoints[0].x - actPoints[0].y + actPoints[i].x;
			//TODO �ж��Ƿ�����ת
			if(this.isOverMap(newX, newY)){
				return false;
			}
				
		}
		
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[0].x + actPoints[0].y - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			actPoints[i].y = newY;
			actPoints[i].x = newX;
		}
		return true;
	}
	
	private boolean isOverMap(int x, int y){
		return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y;
	}
} 
