package gracefulsoul.problems;

public class LargestSubstringBetweenTwoEqualCharacters {

	// https://leetcode.com/problems/largest-substring-between-two-equal-characters/submissions/1132603544/
	public static void main(String[] args) {
		LargestSubstringBetweenTwoEqualCharacters test = new LargestSubstringBetweenTwoEqualCharacters();
		System.out.println(test.maxLengthBetweenEqualCharacters("aa"));
		System.out.println(test.maxLengthBetweenEqualCharacters("abca"));
		System.out.println(test.maxLengthBetweenEqualCharacters("cbzxy"));
	}

	public int maxLengthBetweenEqualCharacters(String s) {
		int[] dp = new int[26];
		int max = -1;
		for (int i = 0; i < s.length(); i++) {
			int index = s.charAt(i) - 97;
			if (dp[index] == 0) {
				dp[index] = i + 1;
			} else {
				max = Integer.max(max, i - dp[index]);
			}
		}
		return max;
	}

}
