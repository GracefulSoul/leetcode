package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInBinaryMatrix {

	// https://leetcode.com/problems/shortest-path-in-binary-matrix/submissions/961564900/
	public static void main(String[] args) {
		ShortestPathInBinaryMatrix test = new ShortestPathInBinaryMatrix();
		System.out.println(test.shortestPathBinaryMatrix(new int[][] {
			{ 0, 1 },
			{ 1, 0 }
		}));
		System.out.println(test.shortestPathBinaryMatrix(new int[][] {
			{ 0, 0, 0 },
			{ 1, 1, 0 },
			{ 1, 1, 0 }
		}));
		System.out.println(test.shortestPathBinaryMatrix(new int[][] {
			{ 1, 0, 0 },
			{ 1, 1, 0 },
			{ 1, 1, 0 }
		}));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ 0, 1 },
		{ 1, 0 },
		{ -1, 0 },
		{ 0, -1 },
		{ 1, 1 },
		{ -1, 1 },
		{ 1, -1 },
		{ -1, -1 }
	};

	public int shortestPathBinaryMatrix(int[][] grid) {
		if (grid[0][0] == 0) {
			int length = grid.length;
			Queue<int[]> queue = new LinkedList<>();
			queue.add(new int[] { 0, 0, 0 });
			while (!queue.isEmpty()) {
				int[] curr = queue.poll();
				if (curr[0] == length - 1 && curr[1] == length - 1) {
					return curr[2] + 1;
				}
				for (int[] direction : DIRECTIONS) {
					int x = curr[0] + direction[0];
					int y = curr[1] + direction[1];
					if (x >= 0 && y >= 0 && x < length && y < length && grid[x][y] == 0) {
						grid[x][y] = -1;
						queue.add(new int[] { x, y, curr[2] + 1 });
					}
				}
			}
		}
		return -1;
	}
    
}
