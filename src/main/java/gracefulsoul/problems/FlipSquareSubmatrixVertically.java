package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FlipSquareSubmatrixVertically {

	// https://leetcode.com/problems/flip-square-submatrix-vertically/submissions/1954487342/
	public static void main(String[] args) {
		FlipSquareSubmatrixVertically test = new FlipSquareSubmatrixVertically();
		PrintUtil.print(test.reverseSubmatrix(new int[][] {
			{ 1, 2, 3, 4 },
			{ 5, 6, 7, 8 },
			{ 9, 10, 11, 12 },
			{ 13, 14, 15, 16 }
		}, 1, 0, 3));
		PrintUtil.print(test.reverseSubmatrix(new int[][] {
			{ 3, 4, 2, 3 },
			{ 2, 3, 4, 2 }
		}, 0, 2, 2));
	}

	public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
		for (int i = 0; i < k >> 1; i++) {
			for (int j = 0; j < k; j++) {
				int xi = x + i;
				int nx = x + k - 1 - i;
				int yj = y + j;
				int temp = grid[xi][yj];
				grid[xi][yj] = grid[nx][yj];
				grid[nx][yj] = temp;
			}
		}
		return grid;
	}

}
