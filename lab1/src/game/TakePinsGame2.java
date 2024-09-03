package game;

public class TakePinsGame2 {
	static boolean go; //Finns det bättre metod för att avbryta programmet? Jag behövde checka go lite överallt (är go ett reserverat ord, varför är det blått?)

	public static void main(String[] args) {
		go = true;
		Board b = new Board();
		int sp = goodNumber(100, "Hur många spelare är ni?");
		int cp = goodNumber(100, "Hur många datorspelare vill ni ha?");
		int pp = goodNumber(100, "Hur många professionella datorspelare vill ni ha?");
		b.setUp(goodNumber(100, "Hur många pinnar vill ni köra med?"));
		if(go) {
			Player[] players = new Player[sp + cp+pp];
			for (int p = 0; p<sp;p++) {
				if(go) {
					players[p] = new HumanPlayer(UserInterface.askForString("Vad heter spelare " + (p+1)));
				}
			}
			for(int c = sp; c<sp+cp; c++) {
				players[c] = new ComputerPlayer("dator " + (c-sp+1));
			}
			for(int d = sp+cp; d<sp+cp+pp; d++) {
				players[d] = new ProComputerPlayer("proffsdator " + (d-sp-cp+1));
			}
			int i = -1;
			if(go) {
				UserInterface.printMessage("Nu startar spelet");
			}
			while(b.getNoPins() >=1 && go) {
				i++;
				if (i == sp+cp+pp) {
					i=0;
				}	
				players[i].takePins(b);
			}
			if (go) {
				UserInterface.printMessage(players[i].getUserId() + " vann!");
			}
		}	

	}
	public static int goodNumber(int i, String s) {
		while(go) {
			int p = UserInterface.askForInt(s);
			if (p == -2) {
				go = false;
				return 1;
			}else if(p == -1) {
				UserInterface.printMessage("Det måste vara ett tillåtet nummer");
			}else if(p<0 ||p>=i ) {
				UserInterface.printMessage("Siffran måste vara mellan 0 och " + (i-1) );
			}else {
				return p;
			}
		}
		return 1;
	}

}
