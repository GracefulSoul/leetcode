package gracefulsoul.problems;

public class FindIfPathExistsInGraph {

	// https://leetcode.com/problems/find-if-path-exists-in-graph/submissions/1238132601/
	public static void main(String[] args) {
		FindIfPathExistsInGraph test = new FindIfPathExistsInGraph();
		System.out.println(test.validPath(3, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 0 }
		}, 0, 2));
		System.out.println(test.validPath(6, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 3, 5 },
			{ 5, 4 },
			{ 4, 3 }
		}, 0, 5));
	}

	public boolean validPath(int n, int[][] edges, int source, int destination) {
		if (edges.length == 0) {
			return true;
		} else {
			boolean[] visited = new boolean[n];
			visited[source] = true;
			boolean running = true;
			while (running) {
				running = false;
				for (int[] edge : edges) {
					if (visited[edge[0]] != visited[edge[1]]) {
						visited[edge[0]] = true;
						visited[edge[1]] = true;
						running = true;
					}
					if (visited[destination]) {
						return true;
					}
				}
			}
			return false;
		}
	}

}
