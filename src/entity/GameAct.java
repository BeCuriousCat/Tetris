package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameAct {
	/**
	 * ��������
	 */
	private Point[] actPoints;

	private int typeCode;
	


	/**
	 * 
	 */
	private static int MIN_X = 0;
	private static int MAX_X = 9;
	private static int MIN_Y = 0;
	private static int MAX_Y = 17;
	
	private static List<Point[]> TYPE_CONFIG;
	
	static {
		//TODO Ӳ����
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(6,0)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(5,0),new Point(3,1)});
		TYPE_CONFIG.add(new Point[]{new Point(3,0),new Point(5,1),new Point(3,1),new Point(4,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(5,0),new Point(4,1),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(3,0),new Point(4,0),new Point(5,0),new Point(5,1)});
		TYPE_CONFIG.add(new Point[]{new Point(4,0),new Point(3,0),new Point(4,1),new Point(5,1)});
	}
	
	public GameAct(){
		this.init(1);
	}

	public void init(int actCode) {
		//TODO ����int���ˢ�·���
		this.typeCode = actCode;
		Point[] points = TYPE_CONFIG.get(actCode);
 		actPoints = new Point[points.length];
 		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x,points[i].y);
		}
	
	}
	
	public int getTypeCode() {
		return typeCode;
	}

	public Point[] getActPoints() {
		return actPoints;
	}
	
	/**
	 * �����ƶ�����
	 * @param moveX X���ƶ�ƫ��
	 * @param moveY Y���ƶ�ƫ��
	 */
	public boolean move(int moveX ,int moveY,boolean[][] gameMap){
		//�жϱ߽�
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverZone(newX, newY,gameMap)){
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
	public boolean round(boolean[][] gameMap){
		//TODO �������鲻��ת
		
		if(this.typeCode == 4) return false;
		
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].x + actPoints[0].y - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//TODO �ж��Ƿ�����ת
			if(this.isOverZone(newX, newY,gameMap)){
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
	
	private boolean isOverZone(int x, int y,boolean[][] gameMap){
		return x < MIN_X || x > MAX_X || y < MIN_Y || y > MAX_Y || gameMap[x][y];
	}

	
} 
