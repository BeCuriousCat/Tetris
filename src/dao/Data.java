package dao;

import java.util.List;

import dto.Player;

public interface Data {
	/**
	 * �������
	 * @return
	 */
	public List<Player> loadData();
	/**
	 * �洢����
	 * @param players
	 */
	public void saveData(List<Player> players);
	
}
