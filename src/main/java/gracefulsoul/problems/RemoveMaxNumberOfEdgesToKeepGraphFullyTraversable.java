package gracefulsoul.problems;

import java.util.Arrays;

public class RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable {

	// https://leetcode.com/problems/remove-max-number-of-edges-to-keep-graph-fully-traversable/submissions/1304317924/
	public static void main(String[] args) {
		RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable test = new RemoveMaxNumberOfEdgesToKeepGraphFullyTraversable();
		System.out.println(test.maxNumEdgesToRemove(4, new int[][] {
			{ 3, 1, 2 },
			{ 3, 2, 3 },
			{ 1, 1, 3 },
			{ 1, 2, 4 },
			{ 1, 1, 2 },
			{ 2, 3, 4 }
		}));
		System.out.println(test.maxNumEdgesToRemove(4, new int[][] {
			{ 3, 1, 2 },
			{ 3, 2, 3 },
			{ 1, 1, 4 },
			{ 2, 1, 4 }
		}));
		System.out.println(test.maxNumEdgesToRemove(4, new int[][] {
			{ 3, 2, 3 },
			{ 1, 1, 2 },
			{ 2, 3, 4 }
		}));
	}

	public int maxNumEdgesToRemove(int n, int[][] edges) {
		Arrays.sort(edges, (a, b) -> b[0] - a[0]);
		int add = 0;
		Union alice = new Union(n);
		Union bob = new Union(n);
		for (int[] edge : edges) {
			int type = edge[0];
			int u = edge[1];
			int v = edge[2];
			switch (type) {
			case 3:
				if (alice.unite(u, v) | bob.unite(u, v)) {
					add++;
				}
				break;
			case 2:
				if (bob.unite(u, v)) {
					add++;
				}
				break;
			case 1:
				if (alice.unite(u, v)) {
					add++;
				}
				break;
			}
		}
		return alice.united() && bob.united() ? edges.length - add : -1;
	}

	private class Union {

		private int[] component;
		private int count;

		public Union(int n) {
			component = new int[n + 1];
			for (int i = 0; i <= n; i++) {
				component[i] = i;
			}
			count = n;
		}

		private boolean unite(int a, int b) {
			if (this.findComponent(a) != this.findComponent(b)) {
				component[this.findComponent(a)] = b;
				count--;
				return true;
			}

			return false;
		}

		private int findComponent(int a) {
			if (component[a] != a) {
				component[a] = this.findComponent(component[a]);
			}
			return component[a];
		}

		private boolean united() {
			return count == 1;
		}

	}

}
