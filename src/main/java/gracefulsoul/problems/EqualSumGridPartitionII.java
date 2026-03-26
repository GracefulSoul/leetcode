package gracefulsoul.problems;

public class EqualSumGridPartitionII {

	// https://leetcode.com/problems/equal-sum-grid-partition-ii/submissions/1959800152/
	public static void main(String[] args) {
		EqualSumGridPartitionII test = new EqualSumGridPartitionII();
		System.out.println(test.canPartitionGrid(new int[][] {
			{ 1, 4 },
			{ 2, 3 }
		}));
		System.out.println(test.canPartitionGrid(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}));
		System.out.println(test.canPartitionGrid(new int[][] {
			{ 1, 2, 4 },
			{ 2, 3, 5 }
		}));
	}

	public boolean canPartitionGrid(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		long total = 0;
		int[] bottom = new int[100001];
		int[] top = new int[100001];
		int[] left = new int[100001];
		int[] right = new int[100001];
		for (int[] row : grid) {
			for (int value : row) {
				total += value;
				bottom[value]++;
				right[value]++;
			}
		}
		long sumTop = 0;
		for (int i = 0; i < rows - 1; i++) {
			for (int j = 0; j < cols; j++) {
				int value = grid[i][j];
				sumTop += value;
				top[value]++;
				bottom[value]--;
			}
			long sumBottom = total - sumTop;
			if (sumTop == sumBottom) {
				return true;
			}
			long diff = Math.abs(sumTop - sumBottom);
			if (diff <= 100000) {
				if (sumBottom < sumTop) {
					if (this.check(grid, top, 0, 0, i, cols - 1, diff)) {
						return true;
					}
				} else if (this.check(grid, bottom, i + 1, 0, rows - 1, cols - 1, diff)) {
					return true;
				}
			}
		}
		long sumLeft = 0;
		for (int j = 0; j < cols - 1; j++) {
			for (int i = 0; i < rows; i++) {
				int value = grid[i][j];
				sumLeft += value;
				left[value]++;
				right[value]--;
			}
			long sumRight = total - sumLeft;
			if (sumLeft == sumRight) {
				return true;
			}
			long diff = Math.abs(sumLeft - sumRight);
			if (diff <= 100000) {
				if (sumRight < sumLeft) {
					if (this.check(grid, left, 0, 0, rows - 1, j, diff)) {
						return true;
					}
				} else if (this.check(grid, right, 0, j + 1, rows - 1, cols - 1, diff)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean check(int[][] grid, int[] counts, int r1, int c1, int r2, int c2, long diff) {
		int rows = r2 - r1 + 1;
		int cols = c2 - c1 + 1;
		if (rows * cols == 1) {
			return false;
		} else if (rows == 1) {
			return grid[r1][c1] == diff || grid[r1][c2] == diff;
		} else if (cols == 1) {
			return grid[r1][c1] == diff || grid[r2][c1] == diff;
		} else {
			return counts[(int) diff] > 0;
		}
	}

}
