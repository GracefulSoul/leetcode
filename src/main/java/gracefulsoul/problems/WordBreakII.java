package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreakII {

	// https://leetcode.com/submissions/detail/545907604/
	public static void main(String[] args) {
		WordBreakII test = new WordBreakII();
		System.out.println(test.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
		System.out.println(test.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
		System.out.println(test.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
	}

	public List<String> wordBreak(String s, List<String> wordDict) {
		return this.recursive(s, wordDict, new HashMap<>());
	}

	private List<String> recursive(String s, List<String> wordDict, Map<String, List<String>> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		} else {
			List<String> result = new ArrayList<>();
			for (String word : wordDict) {
				if (s.startsWith(word)) {
					String temp = s.substring(word.length());
					if (temp.length() == 0) {
						result.add(word);
					} else {
						for (String sub : this.recursive(temp, wordDict, map)) {
							result.add(String.join(" ", word, sub));
						}
					}
				}
			}
			map.put(s, result);
			return result;
		}
	}

}
