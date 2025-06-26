package gracefulsoul.problems;

public class LongestBinarySubsequenceLessThanOrEqualToK {

	// https://leetcode.com/problems/longest-binary-subsequence-less-than-or-equal-to-k/submissions/1676985919/
	public static void main(String[] args) {
		LongestBinarySubsequenceLessThanOrEqualToK test = new LongestBinarySubsequenceLessThanOrEqualToK();
		System.out.println(test.longestSubsequence("1001010", 5));
		System.out.println(test.longestSubsequence("00101001", 1));
	}

	public int longestSubsequence(String s, int k) {
		char[] charArray = s.toCharArray();
		int result = 0;
		int cost = 1;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (charArray[i] == '0' || cost <= k) {
				k -= cost * (charArray[i] - '0');
				result++;
			}
			if (cost <= k) {
				cost *= 2;
			}
		}
		return result;
	}

}
