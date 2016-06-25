package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/**
	 * 窗口宽度
	 */
	private int width;
	/**
	 * 窗口高度
	 */
	private int hight;
	/**
	 * 窗口边框
	 */
	private int windowSize;
	/**
	 * 窗口拔高 
	 */
	private int windowUp;
	/**
	 * 窗口外边距
	 */
	private int padding;
	/**
	 * 图层
	 */
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	private List<LayerConfig> layersConfig;
	
	public int getWindowUp() {
		return windowUp;
	}
	public int getWidth() {
		return width;
	}

	public int getHight() {
		return hight;
	}

	public int getWindowSize() {
		return windowSize;
	}

	public int getPadding() {
		return padding;
	}

	public List<LayerConfig> getLayersConfig() {
		return layersConfig;
	}

	public GameConfig() throws DocumentException {
		// 创建XML读取器
		SAXReader reader = new SAXReader();
		// 读取XML文件
		Document doc = reader.read("config/cfg.xml");
		// 获取XML文件的根节点
		Element game = doc.getRootElement();
		// 配置窗口参数
		this.setUiConfig(game.element("frame"));
		// 配置系统参数
		this.setSystemConfig(game.element("system"));
		// 配置数据访问参数
		this.setDataConfig(game.element("frame"));
	}

	/**
	 * 配置窗口参数
	 * 
	 * @param frame
	 *            配置文件窗口配置元素
	 * @return
	 */
	private void setUiConfig(Element frame) {
		//获取窗口宽度
		this.width = Integer.parseInt(frame.attributeValue("width"));
		//获取窗口高度
		this.hight = Integer.parseInt(frame.attributeValue("height"));
		//获取边框粗细
		this.windowSize = Integer.parseInt(frame.attributeValue("windowSize"));
		//获取标题
		this.padding = Integer.parseInt(frame.attributeValue("padding"));
		//获取窗口拔高
		this.windowUp = Integer.parseInt(frame.attributeValue("windowUp"));
		//获取窗口属性
		List<Element> layers = frame.elements("layer");
		layersConfig = new ArrayList<LayerConfig>();
		for (Element layer : layers) {
			LayerConfig lc = new LayerConfig(layer.attributeValue("class"),
					Integer.parseInt(layer.attributeValue("x")),
					Integer.parseInt(layer.attributeValue("y")),
					Integer.parseInt(layer.attributeValue("w")),
					Integer.parseInt(layer.attributeValue("h")));
			layersConfig.add(lc);
		}
	}

	/**
	 * 配置系统参数
	 * 
	 * @param system
	 */
	private void setSystemConfig(Element system) {
		// TODO 配置系统参数
	}

	/**
	 * 配置系统访问参数
	 * 
	 * @param frame
	 */
	private void setDataConfig(Element frame) {
		// TODO 配置系统访问参数
	}
}
