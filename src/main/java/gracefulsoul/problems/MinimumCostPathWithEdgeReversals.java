package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumCostPathWithEdgeReversals {

	// https://leetcode.com/problems/minimum-cost-path-with-edge-reversals/submissions/1898410405/
	public static void main(String[] args) {
		MinimumCostPathWithEdgeReversals test = new MinimumCostPathWithEdgeReversals();
		System.out.println(test.minCost(4, new int[][] {
			{ 0, 1, 3 },
			{ 3, 1, 1 },
			{ 2, 3, 4 },
			{ 0, 2, 2 }
		}));
		System.out.println(test.minCost(4, new int[][] {
			{ 0, 2, 1 },
			{ 2, 1, 1 },
			{ 1, 3, 1 },
			{ 2, 3, 3 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int minCost(int n, int[][] edges) {
		List<int[]>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			int w = edge[2];
			graph[u].add(new int[] { v, w });
			graph[v].add(new int[] { u, 2 * w });
		}
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[0] = 0;
		PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
		queue.offer(new int[] { 0, 0 });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int u = curr[0];
			int distance = curr[1];
			if (u == n - 1) {
				return distance;
			}
			if (distance > distances[u]) {
				continue;
			}
			for (int edge[] : graph[u]) {
				int v = edge[0];
				int cost = edge[1];
				if (distance + cost < distances[v]) {
					distances[v] = distance + cost;
					queue.offer(new int[] { v, distances[v] });
				}
			}
		}
		return distances[n - 1] == Integer.MAX_VALUE ? -1 : distances[n - 1];
	}

}
