package gracefulsoul.problems;

public class BurstBalloons {

	// https://leetcode.com/submissions/detail/605377106/
	public static void main(String[] args) {
		BurstBalloons test = new BurstBalloons();
		System.out.println(test.maxCoins(new int[] { 3, 1, 5, 8 }));
		System.out.println(test.maxCoins(new int[] { 1, 5 }));

	}

	public int maxCoins(int[] nums) {
		int length = nums.length;
		int[] numbers = new int[length + 2];
		numbers[0] = 1;
		numbers[length + 1] = 1;
		for (int idx = 0; idx < length; idx++) {
			numbers[idx + 1] = nums[idx];
		}
		int[][] dp = new int[length + 2][length + 2];
		for (int j = 2; j < numbers.length; j++) {
			for (int i = j - 1; i > 0; i--) {
				int max = 0;
				for (int k = i; k < j; k++) {
					max = Math.max(max, dp[i][k] + dp[k + 1][j] + (numbers[i - 1] * numbers[k] * numbers[j]));
				}
				dp[i][j] = max;
			}
		}
		return dp[1][length + 1];
	}

}
