package gracefulsoul.problems;

public class MaximumNonNegativeProductInAMatrix {

	// https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/submissions/1956632936/
	public static void main(String[] args) {
		MaximumNonNegativeProductInAMatrix test = new MaximumNonNegativeProductInAMatrix();
		System.out.println(test.maxProductPath(new int[][] {
			{ -1, -2, -3 },
			{ -2, -3, -3 },
			{ -3, -3, -2 }
		}));
		System.out.println(test.maxProductPath(new int[][] {
			{ 1, -2, 1 },
			{ 1, -2, 1 },
			{ 3, -4, 1 }
		}));
		System.out.println(test.maxProductPath(new int[][] {
			{ 1, 3 },
			{ 0, -4 }
		}));
	}

	public int maxProductPath(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int mod = 1000000007;
		long[] minDp = new long[cols];
		long[] maxDp = new long[cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 && j == 0) {
					minDp[j] = maxDp[j] = grid[i][j];
					continue;
				}
				Long min = Long.MAX_VALUE;
				Long max = Long.MIN_VALUE;
				if (0 < i) {
					min = Math.min(grid[i][j] * minDp[j], grid[i][j] * maxDp[j]);
					max = Math.max(grid[i][j] * minDp[j], grid[i][j] * maxDp[j]);
				}
				if (0 < j) {
					min = Math.min(Math.min(grid[i][j] * minDp[j - 1], grid[i][j] * maxDp[j - 1]), min);
					max = Math.max(Math.max(grid[i][j] * minDp[j - 1], grid[i][j] * maxDp[j - 1]), max);
				}
				minDp[j] = min;
				maxDp[j] = max;
			}
		}
		return maxDp[cols - 1] >= 0 ? (int) (maxDp[cols - 1] % mod) : -1;
	}

}
