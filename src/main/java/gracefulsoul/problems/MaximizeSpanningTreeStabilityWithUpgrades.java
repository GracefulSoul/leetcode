package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximizeSpanningTreeStabilityWithUpgrades {

	// https://leetcode.com/problems/maximize-spanning-tree-stability-with-upgrades/submissions/1945960827/
	public static void main(String[] args) {
		MaximizeSpanningTreeStabilityWithUpgrades test = new MaximizeSpanningTreeStabilityWithUpgrades();
		System.out.println(test.maxStability(3, new int[][] {
			{ 0, 1, 2, 1 },
			{ 1, 2, 3, 0 }
		}, 1));
		System.out.println(test.maxStability(3, new int[][] {
			{ 0, 1, 4, 0 },
			{ 1, 2, 3, 0 },
			{ 0, 2, 1, 0 }
		}, 2));
		System.out.println(test.maxStability(3, new int[][] {
			{ 0, 1, 1, 1 },
			{ 1, 2, 1, 1 },
			{ 2, 0, 1, 1 }
		}, 0));
	}

	public int maxStability(int n, int[][] edges, int k) {
		DSU dsu = new DSU(n);
		int comp = n;
		int min = Integer.MAX_VALUE;
		List<int[]> graph = new ArrayList<>();
		for (int[] edge : edges) {
			if (edge[3] == 1) {
				if (!dsu.union(edge[0], edge[1])) {
					return -1;
				}
				comp--;
				min = Math.min(min, edge[2]);
			} else {
				graph.add(edge);
			}
		}
		graph.sort((a, b) -> b[2] - a[2]);
		List<Integer> list = new ArrayList<>();
		for (int[] edge : graph) {
			if (dsu.union(edge[0], edge[1])) {
				list.add(edge[2]);
				comp--;
				if (comp == 1) {
					break;
				}
			}
		}
		if (comp > 1) {
			return -1;
		}
		Collections.sort(list);
		int result = min;
		for (int s : list) {
			int value = s;
			if (k > 0) {
				value *= 2;
				k--;
			}
			if (result == Integer.MAX_VALUE) {
				result = value;
			} else {
				result = Math.min(result, value);
			}
		}
		return result;
	}

}

class DSU {

	private int[] parent;
	private int[] rank;

	public DSU(int n) {
		this.parent = new int[n];
		this.rank = new int[n];
		for (int i = 0; i < n; i++) {
			this.parent[i] = i;
		}
	}

	public int find(int num) {
		if (this.parent[num] == num) {
			return num;
		} else {
			return this.parent[num] = this.find(this.parent[num]);
		}
	}

	public boolean union(int a, int b) {
		a = this.find(a);
		b = this.find(b);
		if (a == b) {
			return false;
		}
		if (this.rank[a] < this.rank[b]) {
			int temp = a;
			a = b;
			b = temp;
		}
		this.parent[b] = a;
		if (this.rank[a] == this.rank[b]) {
			this.rank[a]++;
		}
		return true;
	}

}