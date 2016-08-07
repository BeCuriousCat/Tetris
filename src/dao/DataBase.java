package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import dto.Player;

public class DataBase implements Data {

	private static String Driver = "com.mysql.jdbc.Driver";
	private static String USER = "tetris";
	private static String PASSWORD = "tetris";
	private static String URL = "jdbc:mysql://115.28.172.55:3306/tetris";

	private static String LOAD_SQL = "SELECT * FROM user_point ORDER BY point LIMIT 5";
	private static String SAVE_SQL = "INSERT INTO user_point  (username,point,type_id) VALUES (?,?,?)";
	static {
		try {
			Class.forName(Driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Player> loadData() {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Player> players = new Vector<Player>();
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.prepareStatement(LOAD_SQL);
			rs = stmt.executeQuery();
			while (rs.next()) {
				Player player = new Player(rs.getString(2).toString(),
						Integer.valueOf(rs.getString(3)));
				players.add(player);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

		return players;
	}

	@Override
	public void saveData(Player player) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection(URL,USER,PASSWORD);
			stmt = conn.prepareStatement(SAVE_SQL);
			stmt.setObject(1, player.getName());
			stmt.setObject(2, player.getPoint());
			stmt.setObject(3, 1);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (stmt != null)
					stmt.close();
				if (rs != null)
					rs.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}

	public static void main(String[] args) throws SQLException {
		/*
		 * Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
		 * if(conn != null ){ System.out.println("连接成功"); } conn.close();
		 */

		DataBase db = new DataBase();
		/*List<Player> players = db.loadData();*/
		Player p = new Player("小名",5935);
		db.saveData(p);
	}
}
