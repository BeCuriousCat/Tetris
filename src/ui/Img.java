package ui;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Img {
	/**
	 * ����ͼƬ
	 */
	public static Image WINDOW = new ImageIcon("graphics/window/Window.png").getImage();
	/**
	 * ����ͼƬ 230 36
	 */
	public static Image NUM = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * ֵ��ͼƬ
	 */
	public static Image RECT = new ImageIcon("graphics/window/rect.png").getImage();
	/**
	 * ���ڱ���
	 */
	public static Image POINT = new ImageIcon("graphics/string/point.png").getImage();
	
	/**
	 * ���ڱ��⣨���У�
	 */
	public static Image RMLINE = new ImageIcon("graphics/string/rmline.png").getImage();
	/**
	 * ��ʱ����
	 */
	public static Image tmp_bg = new ImageIcon("graphics/background/light.jpg").getImage();
	/**
	 * ���ݿⴰ�ڱ���
	 */
	public static Image DB = new  ImageIcon("graphics/string/db.png").getImage();
	/**
	 * ���ؼ�¼
	 */
	public static Image DISK = new  ImageIcon("graphics/string/disk.png").getImage();
	/**
	 * ��Ϸ����ķ���ͼƬ��
	 */
	public static final Image ACT = new ImageIcon("graphics/game/rect1.png").getImage();

	/**
	 * ���ڱ���
	 */
	public static Image LEVEL = new  ImageIcon("graphics/string/level.png").getImage();
	
	/**
	 * ��һ��ͼƬ����
	 */
	public static Image[]  NEXT_ACT;
	
	public static List<Image> BG_LIST;
	
	static{
		NEXT_ACT = new Image[7];
		for (int i = 0; i < NEXT_ACT.length; i++) {
			NEXT_ACT[i] = new ImageIcon("graphics/background/"+i+".png").getImage();
		}
		
		//����ͼƬ����
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
