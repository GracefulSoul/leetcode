package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

	// https://leetcode.com/problems/find-critical-and-pseudo-critical-edges-in-minimum-spanning-tree/submissions/1025683113/
	public static void main(String[] args) {
		FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree test = new FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree();
		System.out.println(test.findCriticalAndPseudoCriticalEdges(5, new int[][] {
			{ 0, 1, 1 },
			{ 1, 2, 1 },
			{ 2, 3, 2 },
			{ 0, 3, 2 },
			{ 0, 4, 3 },
			{ 3, 4, 3 },
			{ 1, 4, 6 }
		}));
		System.out.println(test.findCriticalAndPseudoCriticalEdges(4, new int[][] {
			{ 0, 1, 1 },
			{ 1, 2, 1 },
			{ 2, 3, 1 },
			{ 0, 3, 1 }
		}));
	}

	class UnionFind {

		private int[] parents;
		private int count;

		public UnionFind(int n) {
			this.parents = new int[n];
			this.init();
		}

		private void init() {
			for (int i = 0; i < this.parents.length; i++) {
				this.parents[i] = i;
			}
			this.count = this.parents.length;
		}

		public int find(int i) {
			int parent = this.parents[i];
			if (parent == i) {
				return i;
			} else {
				int root = this.find(parent);
				parents[i] = root;
				return root;
			}
		}

		public boolean union(int i, int j) {
			int p1 = this.find(i);
			int p2 = this.find(j);
			if (p1 != p2) {
				this.count--;
				this.parents[p1] = p2;
				return true;
			} else {
				return false;
			}
		}

	}

	public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
		List<Integer> criticals = new ArrayList<>();
		List<Integer> pseduos = new ArrayList<>();
		Map<int[], Integer> map = new HashMap<>();
		int length = edges.length;
		for (int i = 0; i < length; i++) {
			map.put(edges[i], i);
		}
		Arrays.sort(edges, (e1, e2) -> Integer.compare(e1[2], e2[2]));
		int min = this.findMST(n, edges, null, null);
		for (int i = 0; i < length; i++) {
			int[] edge = edges[i];
			int index = map.get(edge);
			if (this.findMST(n, edges, null, edge) > min) {
				criticals.add(index);
			} else {
				int width = this.findMST(n, edges, edge, null);
				if (width == min) {
					pseduos.add(index);
				}
			}

		}
		return Arrays.asList(criticals, pseduos);
	}

	private int findMST(int n, int[][] edges, int[] pick, int[] skip) {
		UnionFind unionFind = new UnionFind(n);
		int cost = 0;
		if (pick != null) {
			unionFind.union(pick[0], pick[1]);
			cost += pick[2];
		}
		for (int[] edge : edges) {
			if (edge != skip && unionFind.union(edge[0], edge[1])) {
				cost += edge[2];
			}
		}
		return unionFind.count == 1 ? cost : Integer.MAX_VALUE;
	}

}
