package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {

	// https://leetcode.com/problems/critical-connections-in-a-network/submissions/1399525950/
	public static void main(String[] args) {
		CriticalConnectionsInANetwork test = new CriticalConnectionsInANetwork();
		System.out.println(test.criticalConnections(4,Arrays.asList(
			Arrays.asList(0, 1),
			Arrays.asList(1, 2),
			Arrays.asList(2, 0),
			Arrays.asList(1, 3)
		)));
		System.out.println(test.criticalConnections(2, Arrays.asList(
			Arrays.asList(0, 1)
		)));
	}

	@SuppressWarnings("unchecked")
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (List<Integer> connection : connections) {
			graph[connection.get(0)].add(connection.get(1));
			graph[connection.get(1)].add(connection.get(0));
		}
		List<List<Integer>> results = new ArrayList<>();
		this.dfs(results, graph, 0, 0, new int[n], 1);
		return results;
	}

	private void dfs(List<List<Integer>> results, List<Integer>[] graph, int parent, int node, int[] times, int time) {
		times[node] = time;
		for (int neighbor : graph[node]) {
			if (neighbor == parent) {
				continue;
			}
			if (times[neighbor] == 0) {
				this.dfs(results, graph, node, neighbor, times, time + 1);
			}
			times[node] = Math.min(times[node], times[neighbor]);
			if (times[neighbor] > time) {
				results.add(Arrays.asList(node, neighbor));
			}
		}
	}

}
