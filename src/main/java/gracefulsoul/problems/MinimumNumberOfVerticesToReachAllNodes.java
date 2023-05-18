package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfVerticesToReachAllNodes {

	// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/submissions/952635654/
	public static void main(String[] args) {
		MinimumNumberOfVerticesToReachAllNodes test = new MinimumNumberOfVerticesToReachAllNodes();
		System.out.println(test.findSmallestSetOfVertices(6, Arrays.asList(
			Arrays.asList(0, 1),
			Arrays.asList(0, 2),
			Arrays.asList(2, 5),
			Arrays.asList(3, 4),
			Arrays.asList(4, 2)
		)));
		System.out.println(test.findSmallestSetOfVertices(5, Arrays.asList(
				Arrays.asList(0, 1),
				Arrays.asList(2, 1),
				Arrays.asList(3, 1),
				Arrays.asList(1, 4),
				Arrays.asList(2, 4)
			)));
	}

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		boolean[] visited = new boolean[n];
		for (List<Integer> edge : edges) {
			visited[edge.get(1)] = true;
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				result.add(i);
			}
		}
		return result;
	}

}
