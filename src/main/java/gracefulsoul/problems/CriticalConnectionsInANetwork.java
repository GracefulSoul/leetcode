package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {

	// https://leetcode.com/problems/critical-connections-in-a-network/submissions/1399508008/
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
		this.criticalConnections(results, graph, -1, 0, new boolean[n], new int[n], 0);
		return results;
	}

	private void criticalConnections(List<List<Integer>> results, List<Integer>[] graph, int parent, int node, boolean[] visited, int[] times, int time) {
		visited[node] = true;
		times[node] = time++;
		int current = times[node];
		for (int neighbour : graph[node]) {
			if (neighbour == parent) {
				continue;
			}
			if (!visited[neighbour]) {
				this.criticalConnections(results, graph, node, neighbour, visited, times, time);
			}
			times[node] = Math.min(times[node], times[neighbour]);
			if (current < times[neighbour]) {
				results.add(Arrays.asList(node, neighbour));
			}
		}
	}

}
