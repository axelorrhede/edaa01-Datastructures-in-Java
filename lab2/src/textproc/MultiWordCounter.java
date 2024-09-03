package textproc;

import java.util.Map;
import java.util.TreeMap;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> map;
	
	public MultiWordCounter(String[] words) {
		map = new TreeMap<String, Integer>();
		for (String s: words) {
			map.put(s,0);
		}
	}

	public void process(String w) {
		if (map.containsKey(w)) {
			map.put(w, map.get(w) + 1);
		}
	}

	public void report() {
		for (String key : map.keySet()) {
			System.out.println(key + ": " + map.get(key));
		}
	}

}
