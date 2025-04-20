package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovesToMoveABoxToTheirTargetLocation {

	// https://leetcode.com/problems/minimum-moves-to-move-a-box-to-their-target-location/submissions/1612058184/
	public static void main(String[] args) {
		MinimumMovesToMoveABoxToTheirTargetLocation test = new MinimumMovesToMoveABoxToTheirTargetLocation();
		System.out.println(test.minPushBox(new char[][] {
			{ '#', '#', '#', '#', '#', '#' },
			{ '#', 'T', '#', '#', '#', '#' },
			{ '#', '.', '.', 'B', '.', '#' },
			{ '#', '.', '#', '#', '.', '#' },
			{ '#', '.', '.', '.', 'S', '#' },
			{ '#', '#', '#', '#', '#', '#' }
		}));
		System.out.println(test.minPushBox(new char[][] {
			{ '#', '#', '#', '#', '#', '#' },
			{ '#', 'T', '#', '#', '#', '#' },
			{ '#', '.', '.', 'B', '.', '#' },
			{ '#', '#', '#', '#', '.', '#' },
			{ '#', '.', '.', '.', 'S', '#' },
			{ '#', '#', '#', '#', '#', '#' }
		}));
		System.out.println(test.minPushBox(new char[][] {
			{ '#', '#', '#', '#', '#', '#' },
			{ '#', 'T', '.', '.', '#', '#' },
			{ '#', '.', '#', 'B', '.', '#' },
			{ '#', '.', '.', '.', '.', '#' },
			{ '#', '.', '.', '.', 'S', '#' },
			{ '#', '#', '#', '#', '#', '#' }
		}));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ 0, -1 },
		{ 0, 1 },
		{ -1, 0 },
		{ 1, 0 }
	};

	public int minPushBox(char[][] grid) {
		int rows = grid.length;
		int cols = grid[0].length;
		Queue<int[]> queue = new LinkedList<>();
		boolean[][][] visited = new boolean[rows][cols][4];
		int[] box = new int[2];
		int[] target = new int[2];
		int[] player = new int[2];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				switch (grid[i][j]) {
					case 'B': box = new int[] { i, j }; break;
					case 'T': target = new int[] { i, j }; break;
					case 'S': player = new int[] { i, j }; break;
					default: break;
				}
			}
		}
		queue.offer(new int[] { player[0], player[1], box[0], box[1], 0 });
		while (!queue.isEmpty()) {
			int[] state = queue.poll();
			int px = state[0];
			int py = state[1];
			int bx = state[2];
			int by = state[3];
			int pushes = state[4];
			if (bx == target[0] && by == target[1]) {
				return pushes;
			}
			for (int i = 0; i < 4; i++) {
				int[] direction = DIRECTIONS[i];
				int nx = bx + direction[0];
				int ny = by + direction[1];
				int npx = bx - direction[0];
				int npy = by - direction[1];
				if (nx < 0 || rows <= nx || ny < 0 || cols <= ny || grid[nx][ny] == '#' ||
						npx < 0 || rows <= npx || npy < 0 || cols <= npy || grid[npx][npy] == '#') {
					continue;
				}

				if (!visited[bx][by][i] && this.canReach(grid, rows, cols, px, py, npx, npy, bx, by)) {
					visited[bx][by][i] = true;
					queue.offer(new int[] { bx, by, nx, ny, pushes + 1 });
				}
			}
		}
		return -1;
	}

	private boolean canReach(char[][] grid, int rows, int cols, int px, int py, int npx, int npy, int bx, int by) {
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[rows][cols];
		queue.offer(new int[] { px, py });
		visited[px][py] = true;
		while (!queue.isEmpty()) {
			int[] pos = queue.poll();
			int x = pos[0];
			int y = pos[1];
			if (x == npx && y == npy) {
				return true;
			}
			for (int[] dir : new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } }) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				if (0 <= nx && nx < rows && 0 <= ny && ny < cols && !visited[nx][ny] && grid[nx][ny] != '#' && (nx != bx || ny != by)) {
					visited[nx][ny] = true;
					queue.offer(new int[] { nx, ny });
				}
			}
		}
		return false;
	}

}
