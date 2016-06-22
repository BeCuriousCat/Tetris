package config;

import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class GameConfig {
	/**
	 * ���ڿ��
	 */
	private int width;
	/**
	 * ���ڸ߶�
	 */
	private int hight;
	/**
	 * ���ڱ߿�
	 */
	private int windowSize;
	/**
	 * ������߾�
	 */
	private int padding;
	/**
	 * ͼ��
	 */

	private List<LayerConfig> layersConfig;

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
		// ����XML��ȡ��
		SAXReader reader = new SAXReader();
		// ��ȡXML�ļ�
		Document doc = reader.read("config/cfg.xml");
		// ��ȡXML�ļ��ĸ��ڵ�
		Element game = doc.getRootElement();
		// ���ô��ڲ���
		this.setUiConfig(game.element("frame"));
		// ����ϵͳ����
		this.setSystemConfig(game.element("system"));
		// �������ݷ��ʲ���
		this.setDataConfig(game.element("frame"));
	}

	/**
	 * ���ô��ڲ���
	 * 
	 * @param frame
	 *            �����ļ���������Ԫ��
	 * @return
	 */
	private void setUiConfig(Element frame) {
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
	 * ����ϵͳ����
	 * 
	 * @param system
	 */
	private void setSystemConfig(Element system) {
		// TODO ����ϵͳ����
	}

	/**
	 * ����ϵͳ���ʲ���
	 * 
	 * @param frame
	 */
	private void setDataConfig(Element frame) {
		// TODO ����ϵͳ���ʲ���
	}
}
