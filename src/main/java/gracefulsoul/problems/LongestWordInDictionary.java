package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

	// https://leetcode.com/submissions/detail/840021618/
	public static void main(String[] args) {
		LongestWordInDictionary test = new LongestWordInDictionary();
		System.out.println(test.longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(test.longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
	}

	public String longestWord(String[] words) {
		String result = "";
		Set<String> set = new HashSet<>();
		for (String word : words) {
			set.add(word);
		}
		for (String word : words) {
			int wordLength = word.length();
			int longestLength = result.length();
			if (wordLength > longestLength || (wordLength == longestLength && word.compareTo(result) < 0)) {
				boolean isLongestWord = true;
				for (int idx = 1; idx < wordLength; idx++) {
					if (!set.contains(word.substring(0, idx))) {
						isLongestWord = false;
						break;
					}
				}
				if (isLongestWord) {
					result = word;
				}
			}
		}
		return result;
	}

}
