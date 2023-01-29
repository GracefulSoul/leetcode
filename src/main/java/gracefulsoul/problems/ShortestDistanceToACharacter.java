package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ShortestDistanceToACharacter {

	// https://leetcode.com/problems/shortest-distance-to-a-character/submissions/887111161/
	public static void main(String[] args) {
		ShortestDistanceToACharacter test = new ShortestDistanceToACharacter();
		PrintUtil.print(test.shortestToChar("loveleetcode", 'e'));
		PrintUtil.print(test.shortestToChar("aaab", 'b'));
	}

	public int[] shortestToChar(String s, char c) {
		int length = s.length();
		int[] result = new int[length];
		int prev = -length;
		for (int idx = 0; idx < length; idx++) {
			if (s.charAt(idx) == c) {
				prev = idx;
			}
			result[idx] = idx - prev;
		}
		for (int idx = prev - 1; idx >= 0; idx--) {
			if (s.charAt(idx) == c) {
				prev = idx;
			}
			result[idx] = Math.min(result[idx], prev - idx);
		}
		return result;
	}

}
