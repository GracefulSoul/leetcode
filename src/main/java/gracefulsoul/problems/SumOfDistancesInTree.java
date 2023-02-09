package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class SumOfDistancesInTree {

	// https://leetcode.com/problems/sum-of-distances-in-tree/submissions/894666182/
	public static void main(String[] args) {
		SumOfDistancesInTree test = new SumOfDistancesInTree();
		System.out.println(test.sumOfDistancesInTree(6, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 2, 3 },
			{ 2, 4 },
			{ 2, 5 }
		}));
		System.out.println(test.sumOfDistancesInTree(1, new int[][] {
		}));
		System.out.println(test.sumOfDistancesInTree(2, new int[][] {
			{ 1, 0 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int[] sumOfDistancesInTree(int n, int[][] edges) {
		ArrayList<Integer>[] graph = new ArrayList[n];
		int[] count = new int[n];
		Arrays.fill(count, 1);
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);

		}
		this.postOrderDFS(graph, count, result, 0, -1);
		this.preOrderDFS(graph, n, count, result, 0, -1);
		return result;

	}

	private void postOrderDFS(ArrayList<Integer>[] graph, int[] count, int[] result, int a, int parent) {
		for (int b : graph[a]) {
			if (b != parent) {
				this.postOrderDFS(graph, count, result, b, a);
				count[a] += count[b];
				result[a] += result[b] + count[b];
			}
		}
	}

	private void preOrderDFS(ArrayList<Integer>[] graph, int n, int[] count, int[] result, int a, int parent) {
		for (int b : graph[a]) {
			if (b != parent) {
				result[b] = result[a] + (n - count[b]) - count[b];
				this.preOrderDFS(graph, n, count, result, b, a);
			}
		}
	}

}
