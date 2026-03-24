package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ConstructProductMatrix {

	// https://leetcode.com/problems/construct-product-matrix/submissions/1957647548/
	public static void main(String[] args) {
		ConstructProductMatrix test = new ConstructProductMatrix();
		PrintUtil.print(test.constructProductMatrix(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}));
		PrintUtil.print(test.constructProductMatrix(new int[][] {
			{ 12345 },
			{ 2 },
			{ 1 }
		}));
	}

	public int[][] constructProductMatrix(int[][] grid) {
		int mod = 12345;
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] result = new int[rows][cols];
		long suffix = 1;
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				result[i][j] = (int) suffix;
				suffix = (suffix * grid[i][j]) % mod;
			}
		}
		long prefix = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = (int) (((long) result[i][j] * prefix) % mod);
				prefix = (prefix * grid[i][j]) % mod;
			}
		}
		return result;
	}

}
