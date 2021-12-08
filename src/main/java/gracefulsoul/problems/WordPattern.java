package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {

	// https://leetcode.com/submissions/detail/598577015/
	public static void main(String[] args) {
		WordPattern test = new WordPattern();
		System.out.println(test.wordPattern("abba", "dog cat cat dog"));
		System.out.println(test.wordPattern("abba", "dog cat cat fish"));
		System.out.println(test.wordPattern("aaaa", "dog cat cat dog"));
		System.out.println(test.wordPattern("abba", "dog dog dog dog"));
	}

	public boolean wordPattern(String pattern, String s) {
		char[] patterns = pattern.toCharArray();
		String[] words = s.split(" ");
		if (patterns.length != words.length) {
			return false;
		}
		Map<Object, Integer> map = new HashMap<>();
		for (Integer idx = 0; idx < words.length; idx++) {
			if (map.put(patterns[idx], idx) != map.put(words[idx], idx)) {
				return false;
			}
		}
		return true;
	}

}
