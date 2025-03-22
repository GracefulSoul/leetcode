package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CountTheNumberOfCompleteComponents {

	// https://leetcode.com/problems/count-the-number-of-complete-components/submissions/1581913830/
	public static void main(String[] args) {
		CountTheNumberOfCompleteComponents test = new CountTheNumberOfCompleteComponents();
		System.out.println(test.countCompleteComponents(6, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 1, 2 },
			{ 3, 4 }
		}));
		System.out.println(test.countCompleteComponents(6, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 1, 2 },
			{ 3, 4 },
			{ 3, 5 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int countCompleteComponents(int n, int[][] edges) {
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		boolean[] visited = new boolean[n];
		int result = 0;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				Set<Integer> set = new HashSet<>();
				int count = this.dfs(graph, visited, set, i);
				if (set.size() == 1 && set.contains(count - 1)) {
					result++;
				}
			}
		}
		return result;
	}

	private int dfs(List<Integer>[] graph, boolean[] visited, Set<Integer> set, int index) {
		visited[index] = true;
		set.add(graph[index].size());
		int count = 1;
		for (int neighbor : graph[index]) {
			if (!visited[neighbor]) {
				count += this.dfs(graph, visited, set, neighbor);
			}
		}
		return count;
	}

}
