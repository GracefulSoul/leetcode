package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMovesToReachTargetWithRotations {

	// https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/submissions/1462330578/
	public static void main(String[] args) {
		MinimumMovesToReachTargetWithRotations test = new MinimumMovesToReachTargetWithRotations();
		System.out.println(test.minimumMoves(new int[][] {
			{ 0, 0, 0, 0, 0, 1 },
			{ 1, 1, 0, 0, 1, 0 },
			{ 0, 0, 0, 0, 1, 1 },
			{ 0, 0, 1, 0, 1, 0 },
			{ 0, 1, 1, 0, 0, 0 },
			{ 0, 1, 1, 0, 0, 0 }
		}));
		System.out.println(test.minimumMoves(new int[][] {
			{ 0, 0, 1, 1, 0, 1 },
			{ 0, 0, 0, 0, 1, 1 },
			{ 1, 1, 0, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 1 },
			{ 1, 1, 1, 0, 0, 0 }
		}));
	}

    private static final int[][] DIRECTIONS = {
		{1, 0, 0},
		{0, 1, 0},
		{0, 0, 1}
	};

	public int minimumMoves(int[][] grid) {
		int length = grid.length;
		boolean[][][] visited = new boolean[length][length][2];
		Queue<int[]> queue = new LinkedList<>();
		visited[0][0][0] = true;
		queue.offer(new int[] { 0, 0, 0 });
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			result++;
			while (size-- > 0) {
				int[] curr = queue.poll();
				for (int[] direction : DIRECTIONS) {
					int x = curr[0] + direction[0];
					int y = curr[1] + direction[1];
					int s = curr[2] ^ direction[2];
					int x2 = x + s;
					int y2 = y + (1 - s);
					if (x2 < length && y2 < length && !visited[x][y][s] && grid[x][y] == 0 && grid[x2][y2] == 0 && (direction[2] == 0 || grid[x + 1][y + 1] == 0)) {
						if (x == length - 1 && y == length - 2) {
							return result;
						}
						visited[x][y][s] = true;
						queue.offer(new int[] { x, y, s });
					}
				}
			}
		}
		return -1;
	}

}
