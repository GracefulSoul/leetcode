package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class MapOfHighestPeak {

	// https://leetcode.com/problems/map-of-highest-peak/submissions/1516732531/
	public static void main(String[] args) {
		MapOfHighestPeak test = new MapOfHighestPeak();
		PrintUtil.print(test.highestPeak(new int[][] {
			{ 0, 1 },
			{ 0, 0 }
		}));
		PrintUtil.print(test.highestPeak(new int[][] {
			{ 0, 0, 1 },
			{ 1, 0, 0 },
			{ 0, 0, 0 }
		}));
	}

	private static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };

	public int[][] highestPeak(int[][] isWater) {
		int row = isWater.length;
		int col = isWater[0].length;
		int[][] heights = new int[row][col];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (isWater[i][j] == 1) {
					heights[i][j] = 0;
					queue.offer(new int[] { i, j });
				} else {
					heights[i][j] = -1;
				}
			}
		}
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			for (int k = 0; k < 4; k++) {
				int x = curr[0] + DIRECTIONS[k];
				int y = curr[1] + DIRECTIONS[k + 1];
				if (0 <= x && x < row && 0 <= y && y < col && heights[x][y] < 0) {
					heights[x][y] = heights[curr[0]][curr[1]] + 1;
					queue.offer(new int[] { x, y });
				}
			}
		}
		return heights;
	}

}
