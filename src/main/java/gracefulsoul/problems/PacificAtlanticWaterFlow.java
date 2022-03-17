package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	// https://leetcode.com/submissions/detail/661540164/
	public static void main(String[] args) {
		PacificAtlanticWaterFlow test = new PacificAtlanticWaterFlow();
		System.out.println(test.pacificAtlantic(new int[][] {
			{ 1, 2, 2, 3, 5 },
			{ 3, 2, 3, 4, 4 },
			{ 2, 4, 5, 3, 1 },
			{ 6, 7, 1, 4, 5 },
			{ 5, 1, 1, 2, 4 }
		}));
		System.out.println(test.pacificAtlantic(new int[][] {
			{ 2, 1 },
			{ 1, 2 }
		}));
	}

	private List<List<Integer>> result;
	private boolean[][] pacific;
	private boolean[][] atlantic;

	public List<List<Integer>> pacificAtlantic(int[][] heights) {
		int row = heights.length;
		int col = heights[0].length;
		this.result = new ArrayList<>();
		this.pacific = new boolean[row][col];
		this.atlantic = new boolean[row][col];
		for (int idx = 0; idx < row; idx++) {
			this.dfs(heights, this.pacific, idx, 0, row, col);
			this.dfs(heights, this.atlantic, idx, col - 1, row, col);
		}
		for (int idx = 0; idx < col; idx++) {
			this.dfs(heights, this.pacific, 0, idx, row, col);
			this.dfs(heights, this.atlantic, row - 1, idx, row, col);
		}
		return this.result;
	}

	public void dfs(int[][] heights, boolean[][] visit, int i, int j, int row, int col) {
		if (visit[i][j]) {
			return;
		}
		visit[i][j] = true;
		if (this.pacific[i][j] && this.atlantic[i][j]) {
			List<Integer> temp = new ArrayList<>();
			temp.add(i);
			temp.add(j);
			this.result.add(temp);
		}
		if (i + 1 < row && heights[i + 1][j] >= heights[i][j]) {
			this.dfs(heights, visit, i + 1, j, row, col);
		}
		if (i - 1 >= 0 && heights[i - 1][j] >= heights[i][j]) {
			this.dfs(heights, visit, i - 1, j, row, col);
		}
		if (j + 1 < col && heights[i][j + 1] >= heights[i][j]) {
			this.dfs(heights, visit, i, j + 1, row, col);
		}
		if (j - 1 >= 0 && heights[i][j - 1] >= heights[i][j]) {
			this.dfs(heights, visit, i, j - 1, row, col);
		}
		return;
	}

}
