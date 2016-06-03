package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameGame extends JFrame{
	public  FrameGame(){
		String title = "Java ����˹����";
		int width = 1200;
		int height = 700;
		//ƫ��x,y
		int OffSetX = 0;
		int OffSetY = 0;
		//���ñ���
		this.setTitle(title);
		//Ĭ�Ϲر�����
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//���ô��ڴ�С
		this.setSize(width,height);
		//������ı䴰�ڴ�С
		this.setResizable(false);
		
		//����
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		OffSetX = (int) (screen.getWidth() - this.getWidth())/2;
		OffSetY = (int) (screen.getHeight() - this.getHeight())/2 - 32;
		this.setLocation(OffSetX, OffSetY);
		
		//���Ĭ��Panel
		this.setContentPane(new PanelGame());
	}
}
