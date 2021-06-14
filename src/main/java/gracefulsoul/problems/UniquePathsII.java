package gracefulsoul.problems;

public class UniquePathsII {

	// https://leetcode.com/submissions/detail/507663085/
	public static void main(String[] args) {
		UniquePathsII test = new UniquePathsII();
		System.out.println(test.uniquePathsWithObstacles(new int[][] {
			new int[] { 0, 0, 0 },
			new int[] { 0, 1, 0 },
			new int[] { 0, 0, 0 }
		}));
		System.out.println(test.uniquePathsWithObstacles(new int[][] {
			new int[] { 0, 1 },
			new int[] { 0, 0 }
		}));
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int[][] dp = new int[obstacleGrid.length + 1][obstacleGrid[0].length + 1];
		dp[1][1] = obstacleGrid[0][0] != 1 ? 1 : 0;
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] += obstacleGrid[i - 1][j - 1] != 1 ? dp[i][j - 1] + dp[i - 1][j] : 0;
			}
		}
		return dp[obstacleGrid.length][obstacleGrid[0].length];
	}

}
