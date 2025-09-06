package gracefulsoul.problems;

public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {

	// https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/submissions/1761216908/
	public static void main(String[] args) {
		MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold test = new MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold();
		System.out.println(test.maxSideLength(new int[][] {
			{ 1, 1, 3, 2, 4, 3, 2 },
			{ 1, 1, 3, 2, 4, 3, 2 },
			{ 1, 1, 3, 2, 4, 3, 2 }
		}, 4));
		System.out.println(test.maxSideLength(new int[][] {
			{ 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 2 }
		}, 1));
	}

	public int maxSideLength(int[][] mat, int threshold) {
		int rows = mat.length;
		int cols = mat[0].length;
		int[][] dp = new int[rows + 1][cols + 1];
		int result = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dp[i + 1][j + 1] = dp[i + 1][j] + dp[i][j + 1] - dp[i][j] + mat[i][j];
				if (result <= i && result <= j
						&& dp[i + 1][j + 1] - dp[i - result][j + 1] - dp[i + 1][j - result] + dp[i - result][j - result] <= threshold) {
					result++;
				}
			}
		}
		return result;
	}

}
