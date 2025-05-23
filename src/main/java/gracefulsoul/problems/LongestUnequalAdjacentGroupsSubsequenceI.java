package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class LongestUnequalAdjacentGroupsSubsequenceI {

	// https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/submissions/1642128624/
	public static void main(String[] args) {
		LongestUnequalAdjacentGroupsSubsequenceI test = new LongestUnequalAdjacentGroupsSubsequenceI();
		System.out.println(test.getLongestSubsequence(new String[] { "e", "a", "b" }, new int[] { 0, 0, 1 }));
		System.out.println(test.getLongestSubsequence(new String[] { "a", "b", "c", "d" }, new int[] { 1, 0, 1, 1 }));
	}

	public List<String> getLongestSubsequence(String[] words, int[] groups) {
		List<String> result = new ArrayList<>();
		result.add(words[0]);
		for (int i = 1; i < words.length; i++) {
			if (groups[i - 1] != groups[i]) {
				result.add(words[i]);
			}
		}
		return result;
	}

}
