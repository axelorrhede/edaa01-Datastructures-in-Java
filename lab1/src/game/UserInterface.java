package game;

import javax.swing.JOptionPane;

public class UserInterface {
	JOptionPane pane;
	
	public UserInterface() {
		pane = new JOptionPane();
	}
	public static void printMessage(String msg) {
		JOptionPane.showMessageDialog(null, msg);
	}
	/**
	* Visar en dialogruta med texten msg och och läser in ett positivt heltal. Om
	* användaren skriver något som inte kan tolkas som ett positivt heltal ska -1
	* returneras. Om användaren klickar på "Avbryt" ska -2 returneras.
	*/
	public static int askForInt(String msg) {
		String s = JOptionPane.showInputDialog(null,msg);
		if(s == null) {
			return -2;
			//Avsluta programmet här
		}
		try {
			return Integer.valueOf(s);
		}
		catch( Exception e){
			return -1;
		}
	}
	public static String askForString(String msg) {
		String s = JOptionPane.showInputDialog(null,msg);
		if(s==null) {
			TakePinsGame2.go = false;
		}
		return  s;
	}


}
