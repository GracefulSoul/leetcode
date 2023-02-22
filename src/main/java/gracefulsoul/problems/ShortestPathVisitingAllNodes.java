package gracefulsoul.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathVisitingAllNodes {

	// https://leetcode.com/problems/shortest-path-visiting-all-nodes/submissions/902189912/
	public static void main(String[] args) {
		ShortestPathVisitingAllNodes test = new ShortestPathVisitingAllNodes();
		System.out.println(test.shortestPathLength(new int[][] {
			{ 1, 2, 3 },
			{ 0 },
			{ 0 },
			{ 0 }
		}));
		System.out.println(test.shortestPathLength(new int[][] {
			{ 1 },
			{ 0, 2, 4 },
			{ 1, 3, 4 },
			{ 2 },
			{ 1, 2 }
		}));
	}

	public int shortestPathLength(int[][] graph) {
		int length = graph.length;
		int[][] dp = new int[length][1 << length];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
			dp[i][1 << i] = 0;
			queue.offer(new int[] { i, 1 << i });
		}
		while (!queue.isEmpty()) {
			int[] state = queue.poll();
			for (int next : graph[state[0]]) {
				int val = state[1] | (1 << next);
				if (dp[next][val] > dp[state[0]][state[1]] + 1) {
					dp[next][val] = dp[state[0]][state[1]] + 1;
					queue.add(new int[] { next, val });
				}
			}
		}
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < length; i++) {
			result = Math.min(result, dp[i][(1 << length) - 1]);
		}
		return result;
	}

}
