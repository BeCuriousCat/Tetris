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
		//数据源
		GameDto dto = new GameDto();
		//创建游戏面板
		JPanelGame panel = new JPanelGame(dto);
		//创建游戏逻辑块（安装游戏数据源）
		GameService service = new GameService(dto);
		//创建游戏控制器（连接游戏面板和游戏逻辑块）
		GameControl gameControl = new GameControl(panel, service); 
		//创建玩家控制器（连接游戏控制器）
		PlayerControl control = new PlayerControl(gameControl);
		//创建游戏窗口
		panel.setGameControl(control);
		
		new JFrameGame(panel);
		
	}
}
