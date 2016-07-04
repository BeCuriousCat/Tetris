package config;
//桂壮加了一行注释
public class ConfigFactory {
	private static GameConfig Game_CONFIG = null;
	static{
		try {
			Game_CONFIG = new GameConfig();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public static GameConfig getGamefig(){
		return Game_CONFIG;
	}
}
