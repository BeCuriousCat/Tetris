package service;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

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
		this.dto.getGameAct().round(this.dto.getGameMap());
	}
	/**
	 * ���������򽨣��£�
	 */
	public void keyDown() {
		boolean[][] map = null;
		//����ƶ��ɹ�������
		if(this.dto.getGameAct().move(0, 1,this.dto.getGameMap())){
			return;
		}
		//��ȡ��Ϸ��ͼ����
		map = this.dto.getGameMap();
		Point[] act = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		//TODO �ж��Ƿ�����
		//TODO ���в���
		//TODO ���
		//TODO �ж��Ƿ�����
		//TODO ����
		//TODO ˢ��һ���µķ���
		this.dto.getGameAct().init((int) Math.ceil((Math.random()*6)));
	}
	/**
	 * ���������򽨣���
	 */
	public void keyLeft() {
			this.dto.getGameAct().move(-1, 0,this.dto.getGameMap());
	}
	/**
	 * ���������򽨣��ң�
	 */
	public void keyRight() {
			this.dto.getGameAct().move(1, 0,this.dto.getGameMap());
	}
	
}
