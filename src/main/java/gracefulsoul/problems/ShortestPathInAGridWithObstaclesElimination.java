package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {

	// https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/submissions/1819491398/
	public static void main(String[] args) {
		ShortestPathInAGridWithObstaclesElimination test = new ShortestPathInAGridWithObstaclesElimination();
		System.out.println(test.shortestPath(new int[][] {
			{ 0, 0, 0 },
			{ 1, 1, 0 },
			{ 0, 0, 0 },
			{ 0, 1, 1 },
			{ 0, 0, 0 }
		}, 1));
		System.out.println(test.shortestPath(new int[][] {
			{ 0, 1, 1 },
			{ 1, 1, 1 },
			{ 1, 0, 0 }
		}, 1));
	}

	private static final int[] DIRECTIONS = { 0, 1, 0, -1, 0 };

	public int shortestPath(int[][] grid, int k) {
		int rows = grid.length;
		int cols = grid[0].length;
		if (rows + cols - 3 <= k) {
			return rows + cols - 2;
		} else {
			boolean[][][] visited = new boolean[rows][cols][k + 1];
			Queue<int[]> queue = new LinkedList<>();
			queue.offer(new int[] { 0, 0, k, 0 });
			visited[0][0][k] = true;
			while (!queue.isEmpty()) {
				int[] curr = queue.poll();
				if (curr[0] == rows - 1 && curr[1] == cols - 1) {
					return curr[3];
				}
				for (int i = 0; i < 4; i++) {
					int nextRow = curr[0] + DIRECTIONS[i];
					int nextCol = curr[1] + DIRECTIONS[i + 1];
					if (0 <= nextRow && nextRow < rows && 0 <= nextCol && nextCol < cols) {
						int nextK = curr[2] - grid[nextRow][nextCol];
						if (0 <= nextK && !visited[nextRow][nextCol][nextK]) {
							visited[nextRow][nextCol][nextK] = true;
							queue.offer(new int[] { nextRow, nextCol, nextK, curr[3] + 1 });
						}
					}
				}
			}
			return -1;
		}
	}

}
