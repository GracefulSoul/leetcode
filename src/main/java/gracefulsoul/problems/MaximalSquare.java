package gracefulsoul.problems;

public class MaximalSquare {

	// https://leetcode.com/submissions/detail/577742027/
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
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] == '1') {
					dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
					max = Math.max(max, dp[i + 1][j + 1]);
				}
			}
		}
		return max * max;
	}

}
