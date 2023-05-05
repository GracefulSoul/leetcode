package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

	// https://leetcode.com/problems/word-subsets/submissions/944650789/
	public static void main(String[] args) {
		WordSubsets test = new WordSubsets();
		System.out.println(test.wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" }, new String[] { "e", "o" }));
		System.out.println(test.wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" }, new String[] { "l", "o" }));
	}

	public List<String> wordSubsets(String[] words1, String[] words2) {
		int[] charArray = new int[26];
		for (String word : words2) {
			int[] temp = new int[26];
			for (char c : word.toCharArray()) {
				int num = c - 'a';
				temp[num]++;
				if (charArray[num] < temp[num]) {
					charArray[num] = temp[num];
				}
			}
		}
		List<String> result = new ArrayList<>();
		for (String word : words1) {
			int[] temp = new int[26];
			for (char c : word.toCharArray()) {
				temp[c - 'a']++;
			}
			if (this.issubset(charArray, temp)) {
				result.add(word);
			}
		}
		return result;
	}

	private boolean issubset(int[] charArray, int[] temp) {
		for (int i = 0; i < 26; i++) {
			if (charArray[i] > temp[i]) {
				return false;
			}
		}
		return true;
	}

}
