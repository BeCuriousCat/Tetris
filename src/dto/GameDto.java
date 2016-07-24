package dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	private boolean[][] gameMap;
	/**
	 * 下落的方块
	 */
	private GameAct gameAct;
	

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
	
	public GameDto(){
		dtoInit();
	}
	
	/**
	 * dto初始化
	 */
	public void dtoInit(){
		//TODO 硬编码
		this.gameMap = new boolean[10][18];
		//TODO 初始化所有游戏对象
	}
	
	public List<Player> getDb() {
		return db;
	}

	public void setDb(List<Player> db) {
		this.db = setFillRecode(db);
	}

	private  List<Player> setFillRecode(List<Player> players){
		//如果进入为空，则新建
		if( players == null ){
			players = new ArrayList<Player>();
		}
		//如果小于5条，就添加到5条
		while (players.size() < 5) {
			players.add(new Player("NO DATE",0));
		}
		Collections.sort(players);
		return players;
	}
	
	public List<Player> getLocal() {
		return local;
	}

	public void setLocal(List<Player> local) {
		this.local = setFillRecode(local);
	}
	public int getNowlevel() {
		return nowlevel;
	}

	public void setNowlevel(int nowlevel) {
		this.nowlevel = nowlevel;
	}
	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
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
