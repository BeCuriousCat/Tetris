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
	 * ���������򽨣��ϣ�
	 */
	public void keyUp() {
		//TODO ��ת
		this.dto.getGameAct().round();
	}
	/**
	 * ���������򽨣��£�
	 */
	public void keyDown() {
		boolean[][] map = null;
		if(!this.dto.getGameAct().move(0, 1)){
			//��ȡ��Ϸ��ͼ����
			map = this.dto.getGameMap();
			Point[] act = this.dto.getGameAct().getActPoints();
			for (int i = 0; i < act.length; i++) {
				map[act[i].x][act[i].y] = true;
			}
		}
	}
	/**
	 * ���������򽨣���
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0);
	}
	/**
	 * ���������򽨣��ң�
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0);
	}
	/**
	 * �߽��ж�
	 * @return
	 */
	private boolean canMove(int moveX,int moveY){
		Point[] nowPoints = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < nowPoints.length; i++) {
			int newX = nowPoints[i].x + moveX;
			int newY = nowPoints[i].y + moveY;
			//TODO Ӳ����
			if(newX < 0 || newX > 9 || newY <0 || newY > 17){
				return false;
			}
		}
 		return true;
	}
}
