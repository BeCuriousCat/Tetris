package control;

import service.GameService;
import ui.JPanelGame;
/**
 * 接受玩家键盘事件
 * 控制画面
 * 控制游戏逻辑
 * @author chenzewei
 */
public class GameControl {
	/**
	 * 游戏界面层
	 */
	private JPanelGame panelGame; 
	/**
	 * 游戏逻辑层
	 */
	private GameService gameService;
	public GameControl(JPanelGame panelGame, GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
	}
	public void test() {
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向建（上）
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
		
		this.gameService.testLevelUp();
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向建（下）
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向建（左）
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	/**
	 * 控制器方向建（右）
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
