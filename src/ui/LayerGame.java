package ui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;

public class LayerGame extends Layer {

	private static Image ACT = new ImageIcon("graphics/game/rect.png").getImage();
	//TODO �����ļ�
	private static int ACT_SIZE = 32;

	public LayerGame(int x, int y, int w, int h) {
		super(x, y, w, h);
	}

	public void paint(Graphics g) {
		this.createWindow(g);
		Point[] points = this.dto.getGameAct().getActPoints();
		for (int i = 0; i < points.length; i++) {
			g.drawImage(ACT, 
					this.x + points[i].x * ACT_SIZE + BORDER, 
					this.y + points[i].y * ACT_SIZE + BORDER, 
					this.x + points[i].x * ACT_SIZE + ACT_SIZE + BORDER, 
					this.y + points[i].y * ACT_SIZE + ACT_SIZE + BORDER, 
					32,0, 64, 32, null);
		}
		
		//��ӡ��ͼ
		boolean[][] map = this.dto.getGameMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if(map[x][y]){
					g.drawImage(ACT, 
							this.x + x * ACT_SIZE + BORDER, 
							this.y + y * ACT_SIZE + BORDER, 
							this.x + x * ACT_SIZE + ACT_SIZE + BORDER, 
							this.y + y * ACT_SIZE + ACT_SIZE + BORDER, 
							0,0, 32, 32, null);
				}
			}
		}
	}
}
