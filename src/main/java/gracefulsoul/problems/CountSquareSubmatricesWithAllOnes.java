package gracefulsoul.problems;

public class CountSquareSubmatricesWithAllOnes {

	// https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/1434725813/
	public static void main(String[] args) {
		CountSquareSubmatricesWithAllOnes test = new CountSquareSubmatricesWithAllOnes();
		System.out.println(test.countSquares(new int[][] {
			{ 0, 1, 1, 1 },
			{ 1, 1, 1, 1 },
			{ 0, 1, 1, 1 }
		}));
		System.out.println(test.countSquares(new int[][] {
			{ 1, 0, 1 },
			{ 1, 1, 0 },
			{ 1, 1, 0 }
		}));
	}

	public int countSquares(int[][] matrix) {
		int result = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (matrix[i][j] > 0 && i > 0 && j > 0) {
					matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
				}
				result += matrix[i][j];
			}
		}
		return result;
	}

}
