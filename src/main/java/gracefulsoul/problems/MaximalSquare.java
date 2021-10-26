package gracefulsoul.problems;

public class MaximalSquare {

	// https://leetcode.com/submissions/detail/577730709/
	public static void main(String[] args) {
		MaximalSquare test = new MaximalSquare();
		System.out.println(test.maximalSquare(new char[][] {
			new char[] { '1', '0', '1', '0', '0' },
			new char[] { '1', '0', '1', '1', '1' },
			new char[] { '1', '1', '1', '1', '1' },
			new char[] { '1', '0', '0', '1', '0' }
		}));
		System.out.println(test.maximalSquare(new char[][] {
			new char[] { '0', '1' },
			new char[] { '1', '0' }
		}));
	}

	public int maximalSquare(char[][] matrix) {
		int max = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] dp = new int[row + 1][col + 1];
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= col; j++) {
				if (matrix[i - 1][j - 1] == '1') {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		return max * max;
	}

}
