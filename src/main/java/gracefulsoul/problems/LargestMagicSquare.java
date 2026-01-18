package gracefulsoul.problems;

public class LargestMagicSquare {

	// https://leetcode.com/problems/largest-magic-square/submissions/1888544970/
	public static void main(String[] args) {
		LargestMagicSquare test = new LargestMagicSquare();
		System.out.println(test.largestMagicSquare(new int[][] {
			{ 7, 1, 4, 5, 6 },
			{ 2, 5, 1, 6, 4 },
			{ 1, 5, 4, 3, 2 },
			{ 1, 2, 7, 3, 4 }
		}));
		System.out.println(test.largestMagicSquare(new int[][] {
			{ 5, 1, 3, 1 },
			{ 9, 3, 3, 1 },
			{ 1, 3, 3, 8 }
		}));
	}

	public int largestMagicSquare(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int size = Math.min(rows, cols);
		while (size > 0) {
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (i + size <= rows && j + size <= cols) {
						if (this.isValid(grid, i, j, size)) {
							return size;
						}
					}
				}
			}
			size--;
		}
		return 0;
	}

	private boolean isValid(int[][] grid, int i, int j, int size) {
		int sum1 = 0;
		for (int x = i; x < i + size; x++) {
			int temp = 0;
			for (int y = j; y < j + size; y++) {
				temp += grid[x][y];
			}
			if (x == i) {
				sum1 = temp;
			} else if (sum1 != temp) {
				return false;
			}
		}
		for (int x = j; x < j + size; x++) {
			int temp = 0;
			for (int y = i; y < i + size; y++) {
				temp += grid[y][x];
			}
			if (sum1 != temp) {
				return false;
			}
		}
		int sum2 = 0;
		for (int k = 0; k < size; k++) {
			sum2 += grid[i + k][j + k];
		}
		if (sum1 != sum2) {
			return false;
		}
		sum2 = 0;
		for (int k = 0; k < size; k++) {
			sum2 += grid[i + k][j + size - 1 - k];
		}
		if (sum1 != sum2) {
			return false;
		}
		return true;
	}

}
