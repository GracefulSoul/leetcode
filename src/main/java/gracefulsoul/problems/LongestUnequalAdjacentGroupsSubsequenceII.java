package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceII {

	// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-ii/submissions/1635166392/
	public static void main(String[] args) {
		LongestUnequalAdjacentGroupsSubsequenceII test = new LongestUnequalAdjacentGroupsSubsequenceII();
		System.out.println(test.getWordsInLongestSubsequence(new String[] { "bab", "dab", "cab" }, new int[] { 1, 2, 2 }));
		System.out.println(test.getWordsInLongestSubsequence(new String[] { "a", "b", "c", "d" }, new int[] { 1, 2, 3, 4 }));
	}

	public boolean differByOneChar(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}
		int count = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				count++;
			}
		}
		return count == 1;
	}

	public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
		int length = groups.length;
		int[] dp = new int[length];
		int[] parent = new int[length];
		Arrays.fill(dp, 1);
		Arrays.fill(parent, -1);
		int max = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < i; j++) {
				if (groups[i] != groups[j] && differByOneChar(words[i], words[j]) && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
					parent[i] = j;
				}
			}
			if (dp[i] > max) {
				max = dp[i];
			}
		}
		List<String> result = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			if (dp[i] == max) {
				while (i != -1) {
					result.add(words[i]);
					i = parent[i];
				}
				break;
			}
		}
		Collections.reverse(result);
		return result;
	}

}
