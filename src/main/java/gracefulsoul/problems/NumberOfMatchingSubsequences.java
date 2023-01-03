package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class NumberOfMatchingSubsequences {

	// https://leetcode.com/problems/number-of-matching-subsequences/submissions/870372348/
	public static void main(String[] args) {
		NumberOfMatchingSubsequences test = new NumberOfMatchingSubsequences();
		System.out.println(test.numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));
		System.out.println(test.numMatchingSubseq("dsahjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" }));
	}

	public int numMatchingSubseq(String s, String[] words) {
		Map<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		int count = 0;
		char[] sCharArray = s.toCharArray();
		for (String word : map.keySet()) {
			char[] wordCharArray = word.toCharArray();
			int i = 0;
			int j = 0;
			while (i < sCharArray.length && j < wordCharArray.length) {
				if (sCharArray[i] == wordCharArray[j]) {
					j++;
				}
				i++;
			}
			if (j == wordCharArray.length) {
				count += map.get(word);
			}
		}
		return count;
	}

}
