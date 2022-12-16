package gracefulsoul.problems;

public class ToeplitzMatrix {

	// https://leetcode.com/problems/toeplitz-matrix/submissions/860485188/
	public static void main(String[] args) {
		ToeplitzMatrix test = new ToeplitzMatrix();
		System.out.println(test.isToeplitzMatrix(new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 1, 2, 3 },
			{ 9, 5, 1, 2 }
		}));
		System.out.println(test.isToeplitzMatrix(new int[][] {
			{ 1, 2 },
			{ 2, 2 }
		}));
	}

	public boolean isToeplitzMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length - 1; i++) {
			for (int j = 0; j < matrix[i].length - 1; j++) {
				if (matrix[i][j] != matrix[i + 1][j + 1]) {
					return false;
				}
			}
		}
		return true;
	}

}
