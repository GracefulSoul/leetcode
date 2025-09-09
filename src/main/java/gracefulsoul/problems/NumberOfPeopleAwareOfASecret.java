package gracefulsoul.problems;

public class NumberOfPeopleAwareOfASecret {

	// https://leetcode.com/problems/number-of-people-aware-of-a-secret/submissions/1764883085/
	public static void main(String[] args) {
		NumberOfPeopleAwareOfASecret test = new NumberOfPeopleAwareOfASecret();
		System.out.println(test.peopleAwareOfSecret(6, 2, 4));
		System.out.println(test.peopleAwareOfSecret(4, 1, 3));
	}

	private static final long MOD = (long) 1e9 + 7;

	public int peopleAwareOfSecret(int n, int delay, int forget) {
		long[] dp = new long[n + 1];
		dp[1] = 1;
		long share = 0;
		long result = 0;
		for (int i = 2; i <= n; i++) {
			dp[i] = share = (share + dp[Math.max(i - delay, 0)] - dp[Math.max(i - forget, 0)] + MOD) % MOD;
		}
		for (int i = n - forget + 1; i <= n; i++) {
			result = (result + dp[i]) % MOD;
		}
		return (int) result;
	}

}
