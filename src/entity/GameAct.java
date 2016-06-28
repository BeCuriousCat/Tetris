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
	 * 方块移动方法
	 * @param moveX X轴移动偏移
	 * @param moveY Y轴移动偏移
	 */
	public void move(int moveX ,int moveY){
		//移动处理
		for (int i = 0; i < actPoints.length; i++) {
			actPoints[i].x = actPoints[i].x + moveX;
			actPoints[i].y = actPoints[i].y + moveY;
		}
	}
}
