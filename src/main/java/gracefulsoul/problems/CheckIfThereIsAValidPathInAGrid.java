package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfThereIsAValidPathInAGrid {

	// https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/submissions/1989289585/
	public static void main(String[] args) {
		CheckIfThereIsAValidPathInAGrid test = new CheckIfThereIsAValidPathInAGrid();
		System.out.println(test.hasValidPath(new int[][] {
			{ 2, 4, 3 },
			{ 6, 5, 2 }
		}));
		System.out.println(test.hasValidPath(new int[][] {
			{ 1, 2, 1 },
			{ 1, 2, 1 }
		}));
		System.out.println(test.hasValidPath(new int[][] {
			{ 1, 1, 2 }
		}));
	}

	private static final int[][][] DIRS = {
		{
			{ 0, -1 }, { 0, 1 }
		}, {
			{ -1, 0 }, { 1, 0 }
		}, {
			{ 0, -1 }, { 1, 0 }
		}, {
			{ 0, 1 }, { 1, 0 }
		}, {
			{ 0, -1 }, { -1, 0 }
		}, {
			{ 0, 1 }, { -1, 0 }
		}
	};

	public boolean hasValidPath(int[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		visited[0][0] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int x = curr[0];
			int y = curr[1];
			int i = grid[x][y] - 1;
			for (int[] dir : DIRS[i]) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				if (nx < 0 || nx >= rows || ny < 0 || ny >= cols || visited[nx][ny]) {
					continue;
				}
				for (int[] backDir : DIRS[grid[nx][ny] - 1]) {
					if (nx + backDir[0] == x && ny + backDir[1] == y) {
						visited[nx][ny] = true;
						queue.add(new int[] { nx, ny });
					}
				}
			}
		}
		return visited[rows - 1][cols - 1];
	}

}
