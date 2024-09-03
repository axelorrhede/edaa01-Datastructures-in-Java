package game;

public abstract class Player {
	String userid;
	
	public Player(String s) {
		userid = s;
	}
	public String getUserId() {
		return userid;
	}
	
	public abstract int takePins(Board b);

}
