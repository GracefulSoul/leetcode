package gracefulsoul.problems;

public class LargestSumOfAverages {

	// https://leetcode.com/problems/largest-sum-of-averages/submissions/883589773/
	public static void main(String[] args) {
		LargestSumOfAverages test = new LargestSumOfAverages();
		System.out.println(test.largestSumOfAverages(new int[] { 9, 1, 2, 3, 9 }, 3));
		System.out.println(test.largestSumOfAverages(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 4));
	}

	public double largestSumOfAverages(int[] nums, int k) {
		int length = nums.length;
		double[][] dp = new double[length][k + 1];
		double sum = 0;
		for (int idx = length - 1; idx >= 0; idx--) {
			sum += nums[idx];
			dp[idx][1] = sum / (length - idx);
		}
		return this.getCount(nums, length, dp, 0, k);
	}

	private double getCount(int[] nums, int length, double[][] dp, int start, int k) {
		if (dp[start][k] == 0) {
			double sum = 0;
			for (int idx = start; idx < length; idx++) {
				if (length - idx < k) {
					break;
				}
				sum += nums[idx];
				dp[start][k] = Math.max((sum / (idx + 1 - start)) + this.getCount(nums, length, dp, idx + 1, k - 1), dp[start][k]);
			}
		}
		return dp[start][k];
	}

}
