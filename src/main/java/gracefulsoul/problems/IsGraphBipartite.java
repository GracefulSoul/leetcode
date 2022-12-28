package gracefulsoul.problems;

public class IsGraphBipartite {

	// https://leetcode.com/problems/is-graph-bipartite/submissions/866788048/
	public static void main(String[] args) {
		IsGraphBipartite test = new IsGraphBipartite();
		System.out.println(test.isBipartite(new int[][] {
			{ 1, 2, 3 },
			{ 0, 2 },
			{ 0, 1, 3 },
			{ 0, 2 }
		}));
		System.out.println(test.isBipartite(new int[][] {
			{ 1, 3 },
			{ 0, 2 },
			{ 1, 3 },
			{ 0, 2 }
		}));

	}

	public boolean isBipartite(int[][] graph) {
		int[] sets = new int[graph.length];
		for (int idx = 0; idx < graph.length; idx++) {
			if (sets[idx] == 0 && !this.dfs(graph, sets, 1, idx)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int[][] graph, int[] sets, int set, int index) {
		if (sets[index] != 0) {
			return sets[index] == set;
		}
		sets[index] = set;
		for (int node : graph[index]) {
			if (!this.dfs(graph, sets, -set, node)) {
				return false;
			}
		}
		return true;
	}

}
