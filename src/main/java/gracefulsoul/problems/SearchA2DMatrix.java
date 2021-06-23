package gracefulsoul.problems;

public class SearchA2DMatrix {

	// https://leetcode.com/submissions/detail/512002972/
	public static void main(String[] args) {
		SearchA2DMatrix test = new SearchA2DMatrix();
		System.out.println(test.searchMatrix(
			new int[][] {
				new int[] { 1, 3, 5, 7 },
				new int[] { 10, 11, 16, 20 },
				new int[] { 23, 30, 34, 60 }
			}, 3
		));
		System.out.println(test.searchMatrix(
			new int[][] {
				new int[] { 1, 3, 5, 7 },
				new int[] { 10, 11, 16, 20 },
				new int[] { 23, 30, 34, 60 }
			}, 13
		));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		int i = matrix.length - 1;
		int j = 0;
		while (i >= 0 && j < matrix[0].length) {
			if (matrix[i][j] == target) {
				return true;
			} else if (matrix[i][j] > target) {
				i--;
			} else {
				j++;
			}
		}
		return false;
	}

}
