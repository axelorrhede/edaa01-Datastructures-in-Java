package game;

import java.util.Scanner;

public class HumanPlayer extends Player {
	Scanner scan = new Scanner(System.in);
	
	public HumanPlayer(String s) {
		super(s);
	}
	
	public int takePins(Board b) {
		b.takePins(TakePinsGame2.goodNumber(2, "Hur många pinnar vill " + userid + " ta? Det finns " + b.getNoPins() + " pinnar på bordet"));
		return b.getNoPins();
	}
	

}
