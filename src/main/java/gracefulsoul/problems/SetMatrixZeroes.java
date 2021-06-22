package gracefulsoul.problems;

import java.util.Arrays;

public class SetMatrixZeroes {

	// https://leetcode.com/submissions/detail/511399634/
	public static void main(String[] args) {
		SetMatrixZeroes test = new SetMatrixZeroes();
		int[][] matrix1 = new int[][] {
			new int[] { 1, 1, 1 },
			new int[] { 1, 0, 1 },
			new int[] { 1, 1, 1 }
		};
		test.setZeroes(matrix1);
		print(matrix1);
		int[][] matrix2 = new int[][] {
			new int[] { 0, 1, 2, 0 },
			new int[] { 3, 4, 5, 2 },
			new int[] { 1, 3, 1, 5 }
		}; 
		test.setZeroes(matrix2);
		print(matrix2);
	}

	public void setZeroes(int[][] matrix) {
		this.setZeroesDownTop(matrix, this.setZeroesTopDown(matrix));
	}

	private boolean setZeroesTopDown(int[][] matrix) {
		boolean isFirstColumnZero = false;
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				isFirstColumnZero = true;
			}
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = matrix[0][j] = 0;
				}
			}
		}
		return isFirstColumnZero;
	}

	private void setZeroesDownTop(int[][] matrix, boolean isFirstColumnZero) {
		for (int i = matrix.length - 1; i >= 0; i--) {
			for (int j = matrix[0].length - 1; j >= 1; j--) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
			if (isFirstColumnZero) {
				matrix[i][0] = 0;
			}
		}
	}

	private static void print(int[][] matrix) {
		for (int[] row : matrix) {
			System.out.println(Arrays.toString(row));
		}
	}

}
