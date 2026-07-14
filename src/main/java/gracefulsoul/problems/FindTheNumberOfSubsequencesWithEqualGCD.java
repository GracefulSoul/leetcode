package gracefulsoul.problems;

public class FindTheNumberOfSubsequencesWithEqualGCD {

	// https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/submissions/2067256985/
	public static void main(String[] args) {
		FindTheNumberOfSubsequencesWithEqualGCD test = new FindTheNumberOfSubsequencesWithEqualGCD();
		System.out.println(test.subsequencePairCount(new int[] { 1, 2, 3, 4 }));
		System.out.println(test.subsequencePairCount(new int[] { 10, 20, 30 }));
		System.out.println(test.subsequencePairCount(new int[] { 1, 1, 1, 1 }));
	}

	private static final int MOD = 1000000007;

	public int subsequencePairCount(int[] nums) {
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		int[][] dp = new int[max + 1][max + 1];
		dp[0][0] = 1;
		for (int num : nums) {
			int[][] ndp = new int[max + 1][max + 1];
			for (int i = 0; i <= max; i++) {
				int ni = this.gcd(i, num);
				for (int j = 0; j <= max; j++) {
					if (dp[i][j] == 0) {
						continue;
					}
					int dj = this.gcd(j, num);
					ndp[i][j] = (ndp[i][j] + dp[i][j]) % MOD;
					ndp[ni][j] = (ndp[ni][j] + dp[i][j]) % MOD;
					ndp[i][dj] = (ndp[i][dj] + dp[i][j]) % MOD;
				}
			}
			dp = ndp;
		}
		int result = 0;
		for (int i = 1; i <= max; i++) {
			result = (result + dp[i][i]) % MOD;
		}
		return result;
	}

	private int gcd(int a, int b) {
		return b > 0 ? this.gcd(b, a % b) : a;
	}

}
