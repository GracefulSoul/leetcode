package gracefulsoul.problems;

import java.util.Arrays;

public class DesignGraphWithShortestPathCalculator {

	// https://leetcode.com/problems/design-graph-with-shortest-path-calculator/submissions/1096303292/
	public static void main(String[] args) {
		Graph g = new Graph(4, new int[][] { { 0, 2, 5 }, { 0, 1, 2 }, { 1, 2, 1 }, { 3, 0, 3 } });
		System.out.println(g.shortestPath(3, 2));	// return 6. The shortest path from 3 to 2 in the first diagram above is 3 -> 0 -> 1 -> 2 with a total cost of 3 + 2 + 1 = 6.
		System.out.println(g.shortestPath(0, 3));	// return -1. There is no path from 0 to 3.
		g.addEdge(new int[] { 1, 3, 4 });			// We add an edge from node 1 to node 3, and we get the second diagram above.
		System.out.println(g.shortestPath(0, 3));	// return 6. The shortest path from 0 to 3 now is 0 -> 1 -> 3 with a total cost of 2 + 4 = 6.
	}

}

class Graph {

	private int n;
	private int[][] costs;

	public Graph(int n, int[][] edges) {
		this.costs = new int[n][n];
		this.n = n;
		for (int[] cost : this.costs) {
			Arrays.fill(cost, (int) 1e9);
		}
		for (int[] edge : edges) {
			this.costs[edge[0]][edge[1]] = edge[2];
		}
		for (int i = 0; i < n; i++) {
			this.costs[i][i] = 0;
		}
		for (int k = 0; k < n; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					this.costs[i][j] = Math.min(this.costs[i][j], this.costs[i][k] + this.costs[k][j]);
				}
			}
		}
	}

	public void addEdge(int[] e) {
		for (int i = 0; i < this.n; i++) {
			for (int j = 0; j < this.n; j++) {
				this.costs[i][j] = Math.min(this.costs[i][j], this.costs[i][e[0]] + this.costs[e[1]][j] + e[2]);
			}
		}
	}

	public int shortestPath(int node1, int node2) {
		if (this.costs[node1][node2] >= (int) 1e9) {
			return -1;
		} else {
			return this.costs[node1][node2];
		}
	}

}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */
