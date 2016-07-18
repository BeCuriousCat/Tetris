package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;

import dto.Player;

public class LayerDataBase extends Layer{

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
	
	public LayerDataBase(int x, int y, int w, int h) {
		super(x, y, w, h);
		SPA = (this.h - (IMG_RECT_H+4)*5 - (PADDING<<1)-Img.DB.getHeight(null)) / MAX_ROW;
		START_Y = PADDING + Img.DB.getHeight(null)+SPA;
	}
	
	public void paint(Graphics g){
		this.createWindow(g);
		g.drawImage(Img.DB, this.x+PADDING, this.y+PADDING, null);
		List<Player> players = this.dto.getDb();
		for (int i = 0; i < MAX_ROW; i++) {
			Player p = players.get(i);
			int nowPoint = this.dto.getNowPoint();
			double percent = (double) nowPoint/p.getPoint();
			percent = percent > 1 ? 1:percent;
			this.drawRect("NO DATA", START_Y+i*(IMG_RECT_H+4+SPA),percent, g);
		}
		
	}

	
}
