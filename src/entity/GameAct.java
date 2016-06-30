package entity;

import java.awt.Point;

public class GameAct {
	/**
	 * 方块数组
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
	 * 方块移动方法
	 * @param moveX X轴移动偏移
	 * @param moveY Y轴移动偏移
	 */
	public boolean move(int moveX ,int moveY){
		//判断边界
		for (int i = 0; i < actPoints.length; i++) {
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverMap(newX, newY)){
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
	public boolean round(){
		for (int i = 1; i < actPoints.length; i++) {
			int newX = actPoints[0].x + actPoints[0].y - actPoints[i].y;
			int newY = actPoints[0].x - actPoints[0].y + actPoints[i].x;
			//TODO 判断是否能旋转
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
