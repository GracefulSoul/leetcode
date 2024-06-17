package gracefulsoul.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import gracefulsoul.util.PrintUtil;

public class ShortestPathWithAlternatingColors {

	// https://leetcode.com/problems/shortest-path-with-alternating-colors/submissions/1291066563/
	public static void main(String[] args) {
		ShortestPathWithAlternatingColors test = new ShortestPathWithAlternatingColors();
		PrintUtil.print(test.shortestAlternatingPaths(3, new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}, new int[][] {}));
		PrintUtil.print(test.shortestAlternatingPaths(3, new int[][] {
			{ 0, 1 }
		}, new int[][] {
			{ 2, 1 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
		Set<Integer>[][] set = new Set[n][2];
		for (int i = 0; i < n; i++) {
			set[i][0] = new HashSet<>();
			set[i][1] = new HashSet<>();
		}
		for (int[] redEdge : redEdges) {
			set[redEdge[0]][0].add(redEdge[1]);
		}
		for (int[] blueEdge : blueEdges) {
			set[blueEdge[0]][1].add(blueEdge[1]);
		}
		int[][] paths = new int[n][2];
		for (int i = 1; i < n; i++) {
			paths[i][0] = paths[i][1] = n * 2;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { 0, 0 });
		queue.offer(new int[] { 0, 1 });
		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int row = curr[0];
			int col = curr[1];
			for (int node : set[row][1 - col]) {
				if (paths[node][1 - col] == n * 2) {
					paths[node][1 - col] = paths[row][col] + 1;
					queue.offer(new int[] { node, 1 - col });
				}
			}
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			int min = Math.min(paths[i][0], paths[i][1]);
			result[i] = min == n * 2 ? -1 : min;
		}
		return result;
	}

}
