package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class LargestLocalValuesInAMatrix {

	// https://leetcode.com/problems/largest-local-values-in-a-matrix/submissions/1255716721/
	public static void main(String[] args) {
		LargestLocalValuesInAMatrix test = new LargestLocalValuesInAMatrix();
		PrintUtil.print(test.largestLocal(new int[][] {
			{ 9, 9, 8, 1 },
			{ 5, 6, 2, 6 },
			{ 8, 2, 6, 4 },
			{ 6, 2, 2, 2 }
		}));
		PrintUtil.print(test.largestLocal(new int[][] {
			{ 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1 },
			{ 1, 1, 2, 1, 1 },
			{ 1, 1, 1, 1, 1 },
			{ 1, 1, 1, 1, 1 }
		}));
	}

	public int[][] largestLocal(int[][] grid) {
		int[][] result = new int[grid.length - 2][grid.length - 2];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result.length; j++) {
				int max = 0;
				for (int k = i; k < i + 3; k++) {
					for (int l = j; l < j + 3; l++) {
						max = Math.max(max, grid[k][l]);
					}
				}
				result[i][j] = max;
			}
		}
		return result;
	}

}
