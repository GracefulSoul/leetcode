package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class MinimumScoreOfAPathBetweenTwoCities {

	// https://leetcode.com/problems/minimum-score-of-a-path-between-two-cities/submissions/2055174431/
	public static void main(String[] args) {
		MinimumScoreOfAPathBetweenTwoCities test = new MinimumScoreOfAPathBetweenTwoCities();
		System.out.println(test.minScore(4, new int[][] {
			{ 1, 2, 9 },
			{ 2, 3, 6 },
			{ 2, 4, 5 },
			{ 1, 4, 7 }
		}));
		System.out.println(test.minScore(4, new int[][] {
			{ 1, 2, 2 },
			{ 1, 3, 4 },
			{ 3, 4, 7 }
		}));
	}

	@SuppressWarnings("unchecked")
	public int minScore(int n, int[][] roads) {
		List<int[]>[] graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int[] road : roads) {
			graph[road[0]].add(new int[] { road[1], road[2] });
			graph[road[1]].add(new int[] { road[0], road[2] });
		}
		return this.dfs(graph, new boolean[n + 1], 1, 100001);
	}

	private int dfs(List<int[]>[] graph, boolean[] visited, int i, int num) {
		visited[i] = true;
		for (int[] node : graph[i]) {
			num = Math.min(num, node[1]);
			if (!visited[node[0]]) {
				num = this.dfs(graph, visited, node[0], num);
			}
		}
		return num;
	}

}
