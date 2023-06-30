package gracefulsoul.problems;

public class LastDayWhereYouCanStillCross {

	// https://leetcode.com/problems/last-day-where-you-can-still-cross/submissions/983002276/
	public static void main(String[] args) {
		LastDayWhereYouCanStillCross test = new LastDayWhereYouCanStillCross();
		System.out.println(test.latestDayToCross(2, 2, new int[][] {
			{ 1, 1 },
			{ 2, 1 },
			{ 1, 2 },
			{ 2, 2 }
		}));
		System.out.println(test.latestDayToCross(2, 2, new int[][] {
			{ 1, 1 },
			{ 1, 2 },
			{ 2, 1 },
			{ 2, 2 }
		}));
		System.out.println(test.latestDayToCross(3, 3, new int[][] {
			{ 1, 2 },
			{ 2, 1 },
			{ 3, 3 },
			{ 2, 2 },
			{ 1, 1 },
			{ 1, 3 },
			{ 2, 3 },
			{ 3, 2 },
			{ 3, 1 }
		}));
	}

	public int latestDayToCross(int row, int col, int[][] cells) {
		int[][] grid = new int[row][col];
		int left = 0;
		int right = row * col;
		while (left < right) {
			int mid = (left + right + 1) / 2;
			for (int i = 0; i < mid; i++) {
				grid[cells[i][0] - 1][cells[i][1] - 1] = mid;
			}
			boolean possible = false;
			for (int i = 0; i < col && !possible; i++) {
				possible = this.dfs(0, i, grid, mid);
			}
			if (possible) {
				left = mid;
			} else {
				right = mid - 1;
			}
		}
		return left;
	}

	private boolean dfs(int i, int j, int[][] grid, int index) {
		if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == index) {
			return false;
		} else {
			grid[i][j] = index;
			return i == grid.length - 1
					|| this.dfs(i + 1, j, grid, index)
					|| this.dfs(i - 1, j, grid, index)
					|| this.dfs(i, j + 1, grid, index)
					|| this.dfs(i, j - 1, grid, index);
		}
	}

}
