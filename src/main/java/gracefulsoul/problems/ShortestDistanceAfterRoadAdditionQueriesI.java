package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class ShortestDistanceAfterRoadAdditionQueriesI {

	// https://leetcode.com/problems/shortest-distance-after-road-addition-queries-i/submissions/1464127965/
	public static void main(String[] args) {
		ShortestDistanceAfterRoadAdditionQueriesI test = new ShortestDistanceAfterRoadAdditionQueriesI();
		PrintUtil.print(test.shortestDistanceAfterQueries(5, new int[][] {
			{ 2, 4 },
			{ 0, 2 },
			{ 0, 4 }
		}));
		PrintUtil.print(test.shortestDistanceAfterQueries(4, new int[][] {
			{ 0, 3 },
			{ 0, 2 }
		}));
	}

	public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
			list.get(i).add(i + 1);
		}
		int length = queries.length;
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			int[] query = queries[i];
			list.get(query[0]).add(query[1]);
			result[i] = this.getShortestDistance(list, n);
		}
		return result;
	}

	private int getShortestDistance(List<List<Integer>> list, int n) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });
		boolean[] visited = new boolean[n];
		visited[0] = true;
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (curr[0] == n - 1) {
				return curr[1];
			}
			for (int neighbor : list.get(curr[0])) {
				if (!visited[neighbor]) {
					queue.offer(new int[] { neighbor, curr[1] + 1 });
					visited[neighbor] = true;
				}
			}
		}
		return -1;
	}

}
