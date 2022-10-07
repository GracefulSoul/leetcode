package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class RedundantConnectionII {

	// https://leetcode.com/submissions/detail/817127881/
	public static void main(String[] args) {
		RedundantConnectionII test = new RedundantConnectionII();
		PrintUtil.print(test.findRedundantDirectedConnection(new int[][] {
			{ 1, 2 },
			{ 1, 3 },
			{ 2, 3 }
		}));
		PrintUtil.print(test.findRedundantDirectedConnection(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 4, 1 },
			{ 1, 5 }
		}));
	}

	public int[] findRedundantDirectedConnection(int[][] edges) {
		int[] parents = new int[edges.length + 1];
		int[] multipleParents = null;
		int[] cycle = null;
		for (int idx = 0; idx < parents.length; idx++) {
			parents[idx] = idx;
		}
		for (int[] edge : edges) {
			int start = this.findParent(parents, edge[0]);
			int end = this.findParent(parents, edge[1]);
			if (end != edge[1]) {
				multipleParents = edge;
			} else if (start == end) {
				cycle = edge;
			} else {
				parents[edge[1]] = start;
			}
		}
		if (multipleParents == null) {
			return cycle;
		} else if (cycle == null) {
			return multipleParents;
		} else {
			for (int[] edge : edges) {
				if (edge[1] == multipleParents[1])
					return edge;
			}
			return new int[2];
		}
	}

	private int findParent(int[] parents, int node) {
		if (parents[node] != node) {
			parents[node] = this.findParent(parents, parents[node]);
		}
		return parents[node];
	}

}
