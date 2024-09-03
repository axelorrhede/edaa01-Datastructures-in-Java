package game;

/* förberedelseupppgifter
 * Superklass
 * player kan intehålla human player
 * human player kan innehålla human player
 */

public class Board {
	private int noPins;
	
	public Board() {
	}
	
	public void setUp(int n) {
		noPins = n;
	}
	public void takePins(int n) {
		noPins -= n;
		
	}
	public int getNoPins() {
		return noPins;
	}


}
