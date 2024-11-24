package gracefulsoul.problems;

public class MaximumMatrixSum {

	// https://leetcode.com/problems/maximum-matrix-sum/submissions/1461212166/
	public static void main(String[] args) {
		MaximumMatrixSum test = new MaximumMatrixSum();
		System.out.println(test.maxMatrixSum(new int[][] {
			{ 1, -1 },
			{ -1, 1 }
		}));
		System.out.println(test.maxMatrixSum(new int[][] {
			{ 1, 2, 3 },
			{ -1, -2, -3 },
			{ 1, 2, 3 }
		}));
	}

	public long maxMatrixSum(int[][] matrix) {
		int row = matrix.length;
		int col = matrix[0].length;
		long result = 0;
		long negative = 0;
		long min = Long.MAX_VALUE;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] < 0) {
					negative++;
				}
				int absolute = Math.abs(matrix[i][j]);
				result += absolute;
				min = Math.min(min, absolute);
			}
		}
		if (negative % 2 == 0) {
			return result;
		} else {
			return result - (2 * min);
		}
	}

}
