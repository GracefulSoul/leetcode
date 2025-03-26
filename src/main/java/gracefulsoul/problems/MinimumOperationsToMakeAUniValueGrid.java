package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumOperationsToMakeAUniValueGrid {

	// https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/submissions/1587002071/
	public static void main(String[] args) {
		MinimumOperationsToMakeAUniValueGrid test = new MinimumOperationsToMakeAUniValueGrid();
		System.out.println(test.minOperations(new int[][] {
			{ 2, 4 },
			{ 6, 8 }
		}, 0));
		System.out.println(test.minOperations(new int[][] {
			{ 1, 5 },
			{ 2, 3 }
		}, 1));
		System.out.println(test.minOperations(new int[][] {
			{ 1, 2 },
			{ 3, 4 }
		}, 2));
	}

	public int minOperations(int[][] grid, int x) {
		int row = grid.length;
		int col = grid[0].length;
		int[] array = new int[row * col];
		int index = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				array[index++] = grid[i][j];
			}
		}
		int base = array[0] % x;
		for (int num : array) {
			if (num % x != base) {
				return -1;
			}
		}
		Arrays.sort(array);
		int mid = array[array.length / 2];
		int result = 0;
		for (int num : array) {
			result += Math.abs(num - mid) / x;
		}
		return result;
	}

}
