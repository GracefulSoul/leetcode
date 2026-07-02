package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class FindASafeWalkThroughAGrid {

	// https://leetcode.com/problems/find-a-safe-walk-through-a-grid/submissions/2053429406/
	public static void main(String[] args) {
		FindASafeWalkThroughAGrid test = new FindASafeWalkThroughAGrid();
		System.out.println(test.findSafeWalk(Arrays.asList(
			Arrays.asList(0, 1, 0, 0, 0),
			Arrays.asList(0, 1, 0, 1, 0),
			Arrays.asList(0, 0, 0, 1, 0)
		), 3));
		System.out.println(test.findSafeWalk(Arrays.asList(
			Arrays.asList(0, 1, 1, 0, 0, 0),
			Arrays.asList(1, 0, 1, 0, 0, 0),
			Arrays.asList(0, 1, 1, 1, 0, 1),
			Arrays.asList(0, 0, 1, 0, 1, 0)
		), 3));
		System.out.println(test.findSafeWalk(Arrays.asList(
			Arrays.asList(1, 1, 1),
			Arrays.asList(1, 0, 1),
			Arrays.asList(1, 1, 1)
		), 5));
	}

	private static final int[][] DIRECTIONS = new int[][] {
		{ -1, 0 },
		{ 1, 0 },
		{ 0, -1 },
		{ 0, 1 }
	};

	public boolean findSafeWalk(List<List<Integer>> grid, int health) {
		int rows = grid.size();
		int cols = grid.get(0).size();
		int[][] dist = new int[rows][cols];
		for (int[] row : dist) {
			Arrays.fill(row, Integer.MAX_VALUE);
		}
		Deque<int[]> deque = new ArrayDeque<>();
		dist[0][0] = grid.get(0).get(0);
		deque.offerFirst(new int[] { 0, 0 });
		while (!deque.isEmpty()) {
			int[] curr = deque.pollFirst();
			int x = curr[0];
			int y = curr[1];
			if (x == rows - 1 && y == cols - 1) {
				return dist[x][y] < health;
			}
			for (int[] direction : DIRECTIONS) {
				int nx = x + direction[0];
				int ny = y + direction[1];
				if (nx < 0 || rows <= nx || ny < 0 || cols <= ny) {
					continue;
				}
				int num = grid.get(nx).get(ny);
				if (dist[x][y] + num < dist[nx][ny]) {
					dist[nx][ny] = dist[x][y] + num;
					if (num == 0) {
						deque.offerFirst(new int[] { nx, ny });
					} else {
						deque.offerLast(new int[] { nx, ny });
					}
				}
			}
		}
		return dist[rows - 1][cols - 1] < health;
	}

}
