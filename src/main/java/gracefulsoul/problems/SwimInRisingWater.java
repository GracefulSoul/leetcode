package gracefulsoul.problems;

public class SwimInRisingWater {

	// https://leetcode.com/problems/swim-in-rising-water/submissions/864037849/
	public static void main(String[] args) {
		SwimInRisingWater test = new SwimInRisingWater();
		System.out.println(test.swimInWater(new int[][] {
			{ 0, 2 },
			{ 1, 3 }
		}));
		System.out.println(test.swimInWater(new int[][] {
			{ 0, 1, 2, 3, 4 },
			{ 24, 23, 22, 21, 5 },
			{ 12, 13, 14, 15, 16 },
			{ 11, 17, 18, 19, 20 },
			{ 10, 9, 8, 7, 6 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ -1, 0 },
		{ 1, 0 },
		{ 0, 1 },
		{ 0, -1 }
	};

	public int swimInWater(int[][] grid) {
		int length = grid.length;
		int left = Math.max(grid[0][0], grid[length - 1][length - 1]);
		int right = (length * length) - 1;
		while (left < right) {
			int mid = left + (right - left) / 2;
			boolean[][] visited = new boolean[length][length];
			if (this.dfs(grid, length, 0, 0, mid, visited)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean dfs(int[][] grid, int length, int i, int j, int mid, boolean[][] visited) {
		if (i == length - 1 && j == length - 1) {
			return true;
		}
		visited[i][j] = true;
		for (int[] direction : DIRECTIONS) {
			int row = i + direction[0];
			int col = j + direction[1];
			if (0 <= row && row < length && 0 <= col && col < length && grid[row][col] <= mid && !visited[row][col] && this.dfs(grid, length, row, col, mid, visited)) {
				return true;
			}
		}
		return false;
	}

}
