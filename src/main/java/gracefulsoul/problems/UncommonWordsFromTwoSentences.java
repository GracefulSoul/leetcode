package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class UncommonWordsFromTwoSentences {

	// https://leetcode.com/problems/uncommon-words-from-two-sentences/submissions/922166294/
	public static void main(String[] args) {
		UncommonWordsFromTwoSentences test = new UncommonWordsFromTwoSentences();
		PrintUtil.print(test.uncommonFromSentences("this apple is sweet", "this apple is sour"));
		PrintUtil.print(test.uncommonFromSentences("apple apple", "banana"));
	}

	public String[] uncommonFromSentences(String s1, String s2) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : s1.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		for (String word : s2.split(" ")) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<String> result = new ArrayList<>();
		for (String word : map.keySet()) {
			if (map.get(word) == 1) {
				result.add(word);
			}
		}
		return result.toArray(new String[result.size()]);
	}

}
