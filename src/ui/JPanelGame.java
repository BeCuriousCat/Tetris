package ui;

import java.awt.Graphics;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import service.GameService;
import config.ConfigFactory;
import config.GameConfig;
import config.LayerConfig;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;

public class JPanelGame extends JPanel {
	
	private ArrayList<Layer> layers = null;
	
	private GameDto dto = null;
	public JPanelGame(GameDto dto) {
		//���dto����
		this.dto = dto;
		//��ʼ�����
		initComponent();
		//��ʼ����
		initLayer();
	}
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	/**
	 * ��ʼ�����
	 */
	private void initComponent() {
		
	}
	/**
	 * ��ʼ����
	 */
	private void initLayer() {
		try {
			// �����Ϸ����
			GameConfig cfg = ConfigFactory.getGamefig();
			// ��ò�����
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// ������Ϸ������
			layers = new ArrayList<Layer>(layersCfg.size());
			
			// ������в����
			for (LayerConfig layerConfig : layersCfg) {
				// ��������
				Class<?> cls = Class.forName(layerConfig.getClassName());
				// ��ù��캯��
				Constructor<?> ctr = cls.getConstructor(int.class, int.class,
						int.class, int.class);
				// ���ù��캯���������
				Layer layer = (Layer) ctr.newInstance(layerConfig.getX(),
						layerConfig.getY(), layerConfig.getW(),
						layerConfig.getH());
				//������Ϸ���ݶ���
				layer.setDto(this.dto);
				//�Ѵ�����Layer����Layers
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("���ó���");
		}
		/*
		 * lays = new Layer[] { new LayerBackground(0, 0, 0, 0), new
		 * LayerDataBase(40, 32, 334, 279), new LayerDisk(40, 343, 334, 279),
		 * new LayerGame(414, 32, 334, 590), new LayerButton(788, 32, 334, 124),
		 * new LayerNext(788, 188, 176, 148), new LayerLevel(964, 188, 158,
		 * 148), new LayerPoint(788, 368, 334, 200) };
		 */
	}

	@Override
	public void paintComponent(Graphics g) {
		//����Ҫ���෽��
		super.paintComponent(g);
		// ������Ϸ����
		for (int i = 0; i < layers.size(); i++) {
			// ˢ�²㴰��
			layers.get(i).paint(g);
		}
		//ʹ���ؽ���
		this.requestFocus();
	}
}
