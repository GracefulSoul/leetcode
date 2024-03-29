package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumScoreTriangulationOfPolygon {

	// https://leetcode.com/problems/minimum-score-triangulation-of-polygon/submissions/1196611636/
	public static void main(String[] args) {
		MinimumScoreTriangulationOfPolygon test = new MinimumScoreTriangulationOfPolygon();
		System.out.println(test.minScoreTriangulation(new int[] { 1, 2, 3 }));
		System.out.println(test.minScoreTriangulation(new int[] { 3, 7, 4, 5 }));
		System.out.println(test.minScoreTriangulation(new int[] { 1, 3, 1, 4, 1, 5 }));
	}

	public int minScoreTriangulation(int[] values) {
		int length = values.length;
		int[][] dp = new int[length][length];
		for (int[] row : dp) {
			Arrays.fill(row, -1);
		}
		return this.dfs(values, dp, 1, length - 1);
	}

	private int dfs(int[] values, int[][] dp, int i, int j) {
		if (i >= j) {
			return 0;
		} else if (dp[i][j] != -1) {
			return dp[i][j];
		} else {
			int min = Integer.MAX_VALUE;
			for (int k = i; k < j; k++) {
				min = Math.min(min, this.dfs(values, dp, i, k) + this.dfs(values, dp, k + 1, j) + values[i - 1] * values[k] * values[j]);
			}
			return dp[i][j] = min;
		}
	}

}
