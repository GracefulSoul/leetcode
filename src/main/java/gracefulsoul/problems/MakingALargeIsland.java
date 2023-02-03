package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class MakingALargeIsland {

	// https://leetcode.com/problems/making-a-large-island/submissions/890961044/
	public static void main(String[] args) {
		MakingALargeIsland test = new MakingALargeIsland();
		System.out.println(test.largestIsland(new int[][] {
			{ 1, 0 },
			{ 0, 1 }
		}));
		System.out.println(test.largestIsland(new int[][] {
			{ 1, 1 },
			{ 1, 0 }
		}));
		System.out.println(test.largestIsland(new int[][] {
			{ 1, 1 },
			{ 1, 1 }
		}));
	}

	private int count = 0;
	private int num = 10;
	private int length;

	public int largestIsland(int[][] grid) {
		this.length = grid.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.length; j++) {
				if (grid[i][j] == 1) {
					this.count = 0;
					this.find(grid, i, j);
					map.put(this.num, this.count);
					this.change(grid, i, j);
					this.num++;
				}
			}
		}
		int max = 0;
		for (int i = 0; i < this.length; i++) {
			for (int j = 0; j < this.length; j++) {
				if (grid[i][j] == 0) {
					count = 1;
					int[] tmp = new int[4];
					if (i > 0) {
						tmp[0] = grid[i - 1][j];
					}
					if (i + 1 < this.length) {
						tmp[1] = grid[i + 1][j];
					}
					if (j > 0) {
						tmp[2] = grid[i][j - 1];
					}
					if (j + 1 < this.length) {
						tmp[3] = grid[i][j + 1];
					}
					for (int k = 0; k < 3; k++) {
						for (int l = k + 1; l < 4; l++) {
							if (tmp[k] == tmp[l]) {
								tmp[k] = 0;
							}
						}
					}
					for (int x : tmp) {
						if (x > 9) {
							this.count += map.get(x);
						}
					}
					max = Math.max(max, this.count);
				}
			}
		}
		return max == 0 ? map.get(10) : max;
	}

	private void find(int[][] grid, int i, int j) {
		this.count++;
		grid[i][j] = 2;
		if (i > 0 && grid[i - 1][j] == 1) {
			this.find(grid, i - 1, j);
		}
		if (i + 1 < this.length && grid[i + 1][j] == 1) {
			this.find(grid, i + 1, j);
		}
		if (j > 0 && grid[i][j - 1] == 1) {
			this.find(grid, i, j - 1);
		}
		if (j + 1 < this.length && grid[i][j + 1] == 1) {
			this.find(grid, i, j + 1);
		}
	}

	private void change(int[][] grid, int i, int j) {
		grid[i][j] = this.num;
		if (i > 0 && grid[i - 1][j] == 2) {
			this.change(grid, i - 1, j);
		}
		if (i + 1 < this.length && grid[i + 1][j] == 2) {
			this.change(grid, i + 1, j);
		}
		if (j > 0 && grid[i][j - 1] == 2) {
			this.change(grid, i, j - 1);
		}
		if (j + 1 < this.length && grid[i][j + 1] == 2) {
			this.change(grid, i, j + 1);
		}
	}

}
