package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumObstacleRemovalToReachCorner {

	// https://leetcode.com/problems/minimum-obstacle-removal-to-reach-corner/submissions/1464941594/
	public static void main(String[] args) {
		MinimumObstacleRemovalToReachCorner test = new MinimumObstacleRemovalToReachCorner();
		System.out.println(test.minimumObstacles(new int[][] {
			{ 0, 1, 1 },
			{ 1, 1, 0 },
			{ 1, 1, 0 }
		}));
		System.out.println(test.minimumObstacles(new int[][] {
			{ 0, 1, 0, 0, 0 },
			{ 0, 1, 0, 1, 0 },
			{ 0, 0, 0, 1, 0 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ 1, 0 },
		{ 0, -1 },
		{ -1, 0 }
	};

	public int minimumObstacles(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		Deque<int[]> deque = new ArrayDeque<>();
		deque.add(new int[] { 0, 0, 0 });
		grid[0][0] = -1;
		while (!deque.isEmpty()) {
			int[] curr = deque.pollFirst();
			int x = curr[0];
			int c = curr[1];
			int obstacle = curr[2];
			if (x == row - 1 && c == col - 1) {
				return obstacle;
			}
			for (int[] direction : DIRECTIONS) {
				int dx = x + direction[0];
				int dy = c + direction[1];
				if (0 <= dx && dx < row && 0 <= dy && dy < col && grid[dx][dy] != -1) {
					if (grid[dx][dy] == 0) {
						deque.addFirst(new int[] { dx, dy, obstacle });
					} else {
						deque.addLast(new int[] { dx, dy, obstacle + 1 });
					}
					grid[dx][dy] = -1;
				}
			}
		}
		return -1;
	}

}
