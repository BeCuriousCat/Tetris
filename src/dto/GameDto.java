package dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
	private boolean[][] gameMap;
	/**
	 * ����ķ���
	 */
	private GameAct gameAct;
	

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
	
	public GameDto(){
		dtoInit();
	}
	
	/**
	 * dto��ʼ��
	 */
	public void dtoInit(){
		//TODO Ӳ����
		this.gameMap = new boolean[10][18];
		//TODO ��ʼ��������Ϸ����
	}
	
	public List<Player> getDb() {
		return db;
	}

	public void setDb(List<Player> db) {
		this.db = setFillRecode(db);
	}

	private  List<Player> setFillRecode(List<Player> players){
		//�������Ϊ�գ����½�
		if( players == null ){
			players = new ArrayList<Player>();
		}
		//���С��5��������ӵ�5��
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
