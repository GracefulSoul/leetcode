package gracefulsoul.problems;

public class TotalCharactersInStringAfterTransformationsI {

	// https://leetcode.com/problems/total-characters-in-string-after-transformations-i/submissions/1632696192/
	public static void main(String[] args) {
		TotalCharactersInStringAfterTransformationsI test = new TotalCharactersInStringAfterTransformationsI();
		System.out.println(test.lengthAfterTransformations("abcyy", 2));
		System.out.println(test.lengthAfterTransformations("azbk", 1));
	}

	private static final int MOD = 1000000007;

	public int lengthAfterTransformations(String s, int t) {
		int[] dp = new int[t + 26];
		for (int i = 0; i < 26; i++) {
			dp[i] = 1;
		}
		for (int i = 26; i < t + 26; i++) {
			dp[i] = (dp[i - 25] + dp[i - 26]) % MOD;
		}
		int result = 0;
		for (char c : s.toCharArray()) {
			result = (result + dp[c - 'a' + t]) % MOD;
		}
		return result;
	}

}
