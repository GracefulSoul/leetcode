package gracefulsoul.problems;

import java.util.Arrays;

public class FlipColumnsForMaximumNumberOfEqualRows {

	// https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/submissions/1221966298/
	public static void main(String[] args) {
		FlipColumnsForMaximumNumberOfEqualRows test = new FlipColumnsForMaximumNumberOfEqualRows();
		System.out.println(test.maxEqualRowsAfterFlips(new int[][] {
			{ 0, 1 },
			{ 1, 1 }
		}));
		System.out.println(test.maxEqualRowsAfterFlips(new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}));
		System.out.println(test.maxEqualRowsAfterFlips(new int[][] {
			{ 0, 0, 0 },
			{ 0, 0, 1 },
			{ 1, 1, 0 }
		}));
	}

	public int maxEqualRowsAfterFlips(int[][] matrix) {
		int result = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		int[] temp = new int[col];
		for (int i = 0; i < row; i++) {
			int count = 0;
			for (int j = 0; j < col; j++) {
				temp[j] = 1 - matrix[i][j];
			}
			for (int k = i; k < row; k++) {
				if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], temp)) {
					count++;
				}
			}
			result = Math.max(result, count);
		}
		return result;
	}

}
