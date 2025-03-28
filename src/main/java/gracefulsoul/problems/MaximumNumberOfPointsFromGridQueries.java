package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class MaximumNumberOfPointsFromGridQueries {

	public static void main(String[] args) {
		MaximumNumberOfPointsFromGridQueries test = new MaximumNumberOfPointsFromGridQueries();
		PrintUtil.print(test.maxPoints(new int[][] {
			{ 1, 2, 3 },
			{ 2, 5, 7 },
			{ 3, 5, 1 }
		}, new int[] { 5, 6, 2}));
		PrintUtil.print(test.maxPoints(new int[][] {
			{ 5, 2, 1 },
			{ 1, 1, 2 }
		}, new int[] { 3}));
	}

	private static final int[][] DIRECTIONS = {
		{ 0, 1 },
		{ 1, 0 },
		{ 0, -1 },
		{ -1, 0 }
	};

	public int[] maxPoints(int[][] grid, int[] queries) {
		int rows = grid.length;
		int cols = grid[0].length;
		int length = queries.length;
		int[] result = new int[length];
		int[][] visited = new int[rows][cols];
		Queue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
		List<int[]> queryList = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			queryList.add(new int[] { queries[i], i });
		}
		queryList.sort(Comparator.comparingInt(a -> a[0]));
		minHeap.offer(new int[] { grid[0][0], 0, 0 });
		visited[0][0] = 1;
		int points = 0;
		for (int[] query : queryList) {
			while (!minHeap.isEmpty() && minHeap.peek()[0] < query[0]) {
				int[] top = minHeap.poll();
				int row = top[1], col = top[2];
				points++;
				for (int[] direction : DIRECTIONS) {
					int nr = row + direction[0];
					int nc = col + direction[1];
					if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && visited[nr][nc] == 0) {
						minHeap.offer(new int[] { grid[nr][nc], nr, nc });
						visited[nr][nc] = 1;
					}
				}
			}
			result[query[1]] = points;
		}
		return result;
	}

}
