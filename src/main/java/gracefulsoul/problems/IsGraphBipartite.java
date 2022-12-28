package gracefulsoul.problems;

public class IsGraphBipartite {

	// https://leetcode.com/problems/is-graph-bipartite/submissions/866767781/
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
		int[] colors = new int[graph.length];
		for (int idx = 0; idx < graph.length; idx++) {
			if (colors[idx] == 0 && !this.dfs(graph, colors, 1, idx)) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int[][] graph, int[] colors, int color, int index) {
		if (colors[index] != 0) {
			return colors[index] == color;
		}
		colors[index] = color;
		for (int node : graph[index]) {
			if (!this.dfs(graph, colors, -color, node)) {
				return false;
			}
		}
		return true;
	}

}
