package dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import dto.Player;

public class DataDisk implements Data {

	private static final String FILE_PATH = "save/recode.dat";
	
	@Override
	public List<Player> loadData() {
		ObjectInput  ois = null;
		List<Player> players = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(FILE_PATH));
			players = (List<Player>) ois.readObject();
		}  catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return players;
	}

	@Override
	public void saveData(Player player) {
	/*	ObjectOutputStream oos = null;
		
		try {
			oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH));
			oos.writeObject(players);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	*/	
	}
	
}
