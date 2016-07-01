package service;

import java.awt.Point;
import java.util.Random;

import dto.GameDto;
import entity.GameAct;

public class GameService {
	private static final int MAX_TYPE = 7;
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
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	/**
	 * 控制器方向建（下）
	 */
	public void keyDown() {
		boolean[][] map = null;
		//如果移动成功，返回
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return;
		}
		//获取游戏地图对象
		map = this.dto.getGameMap();
		Point[] act = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		//TODO 判断是否消行
		//TODO 消行操作
		//TODO 算分
		//TODO 判断是否升级
		//TODO 升级
		this.dto.getGameAct().init(this.dto.getNext());
		//TODO 刷新一个新的方块
		this.dto.setNext(new Random().nextInt(MAX_TYPE));
	}
	/**
	 * 控制器方向建（左）
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}
	/**
	 * 控制器方向建（右）
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	
}
