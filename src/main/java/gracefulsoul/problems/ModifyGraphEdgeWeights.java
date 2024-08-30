package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.util.PrintUtil;

public class ModifyGraphEdgeWeights {

	// https://leetcode.com/problems/modify-graph-edge-weights/submissions/1373045421/
	public static void main(String[] args) {
		ModifyGraphEdgeWeights test = new ModifyGraphEdgeWeights();
		PrintUtil.print(test.modifiedGraphEdges(5, new int[][] {
			{ 4, 1, -1 },
			{ 2, 0, -1 },
			{ 0, 3, -1 },
			{ 4, 3, -1 }
		}, 0, 1, 5));
		PrintUtil.print(test.modifiedGraphEdges(5, new int[][] {
			{ 0, 1, -1 },
			{ 0, 2, 5 }
		}, 0, 2, 6));
		PrintUtil.print(test.modifiedGraphEdges(5, new int[][] {
			{ 1, 0, 4 },
			{ 1, 2, 3 },
			{ 2, 3, 5 },
			{ 0, 3, -1 }
		}, 0, 2, 6));
	}

	@SuppressWarnings("unchecked")
	public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
		List<int[]>[] adjacencyList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjacencyList[i] = new ArrayList<>();
		}
		for (int i = 0; i < edges.length; i++) {
			int a = edges[i][0];
			int b = edges[i][1];
			adjacencyList[a].add(new int[] { b, i });
			adjacencyList[b].add(new int[] { a, i });
		}
		int[][] distances = new int[n][2];
		Arrays.fill(distances[source], 0);
		for (int i = 0; i < n; i++) {
			if (i != source) {
				distances[i][0] = distances[i][1] = Integer.MAX_VALUE;
			}
		}
		this.dijkstra(adjacencyList, edges, distances, source, 0, 0);
		int difference = target - distances[destination][0];
		if (difference < 0) {
			return new int[][] {};
		}
		this.dijkstra(adjacencyList, edges, distances, source, difference, 1);
		if (distances[destination][1] < target) {
			return new int[][] {};
		}
		for (int[] edge : edges) {
			if (edge[2] == -1) {
				edge[2] = 1;
			}
		}
		return edges;
	}

	private void dijkstra(List<int[]>[] adjacencyList, int[][] edges, int[][] distances, int source, int difference, int run) {
		Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
		queue.add(new int[] { source, 0 });
		distances[source][run] = 0;
		while (!queue.isEmpty()) {
			int[] current = queue.poll();
			int node = current[0];
			if (current[1] > distances[node][run]) {
				continue;
			}
			for (int[] neighbor : adjacencyList[node]) {
				int next = neighbor[0];
				int index = neighbor[1];
				int weight = edges[index][2];
				if (weight == -1) {
					weight = 1;
				}
				if (run == 1 && edges[index][2] == -1) {
					int newWeight = difference + distances[next][0] - distances[node][1];
					if (newWeight > weight) {
						edges[index][2] = weight = newWeight;
					}
				}
				if (distances[next][run] > distances[node][run] + weight) {
					distances[next][run] = distances[node][run] + weight;
					queue.add(new int[] { next, distances[next][run] });
				}
			}
		}
	}

}
