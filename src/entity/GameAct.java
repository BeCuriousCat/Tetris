package entity;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class GameAct {
	/**
	 * 方块数组
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
		//TODO 硬编码
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
		//TODO 根据int随机刷新方块
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
	 * 方块移动方法
	 * @param moveX X轴移动偏移
	 * @param moveY Y轴移动偏移
	 */
	public boolean move(int moveX ,int moveY,boolean[][] gameMap){
		//判断边界
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverZone(newX, newY,gameMap)){
				return false;
			}
		}
		//移动处理
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x = actPoints[i].x + moveX;
			actPoints[i].y = actPoints[i].y + moveY;
		}
		return true;
	}
	/**
	 * 方块旋转
	 * 顺时针
	 * A.x = 0.x + 0.y - B.y
	 * A.y = 0.y - 0.x + B.x
	 */
	public boolean round(boolean[][] gameMap){
		//TODO 正方方块不旋转
		
		if(this.typeCode == 4) return false;
		
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].x + actPoints[0].y - actPoints[i].y;
			int newY = actPoints[0].y - actPoints[0].x + actPoints[i].x;
			//TODO 判断是否能旋转
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
