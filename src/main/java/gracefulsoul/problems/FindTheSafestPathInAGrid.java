package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class FindTheSafestPathInAGrid {

	// https://leetcode.com/problems/find-the-safest-path-in-a-grid/submissions/1258495000/
	public static void main(String[] args) {
		FindTheSafestPathInAGrid test = new FindTheSafestPathInAGrid();
		System.out.println(test.maximumSafenessFactor(Arrays.asList(
			Arrays.asList(1, 0, 0),
			Arrays.asList(0, 0, 0),
			Arrays.asList(0, 0, 1)
		)));
		System.out.println(test.maximumSafenessFactor(Arrays.asList(
			Arrays.asList(0, 0, 1),
			Arrays.asList(0, 0, 0),
			Arrays.asList(0, 0, 0)
		)));
		System.out.println(test.maximumSafenessFactor(Arrays.asList(
			Arrays.asList(0, 0, 0, 1),
			Arrays.asList(0, 0, 0, 0),
			Arrays.asList(0, 0, 0, 0),
			Arrays.asList(1, 0, 0, 0)
		)));
	}

	private static final int[][] DIRECTIONS = {
		{ -1, 0 },
		{ 1, 0 },
		{ 0, -1 },
		{ 0, 1 }
	};

	public int maximumSafenessFactor(List<List<Integer>> grid) {
		int row = grid.size();
		int col = grid.get(0).size();
		if (grid.get(0).get(0) == 1 || grid.get(row - 1).get(col - 1) == 1) {
			return 0;
		}
		int[][] safeness = new int[row][col];
		for (int[] rowArr : safeness) {
			Arrays.fill(rowArr, -1);
		}
		Deque<int[]> deque = new ArrayDeque<>();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid.get(i).get(j) == 1) {
					safeness[i][j] = 0;
					deque.offer(new int[] { 0, i, j });
				}
			}
		}
		while (!deque.isEmpty()) {
			int[] curr = deque.poll();
			int dis = curr[0];
			int i = curr[1];
			int j = curr[2];
			for (int[] direction : DIRECTIONS) {
				int r = i + direction[0];
				int c = j + direction[1];
				if (0 <= r && r < row && 0 <= c && c < col && safeness[r][c] == -1) {
					safeness[r][c] = dis + 1;
					deque.offer(new int[] { dis + 1, r, c });
				}
			}
		}
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		queue.offer(new int[] { safeness[0][0], 0, 0 });
		Set<String> seen = new HashSet<>();
		seen.add(0 + "," + 0);
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int dis = curr[0];
			int i = curr[1];
			int j = curr[2];
			if (i == row - 1 && j == col - 1) {
				return dis;
			}
			for (int[] direction : DIRECTIONS) {
				int r = i + direction[0];
				int c = j + direction[1];
				if (0 <= r && r < row && 0 <= c && c < col && !seen.contains(r + "," + c)) {
					int safe = Math.min(dis, safeness[r][c]);
					queue.offer(new int[] { safe, r, c });
					seen.add(r + "," + c);
				}
			}
		}
		return -1;
	}

}
