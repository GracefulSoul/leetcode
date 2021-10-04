package gracefulsoul.problems;

public class NumberOfIslands {

	// https://leetcode.com/submissions/detail/565337868/
	public static void main(String[] args) {
		NumberOfIslands test = new NumberOfIslands();
		System.out.println(test.numIslands(new char[][] {
			new char[] { '1', '1', '1', '1', '0' },
			new char[] { '1', '1', '0', '1', '0' },
			new char[] { '1', '1', '0', '0', '0' },
			new char[] { '0', '0', '0', '0', '0' }
		}));
		System.out.println(test.numIslands(new char[][] {
			new char[] { '1', '1', '0', '0', '0' },
			new char[] { '1', '1', '0', '0', '0' },
			new char[] { '0', '0', '1', '0', '0' },
			new char[] { '0', '0', '0', '1', '1' }
		}));
	}

	public int numIslands(char[][] grid) {
		int result = 0;
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					this.dfs(grid, i, j);
					result++;
				}
			}
		return result;
	}

	private void dfs(char[][] grid, int i, int j) {
		if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			grid[i][j] = '0';
			this.dfs(grid, i + 1, j);
			this.dfs(grid, i - 1, j);
			this.dfs(grid, i, j + 1);
			this.dfs(grid, i, j - 1);
		}
	}

}
