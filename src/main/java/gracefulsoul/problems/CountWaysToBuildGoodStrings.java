package gracefulsoul.problems;

public class CountWaysToBuildGoodStrings {

	// https://leetcode.com/problems/count-ways-to-build-good-strings/submissions/949323853/
	public static void main(String[] args) {
		CountWaysToBuildGoodStrings test = new CountWaysToBuildGoodStrings();
		System.out.println(test.countGoodStrings(3, 3, 1, 1));
		System.out.println(test.countGoodStrings(2, 3, 1, 2));
	}

	public int countGoodStrings(int low, int high, int zero, int one) {
		int result = 0;
		int mod = 1000000007;
		int dp[] = new int[high + 1];
		dp[0] = 1;
		for (int i = 1; i <= high; i++) {
			if (i >= zero) {
				dp[i] = (dp[i] + dp[i - zero]) % mod;
			}
			if (i >= one) {
				dp[i] = (dp[i] + dp[i - one]) % mod;
			}
			if (i >= low) {
				result = (result + dp[i]) % mod;
			}
		}
		return result;
	}

}
