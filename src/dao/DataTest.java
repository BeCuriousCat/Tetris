package dao;

import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataTest implements Data{
	@Override
	public List<Player> loadData() {
		//TODO
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("С�� ",100));
		players.add(new Player("С��",200));
		players.add(new Player("С��",1600));
		players.add(new Player("С��",800));
		players.add(new Player("С��",150));
		return players;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		
	}
}
