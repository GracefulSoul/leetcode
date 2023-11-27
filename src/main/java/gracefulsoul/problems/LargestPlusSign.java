package gracefulsoul.problems;

import java.util.Arrays;

public class LargestPlusSign {

	// https://leetcode.com/problems/largest-plus-sign/submissions/859948375/
	public static void main(String[] args) {
		LargestPlusSign test = new LargestPlusSign();
		System.out.println(test.orderOfLargestPlusSign(5, new int[][] {
			{ 4, 2 }
		}));
		System.out.println(test.orderOfLargestPlusSign(1, new int[][] {
			{ 0, 0 }
		}));
	}

	public int orderOfLargestPlusSign(int n, int[][] mines) {
		int[][] grid = new int[n][n];
		for (int[] row : grid) {
			Arrays.fill(row, n);
		}
		for (int[] mine : mines) {
			grid[mine[0]][mine[1]] = 0;
		}
		for (int i = 0; i < n; i++) {
			int[] direction = new int[] { 0, 0, 0, 0 };
			for (int j = 0, k = n - 1; j < n; j++, k--) {
				grid[i][j] = Math.min(grid[i][j], direction[0] = (grid[i][j] == 0 ? 0 : direction[0] + 1));
				grid[i][k] = Math.min(grid[i][k], direction[1] = (grid[i][k] == 0 ? 0 : direction[1] + 1));
				grid[j][i] = Math.min(grid[j][i], direction[2] = (grid[j][i] == 0 ? 0 : direction[2] + 1));
				grid[k][i] = Math.min(grid[k][i], direction[3] = (grid[k][i] == 0 ? 0 : direction[3] + 1));
			}
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result = Math.max(result, grid[i][j]);
			}
		}
		return result;
	}

}
