package gracefulsoul.problems;

import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {

	// https://leetcode.com/problems/largest-submatrix-with-rearrangements/submissions/1950994278/
	public static void main(String[] args) {
		LargestSubmatrixWithRearrangements test = new LargestSubmatrixWithRearrangements();
		System.out.println(test.largestSubmatrix(new int[][] {
			{ 0, 0, 1 },
			{ 1, 1, 1 },
			{ 1, 0, 1 }
		}));
		System.out.println(test.largestSubmatrix(new int[][] {
			{ 1, 0, 1, 0, 1 }
		}));
		System.out.println(test.largestSubmatrix(new int[][] {
			{ 1, 1, 0 },
			{ 1, 0, 1 }
		}));
	}

	public int largestSubmatrix(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					matrix[i][j] = matrix[i - 1][j] + 1;
				}
			}
		}
		int result = 0;
		for (int i = 0; i < rows; i++) {
			Arrays.sort(matrix[i]);
			for (int j = 1; j <= cols; j++) {
				result = Math.max(result, j * matrix[i][cols - j]);
			}
		}
		return result;
	}

}
