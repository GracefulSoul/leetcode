package gracefulsoul.problems;

public class ShortestDistanceToACharacter {

	// https://leetcode.com/problems/shortest-distance-to-a-character/submissions/887107369/
	public static void main(String[] args) {
		ShortestDistanceToACharacter test = new ShortestDistanceToACharacter();
		System.out.println(test.shortestToChar("loveleetcode", 'e'));
		System.out.println(test.shortestToChar("aaab", 'b'));
	}

	public int[] shortestToChar(String s, char c) {
		int length = s.length();
		int[] result = new int[length];
		int prev = Integer.MIN_VALUE / 2;
		for (int idx = 0; idx < length; idx++) {
			if (s.charAt(idx) == c) {
				prev = idx;
			}
			result[idx] = idx - prev;
		}
		prev = Integer.MAX_VALUE / 2;
		for (int idx = length - 1; idx >= 0; idx--) {
			if (s.charAt(idx) == c) {
				prev = idx;
			}
			result[idx] = Math.min(result[idx], prev - idx);
		}
		return result;
	}

}
