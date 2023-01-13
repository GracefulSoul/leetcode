package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

	// https://leetcode.com/problems/find-eventual-safe-states/submissions/877367519/
	public static void main(String[] args) {
		FindEventualSafeStates test = new FindEventualSafeStates();
		System.out.println(test.eventualSafeNodes(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 5 },
			{ 0 },
			{ 5 },
			{},
			{}
		}));
		System.out.println(test.eventualSafeNodes(new int[][] {
			{ 1, 2, 3, 4 },
			{ 1, 2 },
			{ 3, 4 },
			{ 0, 4 },
			{}
		}));
	}

	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> result = new ArrayList<>();
		int length = graph.length;
		int[] color = new int[length];
		for (int idx = 0; idx < length; idx++) {
			if (this.dfs(graph, idx, color)) {
				result.add(idx);
			}
		}
		return result;
	}

	private boolean dfs(int[][] graph, int start, int[] color) {
		if (color[start] != 0) {
			return color[start] == 1;
		} else {
			color[start] = 2;
			for (int node : graph[start]) {
				if (!this.dfs(graph, node, color)) {
					return false;
				}
			}
			color[start] = 1;
			return true;
		}
	}

}
