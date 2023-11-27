package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

	// https://leetcode.com/problems/most-common-word/submissions/886229905/
	public static void main(String[] args) {
		MostCommonWord test = new MostCommonWord();
		System.out.println(test.mostCommonWord("Bob hit a ball, the hit BALL flew far after it was hit.", new String[] { "hit" }));
		System.out.println(test.mostCommonWord("a.", new String[] { "" }));
	}

	public String mostCommonWord(String paragraph, String[] banned) {
		Set<String> banList = new HashSet<>(Arrays.asList(banned));
		String[] words = paragraph.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			if (!banList.contains(word)) {
				map.put(word, map.getOrDefault(word, 0) + 1);
			}
		}
		return Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
	}

}
