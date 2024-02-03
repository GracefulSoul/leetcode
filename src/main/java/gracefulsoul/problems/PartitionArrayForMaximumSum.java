package gracefulsoul.problems;

public class PartitionArrayForMaximumSum {

	// https://leetcode.com/problems/partition-array-for-maximum-sum/submissions/1164349496/
	public static void main(String[] args) {
		PartitionArrayForMaximumSum test = new PartitionArrayForMaximumSum();
		System.out.println(test.maxSumAfterPartitioning(new int[] { 1, 15, 7, 9, 2, 5, 10 }, 3));
		System.out.println(test.maxSumAfterPartitioning(new int[] { 1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3 }, 4));
		System.out.println(test.maxSumAfterPartitioning(new int[] { 1 }, 1));
	}

	public int maxSumAfterPartitioning(int[] arr, int k) {
		int length = arr.length;
		int[] dp = new int[length + 1];
		for (int i = 1; i <= length; i++) {
			int max = 0;
			int sum = 0;
			for (int j = 1; j <= k && i - j >= 0; j++) {
				max = Math.max(max, arr[i - j]);
				sum = Math.max(sum, (max * j) + dp[i - j]);
			}
			dp[i] = sum;
		}
		return dp[length];
	}

}
