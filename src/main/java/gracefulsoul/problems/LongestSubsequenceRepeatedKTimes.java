package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestSubsequenceRepeatedKTimes {

	// https://leetcode.com/problems/longest-subsequence-repeated-k-times/submissions/1678160314/
	public static void main(String[] args) {
		LongestSubsequenceRepeatedKTimes test = new LongestSubsequenceRepeatedKTimes();
		System.out.println(test.longestSubsequenceRepeatedK("letsleetcode", 2));
		System.out.println(test.longestSubsequenceRepeatedK("bb", 2));
		System.out.println(test.longestSubsequenceRepeatedK("ab", 2));
	}

	public String longestSubsequenceRepeatedK(String s, int k) {
		String result = "";
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		List<Character> list = new ArrayList<>();
		for (char c = 'a'; c <= 'z'; c++) {
			if (count[c - 'a'] >= k) {
				list.add(c);
			}
		}
		Queue<String> queue = new LinkedList<>();
		queue.add("");
		while (!queue.isEmpty()) {
			String curr = queue.poll();
			if (curr.length() * k > s.length()) {
				return result;
			}
			for (char c : list) {
				String temp = curr + c;
				if (this.isRepeatedK(s, k, temp)) {
					queue.offer(temp);
					result = temp;
				}
			}
		}
		return result;
	}

	private boolean isRepeatedK(String s, int k, String t) {
		int i = 0;
		for (char c : s.toCharArray()) {
			if (c == t.charAt(i) && ++i == t.length()) {
				if (--k == 0) {
					return true;
				}
				i = 0;
			}
		}
		return false;
	}

}
