package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class MostProfitablePathInATree {

	// https://leetcode.com/problems/most-profitable-path-in-a-tree/submissions/1553411891/
	public static void main(String[] args) {
		MostProfitablePathInATree test = new MostProfitablePathInATree();
		System.out.println(test.mostProfitablePath(new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 1, 3 },
			{ 3, 4 }
		}, 3, new int[] { -2, 4, 2, -4, 6 }));
		System.out.println(test.mostProfitablePath(new int[][] {
			{ 0, 1 }
		}, 1, new int[] { -7280, 2350 }));
	}

	@SuppressWarnings("unchecked")
	public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
		int length = amount.length;
		List<Integer>[] graph = new ArrayList[length];
		for (int i = 0; i < length; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		return this.dfs(graph, 0, bob, amount, new boolean[length], 1)[0];
	}

	private int[] dfs(List<Integer>[] graph, int node, int bob, int[] amount, boolean[] seen, int height) {
		int result = Integer.MIN_VALUE;
		seen[node] = true;
		int length = node == bob ? 1 : 0;
		for (int next : graph[node]) {
			if (seen[next]) {
				continue;
			}
			int[] temp = this.dfs(graph, next, bob, amount, seen, height + 1);
			if (temp[1] > 0) {
				length = temp[1] + 1;
			}
			result = Math.max(result, temp[0]);
		}
		if (length > 0 && length <= height) {
			if (length == height) {
				amount[node] = amount[node] / 2;
			} else {
				amount[node] = 0;
			}
		}
		return new int[] { result == Integer.MIN_VALUE ? amount[node] : amount[node] + result, length };
	}

}
