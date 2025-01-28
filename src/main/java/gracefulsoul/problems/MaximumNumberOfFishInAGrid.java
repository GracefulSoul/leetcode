package gracefulsoul.problems;

public class MaximumNumberOfFishInAGrid {

	// https://leetcode.com/problems/maximum-number-of-fish-in-a-grid/submissions/1522706749/
	public static void main(String[] args) {
		MaximumNumberOfFishInAGrid test = new MaximumNumberOfFishInAGrid();
		System.out.println(test.findMaxFish(new int[][] {
			{ 0, 2, 1, 0 },
			{ 4, 0, 0, 3 },
			{ 1, 0, 0, 4 },
			{ 0, 3, 2, 0 }
		}));
		System.out.println(test.findMaxFish(new int[][] {
			{ 1, 0, 0, 0 },
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 1 }
		}));
	}

	public int findMaxFish(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int result = 0;
		boolean[][] visited = new boolean[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && grid[i][j] > 0) {
					result = Math.max(result, this.dfs(grid, i, j, visited));
				}
			}
		}
		return result;
	}

	private int dfs(int[][] grid, int i, int j, boolean[][] visited) {
		if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0) {
			return 0;
		} else {
			visited[i][j] = true;
			int total = grid[i][j];
			total += this.dfs(grid, i + 1, j, visited);
			total += this.dfs(grid, i, j + 1, visited);
			total += this.dfs(grid, i, j - 1, visited);
			total += this.dfs(grid, i - 1, j, visited);
			return total;
		}
	}

}
