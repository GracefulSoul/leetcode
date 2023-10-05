package gracefulsoul.problems;

public class MinimumCostToMergeStones {

	// https://leetcode.com/problems/minimum-cost-to-merge-stones/submissions/1067658174/
	public static void main(String[] args) {
		MinimumCostToMergeStones test = new MinimumCostToMergeStones();
		System.out.println(test.mergeStones(new int[] { 3, 2, 4, 1 }, 2));
		System.out.println(test.mergeStones(new int[] { 3, 2, 4, 1 }, 3));
		System.out.println(test.mergeStones(new int[] { 3, 5, 1, 2, 6 }, 3));
	}

	public int mergeStones(int[] stones, int k) {
		int length = stones.length;
		if ((length - 1) % (k - 1) > 0) {
			return -1;
		}
		int[] sum = new int[length + 1];
		for (int i = 0; i < length; i++) {
			sum[i + 1] = sum[i] + stones[i];
		}
		int[][] dp = new int[length][length];
		for (int end = k; end <= length; end++) {
			for (int start = 0; start + end <= length; start++) {
				int max = start + end - 1;
				dp[start][max] = Integer.MAX_VALUE;
				for (int mid = start; mid < max; mid += k - 1) {
					dp[start][max] = Math.min(dp[start][max], dp[start][mid] + dp[mid + 1][max]);
				}
				if ((max - start) % (k - 1) == 0) {
					dp[start][max] += sum[max + 1] - sum[start];
				}
			}
		}
		return dp[0][length - 1];
	}

}
