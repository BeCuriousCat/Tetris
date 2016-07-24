package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import dto.Player;

public abstract class LayerDate extends Layer{
	
	//TODO　配置文件
	private static final int MAX_ROW = 5;
	
	/**
	 * 其实y坐标
	 */
	private static int START_Y = 0;
	/**
	 * 间距
	 */
	private static int SPA = 0;
	
	public LayerDate(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - (IMG_RECT_H+4)*5 - (PADDING<<1)-Img.DB.getHeight(null)) / MAX_ROW;
		START_Y = PADDING + Img.DB.getHeight(null)+SPA;
		
	}

	@Override
	public abstract void paint(Graphics g);
	/**
	 * 绘制所有值槽
	 * @param imgTitle 标题图片
	 * @param players  数据源
	 * @param g	画笔
	 */
	public void showDate(Image imgTitle,List<Player> players,Graphics g){
		g.drawImage(imgTitle, this.x+PADDING, this.y+PADDING, null);
		players = this.dto.getDb();
		for (int i = 0; i < MAX_ROW; i++) {
			Player p = players.get(i);
			int nowPoint = this.dto.getNowPoint();
			double percent = (double) 100/p.getPoint();
			percent = percent > 1 ? 1:percent;
			this.drawRect(p.getName(), START_Y+i*(IMG_RECT_H+4+SPA),percent, g);
			
		}
	}
}
