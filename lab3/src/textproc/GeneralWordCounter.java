package textproc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class GeneralWordCounter {

	private Set<String> badwords;
	private Map<String, Integer> map;

	public GeneralWordCounter(Set<String> badwords) {
		this.badwords = badwords;
		map = new TreeMap<>();
	}

	public void process(String w) {
		if (!badwords.contains(w)) {
			if (!map.containsKey(w)) {
				map.put(w, 1);
			} else {
				map.put(w, map.get(w) + 1);
			}

		}
	}

	public void report() {
		Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort( (w1, w2) ->{
			if (w2.getValue() - w1.getValue() == 0) {
				return w1.getKey().compareTo(w2.getKey());
			}
			return w2.getValue() - w1.getValue();
			
		});
		for( int i =0; i<20; i++) {
			System.out.println(wordList.get(i).getKey() + ": " + wordList.get(i).getValue());
			}
	}
	
	
	public List<Map.Entry<String, Integer>> getWordList() {
		Set<Map.Entry<String, Integer>> wordSet = map.entrySet();
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
		wordList.sort( (w1, w2) ->{
			if (w2.getValue() - w1.getValue() == 0) {
				return w1.getKey().compareTo(w2.getKey());
			}
			return w2.getValue() - w1.getValue();
			
		});
		return wordList;
		}

}
