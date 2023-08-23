package gracefulsoul.problems;

public class UniquePathsIII {

	// https://leetcode.com/problems/unique-paths-iii/submissions/1029415477/
	public static void main(String[] args) {
		UniquePathsIII test = new UniquePathsIII();
		System.out.println(test.uniquePathsIII(new int[][] {
			{ 1, 0, 0, 0 },
			{ 0, 0, 0, 0 },
			{ 0, 0, 2, -1 }
		}));
		System.out.println(test.uniquePathsIII(new int[][] {
			{ 1, 0, 0, 0 },
			{ 0, 0, 0, 0 },
			{ 0, 0, 0, 2 }
		}));
		System.out.println(test.uniquePathsIII(new int[][] {
			{ 0, 1 },
			{ 2, 0 }
		}));
	}

	public int uniquePathsIII(int[][] grid) {
		int count = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 0) {
					count++;
				} else if (grid[i][j] == 1) {
					x = i;
					y = j;
				}
			}
		}
		return this.dfs(grid, x, y, count);
	}

	private int dfs(int[][] grid, int x, int y, int count) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) {
			return 0;
		} else if (grid[x][y] == 2) {
			return count == -1 ? 1 : 0;
		} else {
			grid[x][y] = -1;
			count--;
			int totalCount = this.dfs(grid, x + 1, y, count) + this.dfs(grid, x, y + 1, count) + this.dfs(grid, x - 1, y, count) + this.dfs(grid, x, y - 1, count);
			grid[x][y] = 0;
			count++;
			return totalCount;
		}
	}

}
