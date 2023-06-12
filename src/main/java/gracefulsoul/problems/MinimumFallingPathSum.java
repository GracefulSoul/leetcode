package gracefulsoul.problems;

public class MinimumFallingPathSum {

	// https://leetcode.com/problems/minimum-falling-path-sum/submissions/969588545/
	public static void main(String[] args) {
		MinimumFallingPathSum test = new MinimumFallingPathSum();
		System.out.println(test.minFallingPathSum(new int[][] {
			{ 2, 1, 3 },
			{ 6, 5, 4 },
			{ 7, 8, 9 }
		}));
		System.out.println(test.minFallingPathSum(new int[][] {
			{ -19, 57 },
			{ -40, -5 }
		}));
	}

	public int minFallingPathSum(int[][] matrix) {
		return this.dfs(matrix, matrix.length - 2);
	}

	private int dfs(int[][] matrix, int index) {
		int length = matrix.length;
		if (index < 0) {
			int result = matrix[0][0];
			for (int i = 1; i < length; i++) {
				result = Math.min(result, matrix[0][i]);
			}
			return result;
		} else {
			for (int i = 0; i < length; i++) {
				int min = matrix[index + 1][i];
				if (i > 0) {
					min = Math.min(min, matrix[index + 1][i - 1]);
				}
				if (i < length - 1) {
					min = Math.min(min, matrix[index + 1][i + 1]);
				}
				matrix[index][i] += min;
			}
			return this.dfs(matrix, index - 1);
		}
	}

}
