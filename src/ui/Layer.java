package ui;

import static ui.Layer.IMG_NUM;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import config.ConfigFactory;
import config.GameConfig;
import dto.GameDto;

/**
 * ��������
 * 
 * @author chenzewei
 *
 */
public abstract class Layer {
	
	// �ڱ߾�
	protected static final int PADDING;
	// �߿���
	protected static final int BORDER;
	
	/**
	 * ����ͼƬ 230 36
	 */
	protected static Image IMG_NUM = new ImageIcon("graphics/string/num.png").getImage();
	/**
	 * ������Ƭ�Ŀ��
	 */
	protected static final int  IMG_NUM_W = IMG_NUM.getWidth(null) / 10;
	/**
	 * ������Ƭ�ĸ߶�
	 */
	protected static final int  IMG_NUM_H = IMG_NUM.getHeight(null);
	
	static{
		//��ȡ����
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
	// ����ͼƬ���
	// private static final int IMG_W = Img.

	// �������ڵ�X����
	protected int x;
	// �������ڵ�Y����
	protected int y;
	// �������ڵĸ߶�
	protected int h;
	// �������ڵĿ��
	protected int w;
	//��Ϸ����
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
		// ����
		g.drawImage(WINDOW_IMG, x, y, x + BORDER, y + BORDER, 0, 0, BORDER,
				BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x + BORDER, y, w + x - BORDER, y + BORDER,
				BORDER, 0, IMG_W - BORDER, BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, w + x - BORDER, y, w + x, y + BORDER, IMG_W
				- BORDER, 0, IMG_W, BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x, y + BORDER, x + BORDER, h + y - BORDER, 0,
				BORDER, BORDER, IMG_H - BORDER, null);
		// �м�
		g.drawImage(WINDOW_IMG, x + BORDER, y + BORDER, x + w - BORDER, y + h
				- BORDER, BORDER, BORDER, IMG_W - BORDER, IMG_H - BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + BORDER, w + x, h + y
				- BORDER, IMG_W - BORDER, BORDER, IMG_W, IMG_H - BORDER, null);
		// ����
		g.drawImage(WINDOW_IMG, x, y + h - BORDER, x + BORDER, h + y, 0, IMG_H
				- BORDER, BORDER, IMG_H, null);
		// ����
		g.drawImage(WINDOW_IMG, x + BORDER, y + h - BORDER, x + w - BORDER, h
				+ y, BORDER, IMG_H - BORDER, IMG_W - BORDER, IMG_H, null);
		// ����
		g.drawImage(WINDOW_IMG, x + w - BORDER, y + h - BORDER, x + w, y + h,
				IMG_W - BORDER, IMG_H - BORDER, IMG_W, IMG_H, null);
	}
	abstract public void paint(Graphics g);
	
	
	/**
	 * ��ʾ����
	 * @param x ���Ͻ�x����
	 * @param y ���Ͻ�y����
	 * @param num Ҫ��ʾ������
	 * @param maxBit ����λ�� 
	 * @param g	���ʶ���
	 */
	public void drawNumberLeftPad(int x,int y,int num,int maxBit,Graphics g){
		//������num�е�ÿһλȡ����
		String strNum = Integer.toString(num);
		//ѭ�����������Ҷ���
		for (int i = 0; i < maxBit; i++) {
			//�ж��Ƿ������������
			if( maxBit - i <= strNum.length()) {
				//�������ַ����е��±�
				int idx = i - maxBit + strNum.length();
				//������num��ÿһλȡ��
				int bit = strNum.charAt(idx) - '0';
				//��������
				g.drawImage(IMG_NUM, 
						this.x + x + IMG_NUM_W * i ,this.y + y, 
						this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
						bit * IMG_NUM_W, 0,
						(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
			}
		}
	}
}
