package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class MinimumHeightTrees {

	// https://leetcode.com/submissions/detail/604860103/
	public static void main(String[] args) {
		MinimumHeightTrees test = new MinimumHeightTrees();
		System.out.println(test.findMinHeightTrees(4, new int[][] {
			new int[] { 1, 0 },
			new int[] { 1, 2 },
			new int[] { 1, 3 }
		}));
		System.out.println(test.findMinHeightTrees(6, new int[][] {
			new int[] { 3, 0 },
			new int[] { 3, 1 },
			new int[] { 3, 2 },
			new int[] { 3, 4 },
			new int[] { 5, 4 }
		}));
	}

	@SuppressWarnings("unchecked")
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if (n == 1) {
			result.add(0);
			return result;
		} else if (n == 2) {
			result.add(0);
			result.add(1);
			return result;
		}
		List<Integer>[] graph = new ArrayList[n];
		int[] degree = new int[n];
		for (int idx = 0; idx < n; idx++) {
			graph[idx] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			int v1 = edge[0];
			int v2 = edge[1];
			degree[v1]++;
			degree[v2]++;
			graph[v1].add(v2);
			graph[v2].add(v1);
		}
		Deque<Integer> deque = new ArrayDeque<>();
		for (int idx = 0; idx < n; idx++) {
			if (degree[idx] == 1) {
				deque.add(idx);
			}
		}
		while (n > 2) {
			int size = deque.size();
			n -= size;
			while (size > 0) {
				int idx = deque.pop();
				degree[idx]--;
				for (int val : graph[idx]) {
					degree[val]--;
					if (degree[val] == 1) {
						deque.add(val);
					}
				}
				size--;
			}
		}
		result.addAll(deque);
		return result;
	}

}
