package gracefulsoul.problems;

public class MaxIncreaseToKeepCitySkyline {

	// https://leetcode.com/problems/max-increase-to-keep-city-skyline/submissions/879135989/
	public static void main(String[] args) {
		MaxIncreaseToKeepCitySkyline test = new MaxIncreaseToKeepCitySkyline();
		System.out.println(test.maxIncreaseKeepingSkyline(new int[][] {
			{ 3, 0, 8, 4 },
			{ 2, 4, 5, 7 },
			{ 9, 2, 6, 3 },
			{ 0, 3, 1, 0 }
		}));
		System.out.println(test.maxIncreaseKeepingSkyline(new int[][] {
			{ 0, 0, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 0 }
		}));
	}

	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int length = grid.length;
		int[] row = new int[length];
		int[] col = new int[length];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				row[i] = Math.max(row[i], grid[i][j]);
				col[j] = Math.max(col[j], grid[i][j]);
			}
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				result += Math.min(row[i], col[j]) - grid[i][j];
			}
		}
		return result;
	}

}
