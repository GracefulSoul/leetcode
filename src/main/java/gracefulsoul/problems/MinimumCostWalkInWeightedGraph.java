package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class MinimumCostWalkInWeightedGraph {

	// https://leetcode.com/problems/minimum-cost-walk-in-weighted-graph/submissions/1580060883/
	public static void main(String[] args) {
		MinimumCostWalkInWeightedGraph test = new MinimumCostWalkInWeightedGraph();
		PrintUtil.print(test.minimumCost(5, new int[][] {
			{ 0, 1, 7 },
			{ 1, 3, 7 },
			{ 1, 2, 1 }
		}, new int[][] {
			{ 0, 3 },
			{ 3, 4 }
		}));
		PrintUtil.print(test.minimumCost(5, new int[][] {
			{ 0, 2, 7 },
			{ 0, 1, 15 },
			{ 1, 2, 6 },
			{ 1, 2, 1 }
		}, new int[][] {
			{ 1, 2 }
		}));
	}

	public int[] minimumCost(int n, int[][] edges, int[][] query) {
		int[] parent = new int[n];
		int[] costs = new int[n];
		Arrays.fill(costs, -1);
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		for (int[] edge : edges) {
			int source = this.findRoot(parent, edge[0]);
			int target = this.findRoot(parent, edge[1]);
			costs[target] &= edge[2];
			if (source != target) {
				costs[target] &= costs[source];
				parent[source] = target;
			}
		}
		int[] result = new int[query.length];
		for (int i = 0; i < query.length; i++) {
			int start = query[i][0];
			int end = query[i][1];
			if (start == end) {
				result[i] = 0;
			} else if (this.findRoot(parent, start) != this.findRoot(parent, end)) {
				result[i] = -1;
			} else {
				result[i] = costs[this.findRoot(parent, start)];
			}
		}
		return result;
	}

	private int findRoot(int[] parent, int node) {
		if (parent[node] != node) {
			parent[node] = this.findRoot(parent, parent[node]);
		}
		return parent[node];
	}

}
