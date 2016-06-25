package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	/**
	 * 数据库中的数据
	 */
	private List<Player> db;
	/**
	 * 本地数据
	 */
	private List<Player> local;
	/**
	 * 窗口数据
	 */
	private boolean gameMap;
	/**
	 * 下落的方块
	 */
	private GameAct gameAct;
	
	public int getNowlevel() {
		return nowlevel;
	}

	public void setNowlevel(int nowlevel) {
		this.nowlevel = nowlevel;
	}
	/**
	 * 下一个方块，用数字枚举
	 */
	private int next;
	/**
	 * 当前级别
	 */
	private int nowlevel;
	/**
	 * 当前分数
	 */
	private int nowPoint;
	/**
	 * 移除的行数
	 */
	private int removeLine;

	public List<Player> getDb() {
		return db;
	}

	public void setDb(List<Player> db) {
		this.db = db;
	}

	public List<Player> getLocal() {
		return local;
	}

	public void setLocal(List<Player> local) {
		this.local = local;
	}

	public boolean isGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}
	
	public int getNowPoint() {
		return nowPoint;
	}

	public void setNowPoint(int nowPoint) {
		this.nowPoint = nowPoint;
	}

	public int getRemoveLine() {
		return removeLine;
	}

	public void setRemoveLine(int removeLine) {
		this.removeLine = removeLine;
	}
	
	
}
