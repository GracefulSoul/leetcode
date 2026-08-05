package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RemoveMethodsFromProject {

	// https://leetcode.com/problems/remove-methods-from-project/submissions/2095230259/
	public static void main(String[] args) {
		RemoveMethodsFromProject test = new RemoveMethodsFromProject();
		System.out.println(test.remainingMethods(4, 1, new int[][] {
			{ 1, 2 },
			{ 0, 1 },
			{ 3, 2 }
		}));
		System.out.println(test.remainingMethods(5, 0, new int[][] {
			{ 1, 2 },
			{ 0, 2 },
			{ 0, 1 },
			{ 3, 4 }
		}));
		System.out.println(test.remainingMethods(3, 2, new int[][] {
			{ 1, 2 },
			{ 0, 1 },
			{ 2, 0 }
		}));
	}

	@SuppressWarnings("unchecked")
	public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
		List<Integer>[] edges = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			edges[i] = new ArrayList<>();
		}
		int[] inDegree = new int[n];
		for (int[] invocation : invocations) {
			edges[invocation[0]].add(invocation[1]);
			inDegree[invocation[1]]++;
		}
		Queue<Integer> queue = new ArrayDeque<>();
		queue.offer(k);
		boolean[] suspicious = new boolean[n];
		suspicious[k] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int v : edges[u]) {
				inDegree[v]--;
				if (!suspicious[v]) {
					queue.offer(v);
					suspicious[v] = true;
				}
			}
		}
		boolean remove = true;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (suspicious[i] && 0 < inDegree[i]) {
				remove = false;
				break;
			} else if (!suspicious[i]) {
				result.add(i);
			}
		}
		if (!remove) {
			List<Integer> list = new ArrayList<>(n);
			for (int i = 0; i < n; i++) {
				list.add(i);
			}
			return list;
		} else {
			return result;
		}
	}

}
