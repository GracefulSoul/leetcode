package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {

	// https://leetcode.com/problems/find-eventual-safe-states/submissions/877369039/
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
		int[] state = new int[length];
		for (int idx = 0; idx < length; idx++) {
			if (this.dfs(graph, state, idx)) {
				result.add(idx);
			}
		}
		return result;
	}

	private boolean dfs(int[][] graph, int[] state, int index) {
		if (state[index] != 0) {
			return state[index] == 1;
		} else {
			state[index] = 2;
			for (int node : graph[index]) {
				if (!this.dfs(graph, state, node)) {
					return false;
				}
			}
			state[index] = 1;
			return true;
		}
	}

}
