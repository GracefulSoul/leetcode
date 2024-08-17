package gracefulsoul.problems;

public class MaximumNumberOfPointsWithCost {

	// https://leetcode.com/problems/maximum-number-of-points-with-cost/submissions/1358369378/
	public static void main(String[] args) {
		MaximumNumberOfPointsWithCost test = new MaximumNumberOfPointsWithCost();
		System.out.println(test.maxPoints(new int[][] {
			{ 1, 2, 3 },
			{ 1, 5, 1 },
			{ 3, 1, 1 }
		}));
		System.out.println(test.maxPoints(new int[][] {
			{ 1, 5 },
			{ 2, 3 },
			{ 4, 2 }
		}));
	}

	public long maxPoints(int[][] points) {
		int row = points.length;
		int col = points[0].length;
		long[] dp = new long[col];
		long result = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dp[j] += points[i][j];
			}
			for (int j = 1; j < col; j++) {
				dp[j] = Math.max(dp[j], dp[j - 1] - 1);
			}
			for (int j = col - 2; j >= 0; j--) {
				dp[j] = Math.max(dp[j], dp[j + 1] - 1);
			}
		}
		for (int i = 0; i < col; i++) {
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
