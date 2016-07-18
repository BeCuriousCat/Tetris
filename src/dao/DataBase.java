package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataBase implements Data{

	@Override
	public List<Player> loadData() {
		//TODO
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("小明",100));
		players.add(new Player("小明",100));
		players.add(new Player("小明",100));
		players.add(new Player("小明",100));
		players.add(new Player("小明",100));
		return players;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		
	}

}
