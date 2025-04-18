package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class Shift2DGrid {

	// https://leetcode.com/problems/shift-2d-grid/submissions/1610357310/
	public static void main(String[] args) {
		Shift2DGrid test = new Shift2DGrid();
		System.out.println(test.shiftGrid(new int[][] {
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		}, 1));
		System.out.println(test.shiftGrid(new int[][] {
			{ 3, 8, 1, 9 },
			{ 19, 7, 2, 5 },
			{ 4, 6, 11, 10 },
			{ 12, 0, 21, 13 }
		}, 4));
	}

	public List<List<Integer>> shiftGrid(int[][] grid, int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[][] arr = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				arr[(i + ((j + k) / cols)) % rows][(j + k) % cols] = grid[i][j];
			}
		}
		List<List<Integer>> result = new ArrayList<>();
		for (int[] row : arr) {
			List<Integer> list = new ArrayList<>();
			for (int col : row) {
				list.add(col);
			}
			result.add(list);
		}
		return result;
	}

}
