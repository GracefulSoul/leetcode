package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {

	// https://leetcode.com/problems/longest-string-chain/submissions/1056834832/
	public static void main(String[] args) {
		LongestStringChain test = new LongestStringChain();
		System.out.println(test.longestStrChain(new String[] { "a", "b", "ba", "bca", "bda", "bdca" }));
		System.out.println(test.longestStrChain(new String[] { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" }));
		System.out.println(test.longestStrChain(new String[] { "abcd", "dbqca" }));
	}

	public int longestStrChain(String[] words) {
		Map<String, Integer> map = new HashMap<>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		int result = 0;
		for (String word : words) {
			int max = 0;
			for (int i = 0; i < word.length(); i++) {
				max = Math.max(max, map.getOrDefault(word.substring(0, i) + word.substring(i + 1), 0) + 1);
			}
			map.put(word, max);
			result = Math.max(result, max);
		}
		return result;
	}

}
