package gracefulsoul.problems;

import java.util.Arrays;

public class RotateImage {

	// https://leetcode.com/submissions/detail/500297400/
	public static void main(String[] args) {
		RotateImage test = new RotateImage();
		int[][] matrix1 = new int[][] {
			new int[] { 1, 2, 3 },
			new int[] { 4, 5, 6 },
			new int[] { 7, 8, 9 }
		};
		test.rotate(matrix1);
		print(matrix1);
		int[][] matrix2 = new int[][] {
			new int[] { 5, 1, 9, 11 },
			new int[] { 2, 4, 8, 10 },
			new int[] { 13, 3, 6, 7 },
			new int[] { 15, 14, 12, 16 }
		};
		test.rotate(matrix2);
		print(matrix2);
	}

	public void rotate(int[][] matrix) {
		boolean[][] fixed = new boolean[matrix.length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (!fixed[i][j]) {
					int temp = matrix[i][j];
					matrix[i][j] = matrix[j][matrix.length - 1 - i];
					matrix[j][matrix.length - 1 - i] = temp;
					fixed[j][matrix.length - 1 - i] = true;
				}
			}
		}
	}

	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

}
