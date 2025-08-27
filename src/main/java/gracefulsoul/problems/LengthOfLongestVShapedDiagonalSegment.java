package gracefulsoul.problems;

public class LengthOfLongestVShapedDiagonalSegment {

	// https://leetcode.com/problems/length-of-longest-v-shaped-diagonal-segment/submissions/1750029899/
	public static void main(String[] args) {
		LengthOfLongestVShapedDiagonalSegment test = new LengthOfLongestVShapedDiagonalSegment();
		System.out.println(test.lenOfVDiagonal(new int[][] {
			{ 2, 2, 1, 2, 2 },
			{ 2, 0, 2, 2, 0 },
			{ 2, 0, 1, 1, 0 },
			{ 1, 0, 2, 2, 2 },
			{ 2, 0, 0, 2, 2 }
		}));
		System.out.println(test.lenOfVDiagonal(new int[][] {
			{ 2, 2, 2, 2, 2 },
			{ 2, 0, 2, 2, 0 },
			{ 2, 0, 1, 1, 0 },
			{ 1, 0, 2, 2, 2 },
			{ 2, 0, 0, 2, 2 }
		}));
		System.out.println(test.lenOfVDiagonal(new int[][] {
			{ 1, 2, 2, 2, 2 },
			{ 2, 2, 2, 2, 0 },
			{ 2, 0, 0, 0, 0 },
			{ 0, 0, 2, 2, 2 },
			{ 2, 0, 0, 2, 0 }
		}));
		System.out.println(test.lenOfVDiagonal(new int[][] {
			{ 1 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 1, 1 },
		{ 1, -1 },
		{ -1, -1 },
		{ -1, 1 }
	};

	public int lenOfVDiagonal(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		int[][][] memo = new int[rows][cols][8];
		int result = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1) {
					for (int k = 0; k < 4; k++) {
						result = Math.max(result, this.dfs(grid, memo, i, j, k, 1, 2) + 1);
					}
				}
			}
		}
		return result;
	}

	private int dfs(int[][] grid, int[][][] memo, int i, int j, int k, int turn, int target) {
		int[] direction = DIRECTIONS[k];
		i += direction[0];
		j += direction[1];
		if (i < 0 || grid.length <= i || j < 0 || grid[i].length <= j || grid[i][j] != target) {
			return 0;
		} else {
			int index = (k << 1) | turn;
			if (memo[i][j][index] == 0) {
				int max = this.dfs(grid, memo, i, j, k, turn, 2 - target);
				if (turn == 1) {
					max = Math.max(max, this.dfs(grid, memo, i, j, (k + 1) % 4, 0, 2 - target));
				}
				memo[i][j][index] = max + 1;
			}
			return memo[i][j][index];
		}
	}

}
