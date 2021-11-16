package gracefulsoul.problems;

public class SearchA2DMatrixII {

	// https://leetcode.com/submissions/detail/588101792/
	public static void main(String[] args) {
		SearchA2DMatrixII test = new SearchA2DMatrixII();
		int[][] matrix = new int[][] {
			new int[] { 1, 4, 7, 11, 15 },
			new int[] { 2, 5, 8, 12, 19 },
			new int[] { 3, 6, 9, 16, 22 },
			new int[] { 10, 13, 14, 17, 24 },
			new int[] { 18, 21, 23, 26, 30 }
		};
		System.out.println(test.searchMatrix(matrix, 5));
		System.out.println(test.searchMatrix(matrix, 20));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int col = 0;
		int row = matrix.length - 1;
		while (col <= matrix[0].length - 1 && row >= 0) {
			if (target == matrix[row][col]) {
				return true;
			} else if (target < matrix[row][col]) {
				row--;
			} else if (target > matrix[row][col]) {
				col++;
			}
		}
		return false;
	}

}
