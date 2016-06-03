package ui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameGame extends JFrame{
	public  FrameGame(){
		String title = "Java 俄罗斯方块";
		int width = 1200;
		int height = 700;
		//偏移x,y
		int OffSetX = 0;
		int OffSetY = 0;
		//设置标题
		this.setTitle(title);
		//默认关闭属性
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//设置窗口大小
		this.setSize(width,height);
		//不允许改变窗口大小
		this.setResizable(false);
		
		//居中
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		OffSetX = (int) (screen.getWidth() - this.getWidth())/2;
		OffSetY = (int) (screen.getHeight() - this.getHeight())/2 - 32;
		this.setLocation(OffSetX, OffSetY);
		
		//设计默认Panel
		this.setContentPane(new PanelGame());
	}
}
