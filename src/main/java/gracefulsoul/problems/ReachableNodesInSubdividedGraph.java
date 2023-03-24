package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReachableNodesInSubdividedGraph {

	// https://leetcode.com/problems/reachable-nodes-in-subdivided-graph/submissions/921250068/
	public static void main(String[] args) {
		ReachableNodesInSubdividedGraph test = new ReachableNodesInSubdividedGraph();
		System.out.println(test.reachableNodes(new int[][] {
			{ 0, 1, 10 },
			{ 0, 2, 1 },
			{ 1, 2, 2 }
		}, 6, 3));
		System.out.println(test.reachableNodes(new int[][] {
			{ 0, 1, 4 },
			{ 1, 2, 6 },
			{ 0, 2, 8 },
			{ 1, 3, 1 }
		}, 10, 4));
		System.out.println(test.reachableNodes(new int[][] {
			{ 1, 2, 4 },
			{ 1, 4, 5 },
			{ 1, 3, 1 },
			{ 2, 3, 4 },
			{ 3, 4, 5 }
		}, 17, 5));
	}

	public int reachableNodes(int[][] edges, int maxMoves, int n) {
		Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashMap<>());
		}
		for (int[] edge : edges) {
			map.get(edge[0]).put(edge[1], edge[2]);
			map.get(edge[1]).put(edge[0], edge[2]);
		}
		Queue<int[]> queue = new PriorityQueue<>((a, b) -> (b[0] - a[0]));
		queue.offer(new int[] { maxMoves, 0 });
		Map<Integer, Integer> visited = new HashMap<>();
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			if (!visited.containsKey(curr[1])) {
				visited.put(curr[1], curr[0]);
				for (int j : map.get(curr[1]).keySet()) {
					int next = curr[0] - map.get(curr[1]).get(j) - 1;
					if (!visited.containsKey(j) && next >= 0) {
						queue.offer(new int[] { next, j });
					}
				}
			}
		}
		int result = visited.size();
		for (int[] edge : edges) {
			result += Math.min(visited.getOrDefault(edge[0], 0) + visited.getOrDefault(edge[1], 0), edge[2]);
		}
		return result;
	}

}
