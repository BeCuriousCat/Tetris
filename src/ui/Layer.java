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
	 * ������Ƭ�Ŀ��
	 */
	protected static final int  IMG_NUM_W = Img.NUM.getWidth(null) / 10;
	/**
	 * ������Ƭ�ĸ߶�
	 */
	protected static final int  IMG_NUM_H = Img.NUM.getHeight(null);
	

	/**
	 * ֵ��ͼƬ�߶�
	 */
	protected final int IMG_RECT_H = Img.RMLINE.getHeight(null);
	/**
	 * ֵ��ͼƬ���
	 */
	private final int IMG_RECT_W = Img.RECT.getWidth(null);
	/**
	 * Ĭ������
	 */
	Font DEF_FONT = new Font("����", Font.BOLD,20);
	
	static{
		//��ȡ����
		GameConfig gameConfig = ConfigFactory.getGamefig();
		PADDING = gameConfig.getPadding();
		BORDER = gameConfig.getWindowSize();
	}
	

	private static int IMG_W = Img.WINDOW.getWidth(null);
	private static int IMG_H = Img.WINDOW.getHeight(null);
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
		// ����
		g.drawImage(Img.WINDOW, x, y, x + BORDER, y + BORDER, 0, 0, BORDER,
				BORDER, null);
		// ����
		g.drawImage(Img.WINDOW, x + BORDER, y, w + x - BORDER, y + BORDER,
				BORDER, 0, IMG_W - BORDER, BORDER, null);
		// ����
		g.drawImage(Img.WINDOW, w + x - BORDER, y, w + x, y + BORDER, IMG_W
				- BORDER, 0, IMG_W, BORDER, null);
		// ����
		g.drawImage(Img.WINDOW, x, y + BORDER, x + BORDER, h + y - BORDER, 0,
				BORDER, BORDER, IMG_RECT_H - BORDER, null);
		// �м�
		g.drawImage(Img.WINDOW, x + BORDER, y + BORDER, x + w - BORDER, y + h
				- BORDER, BORDER, BORDER, IMG_W - BORDER, IMG_RECT_H - BORDER, null);
		// ����
		g.drawImage(Img.WINDOW, x + w - BORDER, y + BORDER, w + x, h + y
				- BORDER, IMG_W - BORDER, BORDER, IMG_W, IMG_RECT_H - BORDER, null);
		// ����
		g.drawImage(Img.WINDOW, x, y + h - BORDER, x + BORDER, h + y, 0, IMG_RECT_H
				- BORDER, BORDER, IMG_RECT_H, null);
		// ����
		g.drawImage(Img.WINDOW, x + BORDER, y + h - BORDER, x + w - BORDER, h
				+ y, BORDER, IMG_RECT_H - BORDER, IMG_W - BORDER, IMG_RECT_H, null);
		// ����
		g.drawImage(Img.WINDOW, x + w - BORDER, y + h - BORDER, x + w, y + h,
				IMG_W - BORDER, IMG_RECT_H - BORDER, IMG_W, IMG_RECT_H, null);
	}
	abstract public void paint(Graphics g);
	
	/**
	 * ���л�ͼ
	 */
	protected void drawImageAtCenter(Image img,Graphics g){
		int imgW = img.getWidth(null);
		int imgH = img.getHeight(null);
		g.drawImage(img, this.x+(this.w - imgW>>1),this.y+(this.h -imgH >>1), null);
	}
	
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
				g.drawImage(Img.NUM, 
						this.x + x + IMG_NUM_W * i ,this.y + y, 
						this.x + x + IMG_NUM_W * ( i + 1 ), this.y + y + IMG_NUM_H, 
						bit * IMG_NUM_W, 0,
						(bit+1)*IMG_NUM_W, IMG_NUM_H, null);
			}
		}
	}
	
	/**
	 * ��������
	 * @param title
	 * @param precent
	 * @param precent 
	 * @param percent 
	 * @param g
	 */
	protected void drawRect(String title,int rectY, double precent, Graphics g) {
		//����ֵ��ʼ��
		int rect_x = this.x + PADDING;
		int rect_y = this.y + rectY;
		//���Ʊ���
		g.setColor(Color.BLACK);
		g.fillRect(rect_x, rect_y, this.rectW, IMG_RECT_H);
		g.setColor(Color.WHITE);
		g.fillRect(rect_x + 2, rect_y + 2, this.rectW - 4,
				IMG_RECT_H - 4);
		g.setColor(Color.BLACK);
		g.fillRect(rect_x + 4, this.y + rectY + 4, this.rectW - 8,
				IMG_RECT_H - 8);
		//���Ʋ�ֵ
		
		//����
		int w = (int)(precent*this.rectW-4);
		//����ɫ
		int subIdx = (int)(precent*IMG_RECT_W)-1;
		g.drawImage(Img.RECT, 
				rect_x + 4, rect_y+4,
				rect_x  +w, rect_y + 4 + IMG_RECT_H,
				subIdx, 0, subIdx+1, IMG_RECT_H,
				null);
		//��ʾ��һ������
		g.setColor(Color.WHITE);
		g.setFont(DEF_FONT);
		g.drawString(title, rect_x+PADDING, rect_y+23);
		
	}
}
