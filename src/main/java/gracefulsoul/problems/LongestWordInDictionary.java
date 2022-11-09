package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

	// https://leetcode.com/submissions/detail/840020420/
	public static void main(String[] args) {
		LongestWordInDictionary test = new LongestWordInDictionary();
		System.out.println(test.longestWord(new String[] { "w", "wo", "wor", "worl", "world" }));
		System.out.println(test.longestWord(new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" }));
	}

	public String longestWord(String[] words) {
		Arrays.sort(words);
		Set<String> set = new HashSet<String>();
		String result = "";
		for (String word : words) {
			int length = word.length();
			if (length == 1 || set.contains(word.substring(0, length - 1))) {
				if (length > result.length()) {
					result = word;
				}
				set.add(word);
			}
		}
		return result;
	}

}
