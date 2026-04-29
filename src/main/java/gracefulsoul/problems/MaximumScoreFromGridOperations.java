package gracefulsoul.problems;

public class MaximumScoreFromGridOperations {

	// https://leetcode.com/problems/maximum-score-from-grid-operations/submissions/1990936281/
	public static void main(String[] args) {
		MaximumScoreFromGridOperations test = new MaximumScoreFromGridOperations();
		System.out.println(test.maximumScore(new int[][] {
			{ 0, 0, 0, 0, 0 },
			{ 0, 0, 3, 0, 0 },
			{ 0, 1, 0, 0, 0 },
			{ 5, 0, 0, 3, 0 },
			{ 0, 0, 0, 0, 2 }
		}));
		System.out.println(test.maximumScore(new int[][] {
			{ 10, 9, 0, 0, 15 },
			{ 7, 1, 0, 8, 0 },
			{ 5, 20, 0, 11, 0 },
			{ 0, 0, 0, 1, 2 },
			{ 8, 12, 1, 10, 3 }
		}));
	}

	public long maximumScore(int[][] grid) {
		int length = grid.length;
		if (length == 1) {
			return 0;
		}
		long[][] dp = new long[2][length + 1];
		for (int j = 1; j < length; j++) {
			long[][] temp = new long[2][length + 1];
			for (int i = 0; i <= length; i++) {
				long prev = 0;
				long curr = 0;
				for (int x = 0; x < i; x++) {
					curr += grid[x][j];
				}
				for (int y = 0; y <= length; y++) {
					if (y > 0 && y <= i) {
						curr -= grid[y - 1][j];
					}
					if (y > i) {
						prev += grid[y - 1][j - 1];
					}
					temp[0][y] = Math.max(temp[0][y], Math.max(prev + dp[0][i], dp[1][i]));
					temp[1][y] = Math.max(temp[1][y], Math.max(curr + dp[1][i], curr + prev + dp[0][i]));
				}
			}
			dp = temp;
		}
		long result = 0;
		for (long num : dp[1]) {
			result = Math.max(result, num);
		}
		return result;
	}

}
