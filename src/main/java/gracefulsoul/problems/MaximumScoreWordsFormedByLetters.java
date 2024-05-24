package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumScoreWordsFormedByLetters {

	// https://leetcode.com/problems/maximum-score-words-formed-by-letters/submissions/1266711380/
	public static void main(String[] args) {
		MaximumScoreWordsFormedByLetters test = new MaximumScoreWordsFormedByLetters();
		System.out.println(test.maxScoreWords(new String[] { "dog", "cat", "dad", "good" },
				new char[] { 'a', 'a', 'c', 'd', 'd', 'd', 'g', 'o', 'o' },
				new int[] { 1, 0, 9, 5, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }));
		System.out.println(test.maxScoreWords(new String[] { "xxxz", "ax", "bx", "cx" },
				new char[] { 'z', 'a', 'b', 'c', 'x', 'x', 'x' },
				new int[] { 4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10 }));
	}

	public int maxScoreWords(String[] words, char[] letters, int[] score) {
		int[] counts = new int[26];
		for (char letter : letters) {
			counts[letter - 'a']++;
		}
		return this.dfs(words, score, counts, 0);
	}

	private int dfs(String[] words, int[] score, int[] counts, int index) {
		if (index == words.length) {
			return 0;
		}
		String word = words[index];
		int count = 0;
		int[] temp = Arrays.copyOf(counts, counts.length);
		int i = 0;
		for (; i < word.length(); i++) {
			int num = word.charAt(i) - 'a';
			if (temp[num] > 0) {
				temp[num]--;
				count += score[num];
			} else {
				break;
			}
		}
		int result = 0;
		if (i == word.length()) {
			result = Math.max(result, count + this.dfs(words, score, temp, index + 1));
		}
		return Math.max(result, this.dfs(words, score, counts, index + 1));
	}

}
