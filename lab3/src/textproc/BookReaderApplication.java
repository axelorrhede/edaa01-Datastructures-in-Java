package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class BookReaderApplication {

	public static void main(String[] args) throws FileNotFoundException { // hjälp Varför måste jag throwa här?
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		File selectedFile = new File("nilsholg.txt");

		int returnValue = jfc.showOpenDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			selectedFile = jfc.getSelectedFile();
		}
		Scanner scan = new Scanner(new File("undantagsord.txt"));
		TreeSet<String> badwords = new TreeSet<String>();
		while (scan.hasNext()) {
			badwords.add(scan.next().toLowerCase());
		}
		scan.close();

		Scanner s = new Scanner(selectedFile);
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		GeneralWordCounter wCount = new GeneralWordCounter(badwords);

		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			wCount.process(word);

		}
		s.close();

		BookReaderController bRead = new BookReaderController(wCount);

	}

}
