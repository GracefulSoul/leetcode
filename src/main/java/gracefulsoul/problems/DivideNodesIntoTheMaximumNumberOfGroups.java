package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DivideNodesIntoTheMaximumNumberOfGroups {

	// https://leetcode.com/problems/divide-nodes-into-the-maximum-number-of-groups/submissions/1524923857/
	public static void main(String[] args) {
		DivideNodesIntoTheMaximumNumberOfGroups test = new DivideNodesIntoTheMaximumNumberOfGroups();
		System.out.println(test.magnificentSets(6, new int[][] {
			{ 1, 2 },
			{ 1, 4 },
			{ 1, 5 },
			{ 2, 6 },
			{ 2, 3 },
			{ 4, 6 }
		}));
		System.out.println(test.magnificentSets(3, new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 1 }
		}));
	}

	public int magnificentSets(int n, int[][] edges) {
		List<List<Integer>> list = new ArrayList<>();
		n++;
		for (int i = 0; i < n; i++) {
			list.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		if (!this.isBipartite(list, n)) {
			return -1;
		}
		int[] degree = new int[n];
		for (int i = 1; i < n; i++) {
			degree[i] = this.bfsDegree(list, i);
		}
		int[] visited = new int[n];
		int result = 0;
		for (int i = 1; i < n; i++) {
			if (visited[i] == 0) {
				result += this.dfs(list, visited, degree, i);
			}
		}
		return result;
	}

	private int dfs(List<List<Integer>> list, int[] visited, int[] degree, int vertex) {
		visited[vertex] = 1;
		int max = degree[vertex];
		for (int ver : list.get(vertex)) {
			if (visited[ver] == 0) {
				max = Math.max(max, this.dfs(list, visited, degree, ver));
			}
		}
		return max;
	}

	private int bfsDegree(List<List<Integer>> list, int vertex) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { vertex, 1 });
		int[] visited = new int[list.size()];
		visited[vertex] = 1;
		int[] curr = new int[2];
		while (!queue.isEmpty()) {
			curr = queue.poll();
			for (int ver : list.get(curr[0])) {
				if (visited[ver] == 0) {
					visited[ver] = 1;
					queue.add(new int[] { ver, curr[1] + 1 });
				}
			}
		}
		return curr[1];
	}

	private boolean isBipartite(List<List<Integer>> list, int n) {
		int[] colors = new int[n];
		for (int i = 0; i < n; i++) {
			if (colors[i] == 0 && !this.bfs(list, colors, i)) {
				return false;
			}
		}
		return true;
	}

	private boolean bfs(List<List<Integer>> adj, int[] colors, int vertex) {
		colors[vertex] = 1;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			int color = colors[curr] == 1 ? 2 : 1;
			for (int ver : adj.get(curr)) {
				if (colors[ver] == 0) {
					colors[ver] = color;
					queue.add(ver);
				} else if (colors[ver] != color) {
					return false;
				}
			}
		}
		return true;
	}

}
