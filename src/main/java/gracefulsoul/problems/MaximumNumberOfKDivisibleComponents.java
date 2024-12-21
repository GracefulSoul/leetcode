package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumNumberOfKDivisibleComponents {

	// https://leetcode.com/problems/maximum-number-of-k-divisible-components/submissions/1484413984/
	public static void main(String[] args) {
		MaximumNumberOfKDivisibleComponents test = new MaximumNumberOfKDivisibleComponents();
		System.out.println(test.maxKDivisibleComponents(5, new int[][] {
			{ 0, 2 },
			{ 1, 2 },
			{ 1, 3 },
			{ 2, 4 }
		}, new int[] { 1, 8, 1, 4, 4 }, 6));
		System.out.println(test.maxKDivisibleComponents(5, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 1, 3 },
			{ 1, 4 },
			{ 2, 5 },
			{ 2, 6 }
		}, new int[] { 3, 0, 6, 1, 5, 2, 1 }, 3));
	}

	public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
		if (n == 1) {
			return 1;
		}
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		int[] degree = new int[n];
		for (int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			graph.get(edge[1]).add(edge[0]);
			degree[edge[0]]++;
			degree[edge[1]]++;
		}
		long[] longValues = new long[n];
		for (int i = 0; i < n; i++) {
			longValues[i] = values[i];
		}
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (degree[i] == 1) {
				queue.add(i);
			}
		}
		int result = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			degree[curr]--;
			long carry = 0;
			if (longValues[curr] % k == 0) {
				result++;
			} else {
				carry = longValues[curr];
			}
			for (int neighbor : graph.get(curr)) {
				if (degree[neighbor] == 0) {
					continue;
				}
				degree[neighbor]--;
				longValues[neighbor] += carry;
				if (degree[neighbor] == 1) {
					queue.add(neighbor);
				}
			}
		}
		return result;
	}

}
