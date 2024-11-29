package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumTimeToVisitACellInAGrid {

	// https://leetcode.com/problems/minimum-time-to-visit-a-cell-in-a-grid/submissions/1465438735/
	public static void main(String[] args) {
		MinimumTimeToVisitACellInAGrid test = new MinimumTimeToVisitACellInAGrid();
		System.out.println(test.minimumTime(new int[][] {
			{ 0, 1, 3, 2 },
			{ 5, 1, 2, 5 },
			{ 4, 3, 8, 6 }
		}));
		System.out.println(test.minimumTime(new int[][] {
			{ 0, 2, 4 },
			{ 3, 2, 1 },
			{ 1, 0, 4 }
		}));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ 1, 0 },
		{ -1, 0 },
		{ 0, 1 },
		{ 0, -1 }
	};

	public int minimumTime(int[][] grid) {
		if (grid[0][1] > 1 && grid[1][0] > 1) {
			return -1;
		}
		int row = grid.length;
		int col = grid[0].length;
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		queue.offer(new int[] { 0, 0, 0 });
		boolean[][] visited = new boolean[row][col];
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int time = curr[2];
			for (int[] direction : DIRECTIONS) {
				int dx = x + direction[0];
				int dy = y + direction[1];
				if (0 <= dx && dx < row && 0 <= dy && dy < col && !visited[dx][dy]) {
					int currTime = time + 1;
					if (grid[dx][dy] > currTime) {
						currTime += ((grid[dx][dy] - currTime + 1) / 2) * 2;
					}
					if (dx == row - 1 && dy == col - 1) {
						return currTime;
					}
					queue.offer(new int[] { dx, dy, currTime });
					visited[dx][dy] = true;
				}
			}
		}
		return -1;
	}

}
