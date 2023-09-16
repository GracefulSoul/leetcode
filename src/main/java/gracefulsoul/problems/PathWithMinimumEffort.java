package gracefulsoul.problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {

	// https://leetcode.com/problems/path-with-minimum-effort/submissions/1050506436/
	public static void main(String[] args) {
		PathWithMinimumEffort test = new PathWithMinimumEffort();
		System.out.println(test.minimumEffortPath(new int[][] {
			{ 1, 2, 2 },
			{ 3, 8, 2 },
			{ 5, 3, 5 }
		}));
		System.out.println(test.minimumEffortPath(new int[][] {
			{ 1, 2, 3 },
			{ 3, 8, 2 },
			{ 5, 3, 5 }
		}));
		System.out.println(test.minimumEffortPath(new int[][] {
			{ 1, 2, 1, 1, 1 },
			{ 1, 2, 1, 2, 1 },
			{ 1, 2, 1, 2, 1 },
			{ 1, 2, 1, 2, 1 },
			{ 1, 1, 1, 2, 1 }
		}));
	}

	public int minimumEffortPath(int[][] heights) {
		int row = heights.length;
		int col = heights[0].length;
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
		int[][] dist = new int[row][col];
		int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		for (int[] r : dist) {
			Arrays.fill(r, Integer.MAX_VALUE);
		}
		dist[0][0] = 0;
		queue.add(new int[] { 0, 0, 0 });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int diff = curr[2];
			if (x == row - 1 && y == col - 1) {
				return diff;
			}
			for (int[] direction : directions) {
				int nx = x + direction[0];
				int ny = y + direction[1];
				if (nx >= 0 && nx < row && ny >= 0 && ny < col) {
					int next = Math.max(diff, Math.abs(heights[nx][ny] - heights[x][y]));
					if (next < dist[nx][ny]) {
						dist[nx][ny] = next;
						queue.add(new int[] { nx, ny, next });
					}
				}
			}
		}
		return 0;
	}

}
