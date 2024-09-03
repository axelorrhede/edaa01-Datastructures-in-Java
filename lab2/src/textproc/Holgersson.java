package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Holgersson {

	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		long t0 = System.nanoTime();

		Scanner scan = new Scanner(new File("undantagsord.txt"));
		TreeSet<String> badwords = new TreeSet<String>();
		while(scan.hasNext()) {
			badwords.add(scan.next().toLowerCase());
		}
		scan.close();

		ArrayList<TextProcessor> list = new ArrayList<TextProcessor>();
		list.add(new SingleWordCounter("nils"));
		list.add(new SingleWordCounter("norge"));
		list.add(new MultiWordCounter(REGIONS));
		list.add(new GeneralWordCounter(badwords));

		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+"); // se handledning

		while (s.hasNext()) {
			String word = s.next().toLowerCase();

			for (TextProcessor p : list) {
				p.process(word);
			}

		}

		s.close();

		for (TextProcessor p : list) {
			p.report();
		}
		long t1 = System.nanoTime();
		System.out.println("tid: " + (t1 - t0) / 1000000.0 + " ms");
		
	}
}

// median 940 ms med hashmap
// median 1029 ms med treemap men nu är landskapen i bokstavsordning

/*
 * Map är en abstrakt klass, och kan inte ha några instanser av sig, hashmap är
 * en map sorterad efter hashkoden på dess keys Treemap är sorterad i
 * bokstavsordning på keys När vi använder map kan det ta in både hashmap och
 * treemap, vilket är bra när man är osäker på vad man faktiskt vill använda
 * comparator är det som skapas av lambdauttrycket, och det är i stort sett ett
 * sätt att använda metoden som vi skriver i lambdauttrycket för en klass även
 * om klassen inte har denna metoden
 */