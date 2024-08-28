package gracefulsoul.problems;

public class CountSubIslands {

	// https://leetcode.com/problems/count-sub-islands/submissions/1370979716/
	public static void main(String[] args) {
		CountSubIslands test = new CountSubIslands();
		System.out.println(test.countSubIslands(new int[][] {
			{ 1, 1, 1, 0, 0 },
			{ 0, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0 },
			{ 1, 1, 0, 1, 1 }
		}, new int[][] {
			{ 1, 1, 1, 0, 0 },
			{ 0, 0, 1, 1, 1 },
			{ 0, 1, 0, 0, 0 },
			{ 1, 0, 1, 1, 0 },
			{ 0, 1, 0, 1, 0 }
		}));
		System.out.println(test.countSubIslands(new int[][] {
			{ 1, 0, 1, 0, 1 },
			{ 1, 1, 1, 1, 1 },
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1 },
			{ 1, 0, 1, 0, 1 }
		}, new int[][] {
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 1, 1 },
			{ 0, 1, 0, 1, 0 },
			{ 0, 1, 0, 1, 0 },
			{ 1, 0, 0, 0, 1 }
		}));
	}

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		int result = 0;
		for (int i = 0; i < grid2.length; i++) {
			for (int j = 0; j < grid2[0].length; j++) {
				if (grid2[i][j] == 1 && this.dfs(grid1, grid2, i, j)) {
					result++;
				}
			}
		}
		return result;
	}

	private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
		boolean result = true;
		if (0 <= i && i < grid2.length && 0 <= j && j < grid2[0].length && grid2[i][j] == 1) {
			if (grid1[i][j] != grid2[i][j]) {
				result = false;
			}
			grid2[i][j] = 0;
			result &= this.dfs(grid1, grid2, i - 1, j);
			result &= this.dfs(grid1, grid2, i + 1, j);
			result &= this.dfs(grid1, grid2, i, j - 1);
			result &= this.dfs(grid1, grid2, i, j + 1);
		}
		return result;
	}

}
