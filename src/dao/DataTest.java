package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{
	@Override
	public List<Player> loadData() {
		//TODO
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("小红 ",100));
		players.add(new Player("小明",200));
		players.add(new Player("小周",1600));
		players.add(new Player("小东",800));
		players.add(new Player("小明",150));
		return players;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		
	}
}
