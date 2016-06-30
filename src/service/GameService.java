package service;

import java.awt.Point;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	private  GameDto dto;
	public GameService(GameDto dto){
		this.dto = dto;
		GameAct act = new GameAct();
		dto.setGameAct(act);
	}
	
	/**
	 * 控制器方向建（上）
	 */
	public void keyUp() {
		//TODO 旋转
		this.dto.getGameAct().round();
	}
	/**
	 * 控制器方向建（下）
	 */
	public void keyDown() {
		boolean[][] map = null;
		if(!this.dto.getGameAct().move(0, 1)){
			//获取游戏地图对象
			map = this.dto.getGameMap();
			Point[] act = this.dto.getGameAct().getActPoints();
			for (int i = 0; i < act.length; i++) {
				map[act[i].x][act[i].y] = true;
			}
		}
	}
	/**
	 * 控制器方向建（左）
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0);
	}
	/**
	 * 控制器方向建（右）
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0);
	}
	/**
	 * 边界判定
	 * @return
	 */
	private boolean canMove(int moveX,int moveY){
		Point[] nowPoints = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < nowPoints.length; i++) {
			int newX = nowPoints[i].x + moveX;
			int newY = nowPoints[i].y + moveY;
			//TODO 硬编码
			if(newX < 0 || newX > 9 || newY <0 || newY > 17){
				return false;
			}
		}
 		return true;
	}
}
