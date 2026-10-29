package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.Fenwick;

public class PalindromicPathQueriesInATree {

	// https://leetcode.com/problems/palindromic-path-queries-in-a-tree/submissions/2184760796/
	public static void main(String[] args) {
		PalindromicPathQueriesInATree test = new PalindromicPathQueriesInATree();
		System.out.println(test.palindromePath(3, new int[][] {
			{ 0, 1 },
			{ 1, 2 }
		}, "aac", new String[] { "query 0 2", "update 1 b", "query 0 2" }));
		System.out.println(test.palindromePath(4, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 0, 3 }
		}, "aac", new String[] { "query 1 2", "update 0 b", "query 2 3", "update 3 a", "query 1 3" }));
	}

	@SuppressWarnings("unchecked")
	public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
		List<Integer>[] graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] edge : edges) {
			graph[edge[0]].add(edge[1]);
			graph[edge[1]].add(edge[0]);
		}
		int[][] parent = new int[17][n];
		for (int[] row : parent) {
			Arrays.fill(row, -1);
		}
		int[] depth = new int[n];
		int[] in = new int[n];
		int[] out = new int[n];
		int[] timer = { 0 };
		this.dfs(graph, 0, -1, parent, depth, in, out, timer);
		for (int k = 1; k < 17; k++) {
			for (int i = 0; i < n; i++) {
				int p = parent[k - 1][i];
				if (p != -1) {
					parent[k][i] = parent[k - 1][p];
				}
			}
		}
		Fenwick fenwick = new Fenwick(n);
		char[] charArray = s.toCharArray();
		for (int i = 0; i < n; i++) {
			int m = mask(charArray[i]);
			fenwick.add(in[i], m);
			fenwick.add(out[i] + 1, m);
		}
		List<Boolean> result = new ArrayList<>();
		for (String query : queries) {
			String[] p = query.split(" ");
			if (p[0].equals("update")) {
				int num = Integer.parseInt(p[1]);
				char c = p[2].charAt(0);
				int delta = this.mask(charArray[num]) ^ this.mask(c);
				charArray[num] = c;
				fenwick.add(in[num], delta);
				fenwick.add(out[num] + 1, delta);
			} else {
				int u = Integer.parseInt(p[1]);
				int v = Integer.parseInt(p[2]);
				int w = this.lca(u, v, parent, depth);
				int m = fenwick.sum(in[u]) ^ fenwick.sum(in[v]) ^ this.mask(charArray[w]);
				result.add(m == 0 || (m & (m - 1)) == 0);
			}
		}
		return result;
	}

	private void dfs(List<Integer>[] graph, int i, int p, int[][] parent, int[] depth, int[] in, int[] out, int[] timer) {
		in[i] = timer[0]++;
		parent[0][i] = p;
		for (int value : graph[i]) {
			if (value == p) {
				continue;
			}
			depth[value] = depth[i] + 1;
			this.dfs(graph, value, i, parent, depth, in, out, timer);
		}
		out[i] = timer[0] - 1;
	}

	private int lca(int u, int v, int[][] parent, int[] depth) {
		if (depth[u] < depth[v]) {
			int t = u;
			u = v;
			v = t;
		}
		int d = depth[u] - depth[v];
		for (int k = 0; k < 17; k++) {
			if ((d & (1 << k)) != 0) {
				u = parent[k][u];
			}
		}
		if (u == v) {
			return u;
		}
		for (int k = 16; k >= 0; k--) {
			if (parent[k][u] != parent[k][v]) {
				u = parent[k][u];
				v = parent[k][v];
			}
		}
		return parent[0][u];
	}

	private int mask(char c) {
		return 1 << (c - 'a');
	}

}
