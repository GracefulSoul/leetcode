package gracefulsoul.problems;

import java.util.Arrays;

public class NetworkDelayTime {

	// https://leetcode.com/submissions/detail/852043613/
	public static void main(String[] args) {
		NetworkDelayTime test = new NetworkDelayTime();
		System.out.println(test.networkDelayTime(new int[][] {
			{ 2, 1, 1 },
			{ 2, 3, 1 },
			{ 3, 4, 1 }
		}, 4, 2));
		System.out.println(test.networkDelayTime(new int[][] {
			{ 1, 2, 1 }
		}, 2, 1));
		System.out.println(test.networkDelayTime(new int[][] {
			{ 1, 2, 1 }
		}, 2, 2));
	}

	public int networkDelayTime(int[][] times, int n, int k) {
		int[][] graph = new int[n][n];
		for (int i = 0; i < n; i++) {
			Arrays.fill(graph[i], Integer.MAX_VALUE);
		}
		for (int[] time : times) {
			graph[time[0] - 1][time[1] - 1] = time[2];
		}
		int[] distances = new int[n];
		Arrays.fill(distances, Integer.MAX_VALUE);
		distances[k - 1] = 0;
		boolean[] visited = new boolean[n];
		for (int i = 0; i < n; i++) {
			int index = this.findMinimumIndex(distances, visited);
			if (index == -1) {
				continue;
			}
			visited[index] = true;
			for (int j = 0; j < n; j++) {
				if (graph[index][j] != Integer.MAX_VALUE) {
					int distance = graph[index][j] + distances[index];
					if (distance < distances[j]) {
						distances[j] = distance;
					}
				}
			}
		}
		int result = 0;
		for (int distance : distances) {
			if (distance == Integer.MAX_VALUE) {
				return -1;
			}
			result = Math.max(result, distance);
		}
		return result;
	}

	private int findMinimumIndex(int[] distances, boolean[] visited) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int idx = 0; idx < distances.length; idx++) {
			if (!visited[idx] && distances[idx] < min) {
				min = distances[idx];
				index = idx;
			}
		}
		return index;
	}

}
