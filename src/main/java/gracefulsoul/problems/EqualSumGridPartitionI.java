package gracefulsoul.problems;

public class EqualSumGridPartitionI {

	// https://leetcode.com/problems/equal-sum-grid-partition-i/submissions/1958743352/
	public static void main(String[] args) {
		EqualSumGridPartitionI test = new EqualSumGridPartitionI();
		System.out.println(test.canPartitionGrid(new int[][] {
			{ 1, 4 },
			{ 2, 3 }
		}));
		System.out.println(test.canPartitionGrid(new int[][] {
			{ 1, 3 },
			{ 2, 4 }
		}));
	}

	public boolean canPartitionGrid(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		long sum = 0;
		for (int[] row : grid) {
			for (int num : row) {
				sum += num;
			}
		}
		if ((sum & 1) == 1) {
			return false;
		}
		long target = sum / 2;
		sum = 0;
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < cols; j++) {
				sum += grid[i][j];
			}
			if (sum == target) {
				return true;
			}
		}
		sum = 0;
		for (int j = 0; j < cols - 1; j++) {
			for (int i = 0; i < rows; i++) {
				sum += grid[i][j];
			}
			if (sum == target) {
				return true;
			}
		}
		return false;
	}

}
