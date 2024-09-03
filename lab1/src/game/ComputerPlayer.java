package game;

import java.util.Random;

public class ComputerPlayer extends Player {
	private Random rand = new Random();
	
	public ComputerPlayer(String s) {
		super(s);
	}
	
	public int takePins(Board b) {
		int i = rand.nextInt(2)+1;
		b.takePins(i);
		UserInterface.printMessage(userid + " tar " + i + " pinnar, det finns nu " +  b.getNoPins() + " pinnar på bordet.");
		return b.getNoPins();
	}

}
