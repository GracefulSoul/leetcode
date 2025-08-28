package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Collections;

import gracefulsoul.util.PrintUtil;

public class SortMatrixByDiagonals {

	// https://leetcode.com/problems/sort-matrix-by-diagonals/submissions/1751217298/
	public static void main(String[] args) {
		SortMatrixByDiagonals test = new SortMatrixByDiagonals();
		PrintUtil.print(test.sortMatrix(new int[][] {
			{ 1, 7, 3 },
			{ 9, 8, 2 },
			{ 4, 5, 6 }
		}));
		PrintUtil.print(test.sortMatrix(new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}));
	}

	public int[][] sortMatrix(int[][] grid) {
		int length = grid.length;
		for (int i = 0; i < length; i++) {
			this.sortDiagonal(grid, i, 0, false);
		}
		for (int j = 1; j < length; j++) {
			this.sortDiagonal(grid, 0, j, true);
		}
		return grid;
	}

	private void sortDiagonal(int[][] grid, int row, int col, boolean isAscending) {
		int length = grid.length - (isAscending ? col : row);
		Integer[] diagonal = new Integer[length];
		for (int i = row, j = col, k = 0; k < length; k++) {
			diagonal[k] = grid[i++][j++];
		}
		if (isAscending) {
			Arrays.sort(diagonal);
		} else {
			Arrays.sort(diagonal, Collections.reverseOrder());
		}
		for (int i = row, j = col, k = 0; k < length; k++) {
			grid[i++][j++] = diagonal[k];
		}
	}

}
