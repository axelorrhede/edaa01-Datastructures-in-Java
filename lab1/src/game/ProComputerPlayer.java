package game;

import java.util.Random;

public class ProComputerPlayer extends Player {
	Random rand = new Random();
	
	public ProComputerPlayer(String s) {
		super(s);
	}
	
	public int takePins(Board b) {
		int i;
		if ((b.getNoPins()-2)%3==0) {
			b.takePins(2);
			i = 2;
		}else if((b.getNoPins()-1)%3==0) {
			b.takePins(1);
			i = 1;
		}else {
			i = rand.nextInt(2)+1;
			b.takePins(i);
		}
		UserInterface.printMessage(userid + " tar " + i + " pinnar, det finns nu " +  b.getNoPins() + " pinnar på bordet.");
		return b.getNoPins();
	}

}
