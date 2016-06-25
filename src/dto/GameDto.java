package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {
	/**
	 * ���ݿ��е�����
	 */
	private List<Player> db;
	/**
	 * ��������
	 */
	private List<Player> local;
	/**
	 * ��������
	 */
	private boolean gameMap;
	/**
	 * ����ķ���
	 */
	private GameAct gameAct;
	
	public int getNowlevel() {
		return nowlevel;
	}

	public void setNowlevel(int nowlevel) {
		this.nowlevel = nowlevel;
	}
	/**
	 * ��һ�����飬������ö��
	 */
	private int next;
	/**
	 * ��ǰ����
	 */
	private int nowlevel;
	/**
	 * ��ǰ����
	 */
	private int nowPoint;
	/**
	 * �Ƴ�������
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
