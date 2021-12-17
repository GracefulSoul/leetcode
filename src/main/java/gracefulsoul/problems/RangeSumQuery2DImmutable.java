package gracefulsoul.problems;

public class RangeSumQuery2DImmutable {

	// https://leetcode.com/submissions/detail/603082951/
	public static void main(String[] args) {
		NumMatrix numMatrix = new NumMatrix(new int[][] {
			new int[] { 3, 0, 1, 4, 2 },
			new int[] { 5, 6, 3, 2, 1 },
			new int[] { 1, 2, 0, 1, 5 },
			new int[] { 4, 1, 0, 1, 7 },
			new int[] { 1, 0, 3, 0, 5 }
		});
		System.out.println(numMatrix.sumRegion(2, 1, 4, 3)); // return 8 (i.e sum of the red rectangle)
		System.out.println(numMatrix.sumRegion(1, 1, 2, 2)); // return 11 (i.e sum of the green rectangle)
		System.out.println(numMatrix.sumRegion(1, 2, 2, 4)); // return 12 (i.e sum of the blue rectangle)
	}

}

class NumMatrix {

	private int[][] matrix;

	public NumMatrix(int[][] matrix) {
		this.matrix = matrix;
		int rowLength = matrix.length;
		int colLength = matrix[0].length;
		for (int i = 0; i < rowLength; i++) {
			int sum = matrix[i][0];
			for (int j = 1; j < colLength; j++) {
				sum += matrix[i][j];
				matrix[i][j] = sum;
			}
		}
		for (int j = 0; j < colLength; j++) {
			int sum = matrix[0][j];
			for (int i = 1; i < rowLength; i++) {
				sum += matrix[i][j];
				matrix[i][j] = sum;
			}
		}
	}

	public int sumRegion(int row1, int col1, int row2, int col2) {
		int sum = matrix[row2][col2];
		if (row1 > 0) {
			sum -= matrix[row1 - 1][col2];
		}
		if (col1 > 0) {
			sum -= matrix[row2][col1 - 1];
		}
		if (row1 > 0 && col1 > 0) {
			sum += matrix[row1 - 1][col1 - 1];
		}
		return sum;
	}

}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */