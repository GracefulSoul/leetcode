package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class MaximumNumberOfOccurrencesOfASubstring {

	// https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/submissions/1876421893/
	public static void main(String[] args) {
		MaximumNumberOfOccurrencesOfASubstring test = new MaximumNumberOfOccurrencesOfASubstring();
		System.out.println(test.maxFreq("aababcaab", 2, 3, 4));
		System.out.println(test.maxFreq("aaaa", 1, 3, 3));
	}

	public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
		char[] charArray = s.toCharArray();
		Map<String, Integer> map = new HashMap<>();
		int[] counts = new int[26];
		int result = 0;
		for (int i = 0, j = 0; j < charArray.length;) {
			if (++counts[charArray[j++] - 'a'] == 1) {
				maxLetters--;
			}
			while (maxLetters < 0 || j - i > minSize) {
				if (--counts[charArray[i++] - 'a'] == 0) {
					maxLetters++;
				}
			}
			if (j - i == minSize) {
				result = Math.max(result, map.merge(s.substring(i, j), 1, Integer::sum));
			}
		}
		return result;
	}

}
