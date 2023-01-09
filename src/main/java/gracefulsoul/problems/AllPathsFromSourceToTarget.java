package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

	// https://leetcode.com/problems/all-paths-from-source-to-target/submissions/874699931/
	public static void main(String[] args) {
		AllPathsFromSourceToTarget test = new AllPathsFromSourceToTarget();
		System.out.println(test.allPathsSourceTarget(new int[][] {
			{ 1, 2 },
			{ 3 },
			{ 3 },
			{}
		}));
		System.out.println(test.allPathsSourceTarget(new int[][] {
			{ 4, 3, 1 },
			{ 3, 2, 4 },
			{ 3 },
			{ 4 },
			{}
		}));
	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> result = new ArrayList<>();
		this.dfs(result, new ArrayList<>(), graph, 0, graph.length - 1);
		return result;
	}

	private void dfs(List<List<Integer>> result, List<Integer> path, int[][] graph, int start, int end) {
		path.add(start);
		if (start == end) {
			result.add(new ArrayList<>(path));
		} else {
			for (int n : graph[start]) {
				this.dfs(result, path, graph, n, end);
			}
		}
		path.remove(path.size() - 1);
	}

}
