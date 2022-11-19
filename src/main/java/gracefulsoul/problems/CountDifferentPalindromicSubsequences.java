package gracefulsoul.problems;

public class CountDifferentPalindromicSubsequences {

	// https://leetcode.com/submissions/detail/846101174/
	public static void main(String[] args) {
		CountDifferentPalindromicSubsequences test = new CountDifferentPalindromicSubsequences();
		System.out.println(test.countPalindromicSubsequences("bccb"));
		System.out.println(test.countPalindromicSubsequences("abcdabcdabcdabcdabcdabcdabcdabcddcbadcbadcbadcbadcbadcbadcbadcba"));
	}

	public int countPalindromicSubsequences(String s) {
		int length = s.length();
		int[] dp = new int[length];
		int[] same = new int[length];
		char[] charArray = s.toCharArray();
		for (int i = 0; i < length; i++) {
			dp[i] = 1;
			same[i] = -1;
			int previous = 0;
			int end = 1;
			for (int j = i - 1; j >= 0; j--) {
				if (charArray[j] == charArray[i]) {
					end = (previous - same[j]) % 1000000007;
					same[j] = previous;
				}
				previous = dp[j];
				dp[j] = (previous + end) % 1000000007;
			}
		}
		return (dp[0] + 1000000007) % 1000000007;
	}

}
