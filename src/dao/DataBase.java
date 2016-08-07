package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;





import dto.Player;

public class DataBase implements Data{

	private static String Driver = "com.mysql.jdbc.Driver";
	private static String USER = "tetris";
	private static String PASSWORD = "tetris";
	private static String URL = "jdbc:mysql://115.28.172.55:3306/tetris";

	static{
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Player> loadData() {
		
	
		return null;
	}

	@Override
	public void saveData(List<Player> players) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) throws SQLException {
		 Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		 if(conn != null ){
			 System.out.println("连接成功");
		 }
		 conn.close();
	}
}
