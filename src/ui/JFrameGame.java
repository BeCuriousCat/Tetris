package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame{
	public  JFrameGame(JPanelGame panelGame){
		
		// 获得游戏配置
		GameConfig cfg = ConfigFactory.getGamefig();
		//偏移x,y
		int OffSetX = 0;
		int OffSetY = 0;
		//设置标题
		this.setTitle(cfg.getTitle());
		//默认关闭属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口大小
		this.setSize(cfg.getWidth(),cfg.getHight());
		//不允许改变窗口大小
		this.setResizable(false);
		
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		OffSetX = (int) (screen.getWidth() - this.getWidth())/2;
		OffSetY = (int) (screen.getHeight() - this.getHeight())/2 - cfg.getWindowUp();
		this.setLocation(OffSetX, OffSetY);
		
		//设计默认Panel
		this.setContentPane(panelGame);
		
		//默认改窗口显示
		this.setVisible(true);
	}
}
