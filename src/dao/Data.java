package dao;

import java.util.List;

import dto.Player;

public interface Data {
	/**
	 * 获得数据
	 * @return
	 */
	public List<Player> loadData();
	/**
	 * 存储数据
	 * @param players
	 */
	public void saveData(List<Player> players);
	
}
