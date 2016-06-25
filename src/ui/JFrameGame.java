package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import config.ConfigFactory;
import config.GameConfig;

public class JFrameGame extends JFrame{
	public  JFrameGame(JPanelGame panelGame){
		
		// �����Ϸ����
		GameConfig cfg = ConfigFactory.getGamefig();
		//ƫ��x,y
		int OffSetX = 0;
		int OffSetY = 0;
		//���ñ���
		this.setTitle(cfg.getTitle());
		//Ĭ�Ϲر�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڴ�С
		this.setSize(cfg.getWidth(),cfg.getHight());
		//������ı䴰�ڴ�С
		this.setResizable(false);
		
		//����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		OffSetX = (int) (screen.getWidth() - this.getWidth())/2;
		OffSetY = (int) (screen.getHeight() - this.getHeight())/2 - cfg.getWindowUp();
		this.setLocation(OffSetX, OffSetY);
		
		//���Ĭ��Panel
		this.setContentPane(panelGame);
		
		//Ĭ�ϸĴ�����ʾ
		this.setVisible(true);
	}
}
