package gracefulsoul.problems;

public class MaximizeScoreAfterNOperations {

	// https://leetcode.com/problems/maximize-score-after-n-operations/submissions/950006270/
	public static void main(String[] args) {
		MaximizeScoreAfterNOperations test = new MaximizeScoreAfterNOperations();
		System.out.println(test.maxScore(new int[] { 1, 2 }));
		System.out.println(test.maxScore(new int[] { 3, 4, 6, 8 }));
		System.out.println(test.maxScore(new int[] { 1, 2, 3, 4, 5, 6 }));
	}

	public int maxScore(int[] nums) {
		int length = nums.length;
		int[][] gcd = new int[length][length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				gcd[i][j] = this.getGcd(nums[i], nums[j]);
			}
		}
		int[] dp = new int[1 << length];
		for (int i = 0; i < (1 << length); i++) {
			int bits = Integer.bitCount(i);
			if (bits % 2 != 0) {
				continue;
			}
			for (int j = 0; j < length; j++) {
				int jBit = 1 << j;
				if ((i & jBit) > 0) {
					continue;
				}
				for (int k = j + 1; k < length; k++) {
					int kBit = 1 << k;
					if ((i & kBit) > 0) {
						continue;
					}
					dp[i | jBit | kBit] = Math.max(dp[i] + gcd[j][k] * ((bits / 2) + 1), dp[i | jBit | kBit]);
				}
			}
		}
		return dp[(1 << length) - 1];
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
