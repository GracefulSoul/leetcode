package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumScoreAfterRemovalsOnATree {

	// https://leetcode.com/problems/minimum-score-after-removals-on-a-tree/submissions/1709630797/
	public static void main(String[] args) {
		MinimumScoreAfterRemovalsOnATree test = new MinimumScoreAfterRemovalsOnATree();
		System.out.println(test.minimumScore(new int[] { 1, 5, 5, 4, 11 }, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 1, 3 },
			{ 3, 4 }
		}));
		System.out.println(test.minimumScore(new int[] { 5, 5, 2, 4, 4, 2 }, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 5, 2 },
			{ 4, 3 },
			{ 1, 3 }
		}));
	}

	public int minimumScore(int[] nums, int[][] edges) {
		List<List<Integer>> graph = new ArrayList<>();
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		int[] parent = new int[length];
		Arrays.fill(parent, -1);
		int[] xors = new int[length];
		this.dfs(graph, nums, 0, parent, xors);
		boolean[][] ancestor = new boolean[length][length];
		for (int i = 0; i < length; i++) {
			int curr = parent[i];
			while (curr != -1) {
				ancestor[curr][i] = true;
				curr = parent[curr];
			}
		}
		int xor = xors[0];
		int result = Integer.MAX_VALUE;
		for (int i = 1; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int xor1 = xors[i];
				int xor2 = xors[j];
				int[] components = new int[3];
				if (ancestor[i][j]) {
					components[0] = xor2;
					components[1] = xor1 ^ xor2;
					components[2] = xor ^ xor1;
				} else if (ancestor[j][i]) {
					components[0] = xor1;
					components[1] = xor1 ^ xor2;
					components[2] = xor ^ xor2;
				} else {
					components[0] = xor1;
					components[1] = xor2;
					components[2] = xor ^ xor1 ^ xor2 ;
				}
				result = Math.min(result,
						Math.max(components[0], Math.max(components[1], components[2]))
						- Math.min(components[0], Math.min(components[1], components[2])));
			}
		}
		return result;
	}

	private void dfs(List<List<Integer>> graph, int[] nums, int node, int[] parent, int[] xors) {
		int xor = nums[node];
		List<Integer> children = graph.get(node);
		for (int child : children) {
			if (parent[node] != child) {
				parent[child] = node;
				this.dfs(graph, nums, child, parent, xors);
				xor ^= xors[child];
			}
		}
		xors[node] = xor;
	}

}
