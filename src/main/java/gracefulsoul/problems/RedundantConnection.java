package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class RedundantConnection {

	// https://leetcode.com/submissions/detail/815723816/
	public static void main(String[] args) {
		RedundantConnection test = new RedundantConnection();
		PrintUtil.print(test.findRedundantConnection(new int[][] {
			{ 1, 2 },
			{ 1, 3 },
			{ 2, 3 }
		}));
		PrintUtil.print(test.findRedundantConnection(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 3, 4 },
			{ 1, 4 },
			{ 1, 5 }
		}));
	}
	
	public int[] findRedundantConnection(int[][] edges) {
		int[] parents = new int[edges.length + 1];
		for (int[] edge : edges) {
			int a = this.find(parents, edge[0]);
			int b = this.find(parents, edge[1]);
			if (a == b) {
				return edge;
			} else {
				parents[a] = b;
			}
		}
		return new int[] {};
	}

	private int find(int[] parents, int index) {
		return parents[index] == 0 ? index : this.find(parents, parents[index]);
	}

}
