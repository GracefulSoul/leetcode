package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortEncodingOfWords {

	// https://leetcode.com/problems/short-encoding-of-words/submissions/886557992/
	public static void main(String[] args) {
		ShortEncodingOfWords test = new ShortEncodingOfWords();
		System.out.println(test.minimumLengthEncoding(new String[] { "time", "me", "bell" }));
		System.out.println(test.minimumLengthEncoding(new String[] { "t" }));
	}

	public int minimumLengthEncoding(String[] words) {
		Set<String> set = new HashSet<>(Arrays.asList(words));
		for (String word : words) {
			for (int idx = 1; idx < word.length(); idx++) {
				set.remove(word.substring(idx));
			}
		}
		int result = 0;
		for (String word : set) {
			result += word.length() + 1;
		}
		return result;
	}

}
