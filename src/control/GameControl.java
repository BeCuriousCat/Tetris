package control;

import dao.DataTest;
import service.GameService;
import ui.JPanelGame;
/**
 * ������Ҽ����¼�
 * ���ƻ���
 * ������Ϸ�߼�
 * @author chenzewei
 */
public class GameControl {
	/**
	 * ��Ϸ�����
	 */
	private JPanelGame panelGame; 
	/**
	 * ��Ϸ�߼���
	 */
	private GameService gameService;
	private DataTest dataA;
	private DataTest dataB;
	public GameControl(JPanelGame panelGame, GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
		//�����ݽӿ�A ������ݿ��¼
		this.dataA = new DataTest();
		//�������ݿ��¼����Ϸ
		this.gameService.setRecodeDataBase(dataA.loadData());
		//�����ݽӿ�B��ȡ���ݿ��¼
		this.dataB = new DataTest();
		//���ñ��ؼ�¼����Ϸ
		this.gameService.setDiskRecode(dataB.loadData());
	}
	public void test() {
		this.panelGame.repaint();
	}
	/**
	 * ���������򽨣��ϣ�
	 */
	public void keyUp() {
		this.gameService.keyUp();
		this.panelGame.repaint();
		
		this.gameService.testLevelUp();
		this.panelGame.repaint();
	}
	/**
	 * ���������򽨣��£�
	 */
	public void keyDown() {
		this.gameService.keyDown();
		this.panelGame.repaint();
	}
	/**
	 * ���������򽨣���
	 */
	public void keyLeft() {
		this.gameService.keyLeft();
		this.panelGame.repaint();
	}
	/**
	 * ���������򽨣��ң�
	 */
	public void keyRight() {
		this.gameService.keyRight();
		this.panelGame.repaint();
	}
}
