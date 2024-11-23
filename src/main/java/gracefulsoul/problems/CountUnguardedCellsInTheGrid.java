package gracefulsoul.problems;

public class CountUnguardedCellsInTheGrid {

	// https://leetcode.com/problems/count-unguarded-cells-in-the-grid/submissions/1459049367/
	public static void main(String[] args) {
		CountUnguardedCellsInTheGrid test = new CountUnguardedCellsInTheGrid();
		System.out.println(test.countUnguarded(4, 6, new int[][] {
			{ 0, 0 },
			{ 1, 1 },
			{ 2, 3 }
		}, new int[][] {
			{ 0, 1 },
			{ 2, 2 },
			{ 1, 4 }
		}));
		System.out.println(test.countUnguarded(3, 3, new int[][] {
			{ 1, 1 }
		}, new int[][] {
			{ 0, 1 },
			{ 1, 0 },
			{ 2, 1 },
			{ 1, 2 }
		}));
	}

	public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
		int[][] grid = new int[m][n];
		for (int[] wall : walls) {
			grid[wall[0]][wall[1]] = 1;
		}
		for (int[] guard : guards) {
			grid[guard[0]][guard[1]] = 1;
		}
		int count = (m * n) - guards.length - walls.length;
		for (int[] guard : guards) {
			int x = guard[0] - 1;
			int y = guard[1];
			while (0 <= x && grid[x][y] != 1) {
				if (grid[x][y] != -1) {
					count--;
					grid[x][y] = -1;
				}
				x--;
			}
			x = guard[0] + 1;
			while (x < m && grid[x][y] != 1) {
				if (grid[x][y] != -1) {
					count--;
					grid[x][y] = -1;
				}
				x++;
			}
			x = guard[0];
			y = guard[1] - 1;
			while (0 <= y && grid[x][y] != 1) {
				if (grid[x][y] != -1) {
					count--;
					grid[x][y] = -1;
				}
				y--;
			}
			y = guard[1] + 1;
			while (y < n && grid[x][y] != 1) {
				if (grid[x][y] != -1) {
					count--;
					grid[x][y] = -1;
				}
				y++;
			}
		}
		return count;
	}

}
