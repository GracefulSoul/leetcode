package gracefulsoul.problems;

public class BricksFallingWhenHit {

	// https://leetcode.com/problems/bricks-falling-when-hit/submissions/877707286/
	public static void main(String[] args) {
		BricksFallingWhenHit test = new BricksFallingWhenHit();
		System.out.println(test.hitBricks(new int[][] {
			{ 1, 0, 0, 0 },
			{ 1, 1, 1, 0 }
		}, new int[][] {
			{ 1, 0 }
		}));
		System.out.println(test.hitBricks(new int[][] {
			{ 1, 0, 0, 0 },
			{ 1, 1, 0, 0 }
		}, new int[	][] {
			{ 1, 1 },
			{ 1, 0 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 1, 0 },
		{ -1, 0 },
		{ 0, 1 },
		{ 0, -1 }
	};

	public int[] hitBricks(int[][] grid, int[][] hits) {
		int[] result = new int[hits.length];
		for (int[] hit : hits) {
			grid[hit[0]][hit[1]]--;
		}
		for (int i = 0; i < grid[0].length; i++) {
			this.dfs(grid, 0, i);
		}
		for (int i = hits.length - 1; i >= 0; i--) {
			int x = hits[i][0];
			int y = hits[i][1];
			grid[x][y]++;
			if (grid[x][y] == 1 && this.isConnected(x, y, grid)) {
				result[i] = this.dfs(grid, x, y) - 1;
			}
		}
		return result;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) {
			return 0;
		}
		grid[i][j] = 2;
		return this.dfs(grid, i + 1, j) + this.dfs(grid, i - 1, j) + this.dfs(grid, i, j + 1) + this.dfs(grid, i, j - 1) + 1;
	}

	private boolean isConnected(int i, int j, int[][] grid) {
		if (i == 0) {
			return true;
		}
		for (int[] direction : DIRECTIONS) {
			int x = i + direction[0];
			int y = j + direction[1];
			if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 2) {
				return true;
			}
		}
		return false;
	}

}
