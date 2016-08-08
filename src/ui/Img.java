package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Img {
	/**
	 * 窗口图片
	 */
	public static Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	/**
	 * 数字图片 230 36
	 */
	public static Image NUM = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * 值槽图片
	 */
	public static Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	/**
	 * 窗口标题
	 */
	public static Image POINT = new ImageIcon("graphics/string/point.png").getImage();
	
	/**
	 * 窗口标题（消行）
	 */
	public static Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	/**
	 * 临时背景
	 */
	public static Image tmp_bg = new ImageIcon("graphics/background/light.jpg").getImage();
	/**
	 * 数据库窗口标题
	 */
	public static Image DB = new  ImageIcon("graphics/string/db.png").getImage();
	/**
	 * 本地记录
	 */
	public static Image DISK = new  ImageIcon("graphics/string/disk.png").getImage();
	/**
	 * 游戏界面的方块图片集
	 */
	public static final Image ACT = new ImageIcon("graphics/game/rect1.png").getImage();

	/**
	 * 窗口标题
	 */
	public static Image LEVEL = new  ImageIcon("graphics/string/level.png").getImage();
	
	/**
	 * 下一个图片数组
	 */
	public static Image[]  NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	static{
		NEXT_ACT = new Image[7];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/background/"+i+".png").getImage();
		}
		
		//背景图片数组
		File dir = new File("graphics/background");
		File[] files = dir.listFiles();
		BG_LIST = new ArrayList<Image>();
		for (File file : files) {
			if( file.isDirectory()){
				continue;
			}
			BG_LIST.add(new ImageIcon(file.getPath()).getImage());
		}
		
	}
	
	
	
}
