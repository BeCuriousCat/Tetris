package ui;

import static ui.Layer.IMG_NUM;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/**
 * 创建窗口
 * 
 * @author chenzewei
 *
 */
public abstract class Layer {
	
	// 内边距
	protected static final int PADDING;
	// 边框宽度
	protected static final int BORDER;
	
	/**
	 * 数字图片 230 36
	 */
	protected static Image IMG_NUM = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * 数字切片的宽度
	 */
	protected static final int  IMG_NUM_W = IMG_NUM.getWidth(null) / 10;
	/**
	 * 数字切片的高度
	 */
	protected static final int  IMG_NUM_H = IMG_NUM.getHeight(null);
	
	static{
		//获取配置
		GameConfig gameConfig = ConfigFactory.getGamefig();
		PADDING = gameConfig.getPadding();
		BORDER = gameConfig.getWindowSize();
	}
	
	private static Image WINDOW_IMG = new ImageIcon("graphics/window/Window.png").getImage();
	private static int IMG_W = WINDOW_IMG.getWidth(null);
	private static int IMG_H = WINDOW_IMG.getHeight(null);
	/*static {
		FrameConfig fCfg = GameConfig.getFrameConfig();

	}*/
	// 窗口图片宽度
	// private static final int IMG_W = Img.

	// 窗口所在的X坐标
	protected int x;
	// 窗口所在的Y坐标
	protected int y;
	// 窗口所在的高度
	protected int h;
	// 窗口所在的宽度
	protected int w;
	//游戏数据
	protected GameDto dto=null;
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}

	public Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	protected void createWindow(Graphics g) {
		// 左上
		g.drawImage(WINDOW_IMG, x, y, x + BORDER, y + BORDER, 0, 0, BORDER,
				BORDER, null);
		// 中上
		g.drawImage(WINDOW_IMG, x + BORDER, y, w + x - BORDER, y + BORDER,
				BORDER, 0, IMG_W - BORDER, BORDER, null);
		// 右上
		g.drawImage(WINDOW_IMG, w + x - BORDER, y, w + x, y + BORDER, IMG_W
				- BORDER, 0, IMG_W, BORDER, null);
		// 左中
		g.drawImage(WINDOW_IMG, x, y + BORDER, x + BORDER, h + y - BORDER, 0,
				BORDER, BORDER, IMG_H - BORDER, null);
		// 中间
		g.drawImage(WINDOW_IMG, x + BORDER, y + BORDER, x + w - BORDER, y + h
				- BORDER, BORDER, BORDER, IMG_W - BORDER, IMG_H - BORDER, null);
		// 右中
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + BORDER, w + x, h + y
				- BORDER, IMG_W - BORDER, BORDER, IMG_W, IMG_H - BORDER, null);
		// 左下
		g.drawImage(WINDOW_IMG, x, y + h - BORDER, x + BORDER, h + y, 0, IMG_H
				- BORDER, BORDER, IMG_H, null);
		// 中下
		g.drawImage(WINDOW_IMG, x + BORDER, y + h - BORDER, x + w - BORDER, h
				+ y, BORDER, IMG_H - BORDER, IMG_W - BORDER, IMG_H, null);
		// 右下
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + h - BORDER, x + w, y + h,
				IMG_W - BORDER, IMG_H - BORDER, IMG_W, IMG_H, null);
	}
	abstract public void paint(Graphics g);
	
	
	/**
	 * 显示数字
	 * @param x 左上角x坐标
	 * @param y 左上角y坐标
	 * @param num 要显示的数字
	 * @param maxBit 数字位数 
	 * @param g	画笔对象
	 */
	public void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g){
		//把数组num中的每一位取出来
		String strNum = Integer.toString(num);
		//循环绘制数字右对齐
		for (int i = 0; i < maxBit; i++) {
			//判断是否满足绘制条件
			if( maxBit - i <= strNum.length()) {
				//数字在字符串中的下标
				int idx = i - maxBit + strNum.length();
				//把数字num中每一位取出
				int bit = strNum.charAt(idx) - '0';
				//绘制数字
				g.drawImage(IMG_NUM, 
						this.x + x + IMG_NUM_W * i ,this.y + y, 
						this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
						bit * IMG_NUM_W, 0,
						(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
			}
		}
	}
}
