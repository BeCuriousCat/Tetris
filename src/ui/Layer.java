package ui;



import java.awt.Color;
import java.awt.Font;
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
	 * 数字切片的宽度
	 */
	protected static final int  IMG_NUM_W = Img.NUM.getWidth(null) / 10;
	/**
	 * 数字切片的高度
	 */
	protected static final int  IMG_NUM_H = Img.NUM.getHeight(null);
	

	/**
	 * 值槽图片高度
	 */
	protected final int IMG_RECT_H = Img.RMLINE.getHeight(null);
	/**
	 * 值槽图片宽度
	 */
	private final int IMG_RECT_W = Img.RECT.getWidth(null);
	/**
	 * 默认字体
	 */
	Font DEF_FONT = new Font("黑体", Font.BOLD,20);
	
	static{
		//获取配置
		GameConfig gameConfig = ConfigFactory.getGamefig();
		PADDING = gameConfig.getPadding();
		BORDER = gameConfig.getWindowSize();
	}
	

	private static int IMG_W = Img.WINDOW.getWidth(null);
	private static int IMG_H = Img.WINDOW.getHeight(null);
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
	private int rectW;
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}

	public Layer(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.rectW = this.w - (PADDING << 1);
	}

	protected void createWindow(Graphics g) {
		// 左上
		g.drawImage(Img.WINDOW, x, y, x + BORDER, y + BORDER, 0, 0, BORDER,
				BORDER, null);
		// 中上
		g.drawImage(Img.WINDOW, x + BORDER, y, w + x - BORDER, y + BORDER,
				BORDER, 0, IMG_W - BORDER, BORDER, null);
		// 右上
		g.drawImage(Img.WINDOW, w + x - BORDER, y, w + x, y + BORDER, IMG_W
				- BORDER, 0, IMG_W, BORDER, null);
		// 左中
		g.drawImage(Img.WINDOW, x, y + BORDER, x + BORDER, h + y - BORDER, 0,
				BORDER, BORDER, IMG_RECT_H - BORDER, null);
		// 中间
		g.drawImage(Img.WINDOW, x + BORDER, y + BORDER, x + w - BORDER, y + h
				- BORDER, BORDER, BORDER, IMG_W - BORDER, IMG_RECT_H - BORDER, null);
		// 右中
		g.drawImage(Img.WINDOW, x + w - BORDER, y + BORDER, w + x, h + y
				- BORDER, IMG_W - BORDER, BORDER, IMG_W, IMG_RECT_H - BORDER, null);
		// 左下
		g.drawImage(Img.WINDOW, x, y + h - BORDER, x + BORDER, h + y, 0, IMG_RECT_H
				- BORDER, BORDER, IMG_RECT_H, null);
		// 中下
		g.drawImage(Img.WINDOW, x + BORDER, y + h - BORDER, x + w - BORDER, h
				+ y, BORDER, IMG_RECT_H - BORDER, IMG_W - BORDER, IMG_RECT_H, null);
		// 右下
		g.drawImage(Img.WINDOW, x + w - BORDER, y + h - BORDER, x + w, y + h,
				IMG_W - BORDER, IMG_RECT_H - BORDER, IMG_W, IMG_RECT_H, null);
	}
	abstract public void paint(Graphics g);
	
	/**
	 * 正中绘图
	 */
	protected void drawImageAtCenter(Image img,Graphics g){
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x+(this.w - imgW>>1),this.y+(this.h -imgH >>1), null);
	}
	
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
				g.drawImage(Img.NUM, 
						this.x + x + IMG_NUM_W * i ,this.y + y, 
						this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
						bit * IMG_NUM_W, 0,
						(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
			}
		}
	}
	
	/**
	 * 画进度条
	 * @param title
	 * @param precent
	 * @param precent 
	 * @param percent 
	 * @param g
	 */
	protected void drawRect(String title,int rectY, double precent, Graphics g) {
		//各种值初始化
		int rect_x = this.x + PADDING;
		int rect_y = this.y + rectY;
		//绘制背景
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4,
				IMG_RECT_H - 4);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 4, this.y + rectY + 4, this.rectW - 8,
				IMG_RECT_H - 8);
		//绘制槽值
		
		//求宽度
		int w = (int)(precent*this.rectW-4);
		//求颜色
		int subIdx = (int)(precent*IMG_RECT_W)-1;
		g.drawImage(Img.RECT, 
				rect_x + 4, rect_y+4,
				rect_x  +w, rect_y + 4 + IMG_RECT_H,
				subIdx, 0, subIdx+1, IMG_RECT_H,
				null);
		//显示下一级字体
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x+PADDING, rect_y+23);
		
	}
}
