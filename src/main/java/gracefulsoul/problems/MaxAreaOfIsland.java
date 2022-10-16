package gracefulsoul.problems;

public class MaxAreaOfIsland {

	// https://leetcode.com/submissions/detail/823617190/
	public static void main(String[] args) {
		MaxAreaOfIsland test = new MaxAreaOfIsland();
		System.out.println(test.maxAreaOfIsland(new int[][] {
			{ 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
			{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 }
		}));
		System.out.println(test.maxAreaOfIsland(new int[][] {
			{ 0, 0, 0, 0, 0, 0, 0, 0 }
		}));
	}

	public int maxAreaOfIsland(int[][] grid) {
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					max = Math.max(max, this.dfs(grid, i, j));
				}
			}
		}
		return max;
	}

	private int dfs(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) {
			return 0;
		} else {
			int area = 1;
			grid[i][j] = 2;
			area += this.dfs(grid, i - 1, j);
			area += this.dfs(grid, i + 1, j);
			area += this.dfs(grid, i, j - 1);
			area += this.dfs(grid, i, j + 1);
			return area;
		}
	}

}
