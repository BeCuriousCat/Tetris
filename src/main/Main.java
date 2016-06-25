package main;

import java.awt.Frame;

import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {
	public static void main(String[] args) {
		//����Դ
		GameDto dto = new GameDto();
		//������Ϸ���
		JPanelGame panel = new JPanelGame(dto);
		//������Ϸ�߼��飨��װ��Ϸ����Դ��
		GameService service = new GameService(dto);
		//������Ϸ��������������Ϸ������Ϸ�߼��飩
		GameControl gameControl = new GameControl(panel, service); 
		//������ҿ�������������Ϸ��������
		PlayerControl control = new PlayerControl(gameControl);
		//������Ϸ����
		panel.setGameControl(control);
		
		new JFrameGame(panel);
		
	}
}
