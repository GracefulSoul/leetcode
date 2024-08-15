package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {

	// https://leetcode.com/problems/as-far-from-land-as-possible/submissions/1356558984/
	public static void main(String[] args) {
		AsFarFromLandAsPossible test = new AsFarFromLandAsPossible();
		System.out.println(test.maxDistance(new int[][] {
			{ 1, 0, 1 },
			{ 0, 0, 0 },
			{ 1, 0, 1 }
		}));
		System.out.println(test.maxDistance(new int[][] {
			{ 1, 0, 0 },
			{ 0, 0, 0 },
			{ 0, 0, 0 }
		}));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ 0, -1 },
		{ 1, 0 },
		{ -1, 0 }
	};

	public int maxDistance(int[][] grid) {
		int length = grid.length;
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}
		int result = -1;
		if (!queue.isEmpty() && queue.size() != length * length) {
			while (!queue.isEmpty()) {
				int size = queue.size();
				result++;
				while (size-- > 0) {
					int[] point = queue.poll();
					int x = point[0];
					int y = point[1];
					for (int[] direction : DIRECTIONS) {
						int nx = x + direction[0];
						int ny = y + direction[1];
						if (nx >= 0 && nx < length && ny >= 0 && ny < length && grid[nx][ny] == 0) {
							grid[nx][ny] = 1;
							queue.offer(new int[] { nx, ny });
						}
					}
				}
			}
		}
		return result;
	}

}
