package gracefulsoul.problems;

public class CountNumberOfBalancedPermutations {

	// https://leetcode.com/problems/count-number-of-balanced-permutations/submissions/1629197046/
	public static void main(String[] args) {
		CountNumberOfBalancedPermutations test = new CountNumberOfBalancedPermutations();
		System.out.println(test.countBalancedPermutations("123"));
		System.out.println(test.countBalancedPermutations("112"));
		System.out.println(test.countBalancedPermutations("12345"));
	}

	private static final int MOD = 1000000007;

	public int countBalancedPermutations(String num) {
		int sum = 0;
		for (char c : num.toCharArray()) {
			sum += c - '0';
		}
		if ((sum & 1) == 1) {
			return 0;
		}
		int length = num.length();
		long[] factorials = new long[length + 1];
		long[] inverseFactorials = new long[length + 1];
		this.precompute(length, factorials, new long[length + 1], inverseFactorials);
		int halfSum = sum / 2;
		int halfLength = length / 2;
		int[][] dp = new int[halfSum + 1][halfLength + 1];
		dp[0][0] = 1;
		int[] digits = new int[10];
		for (char c : num.toCharArray()) {
			int n = c - '0';
			digits[n]++;
			for (int i = halfSum; i >= n; i--) {
				for (int j = halfLength; j > 0; j--) {
					dp[i][j] = (dp[i][j] + dp[i - n][j - 1]) % MOD;
				}
			}
		}
		long result = dp[halfSum][halfLength];
		result = result * factorials[halfLength] % MOD * factorials[length - halfLength] % MOD;
		for (int digit : digits) {
			result = result * inverseFactorials[digit] % MOD;
		}
		return (int) result;
	}

	private void precompute(int length, long[] factorials, long[] inverses, long[] inverseFactorials) {
		factorials[0] = inverses[0] = inverseFactorials[0] = 1;
		for (int i = 1; i <= length; i++) {
			factorials[i] = (factorials[i - 1] * i) % MOD;
		}
		inverses[1] = 1;
		for (int i = 2; i <= length; i++) {
			inverses[i] = MOD - ((MOD / i) * inverses[MOD % i]) % MOD;
		}
		for (int i = 1; i <= length; i++) {
			inverseFactorials[i] = (inverseFactorials[i - 1] * inverses[i]) % MOD;
		}
	}

}
