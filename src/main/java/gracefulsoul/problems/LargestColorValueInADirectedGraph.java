package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LargestColorValueInADirectedGraph {

	// https://leetcode.com/problems/largest-color-value-in-a-directed-graph/submissions/1644878492/
	public static void main(String[] args) {
		LargestColorValueInADirectedGraph test = new LargestColorValueInADirectedGraph();
		System.out.println(test.largestPathValue("abaca", new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 2, 3 },
			{ 3, 4 }
		}));
		System.out.println(test.largestPathValue("a", new int[][] {
			{ 0, 0 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int largestPathValue(String colors, int[][] edges) {
		char[] charArray = colors.toCharArray();
		int length = charArray.length;
		List<Integer>[] graph = new List[length];
		for (int i = 0; i < length; i++) {
			graph[i] = new ArrayList<>();
		}
		int[] indegree = new int[length];
		for (int[] edge : edges) {
			indegree[edge[1]]++;
			graph[edge[0]].add(edge[1]);
		}
		int[][] counts = new int[length][26];
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < length; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int visited = 0;
		int result = 0;
		while (!queue.isEmpty()) {
			visited++;
			int curr = queue.poll();
			int color = charArray[curr] - 'a';
			result = Math.max(result, ++counts[curr][color]);
			for (int value : graph[curr]) {
				for (int i = 0; i < 26; i++) {
					counts[value][i] = Math.max(counts[value][i], counts[curr][i]);
				}
				if (--indegree[value] == 0) {
					queue.offer(value);
				}
			}
		}
		return visited == length ? result : -1;
	}

}
