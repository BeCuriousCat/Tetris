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
		//获得dto对象
		this.dto = dto;
		//初始化组件
		initComponent();
		//初始化层
		initLayer();
	}
	public void setGameControl(PlayerControl control){
		this.addKeyListener(control);
	}
	/**
	 * 初始化组件
	 */
	private void initComponent() {
		
	}
	/**
	 * 初始化层
	 */
	private void initLayer() {
		try {
			// 获得游戏配置
			GameConfig cfg = ConfigFactory.getGamefig();
			// 获得层配置
			List<LayerConfig> layersCfg = cfg.getLayersConfig();
			// 创建游戏层数组
			layers = new ArrayList<Layer>(layersCfg.size());
			
			// 获得所有层对象
			for (LayerConfig layerConfig : layersCfg) {
				// 获得类对象
				Class<?> cls = Class.forName(layerConfig.getClassName());
				// 获得构造函数
				Constructor<?> ctr = cls.getConstructor(int.class, int.class,
						int.class, int.class);
				// 调用构造函数创造对象
				Layer layer = (Layer) ctr.newInstance(layerConfig.getX(),
						layerConfig.getY(), layerConfig.getW(),
						layerConfig.getH());
				//设置游戏数据对象
				layer.setDto(this.dto);
				//把创建的Layer放入Layers
				layers.add(layer);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("配置出错");
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
		//调用要基类方法
		super.paintComponent(g);
		// 绘制游戏界面
		for (int i = 0; i < layers.size(); i++) {
			// 刷新层窗口
			layers.get(i).paint(g);
		}
		//使返回焦点
		this.requestFocus();
	}
}
