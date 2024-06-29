package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class AllAncestorsOfANodeInADirectedAcyclicGraph {

	// https://leetcode.com/problems/all-ancestors-of-a-node-in-a-directed-acyclic-graph/submissions/1303420555/
	public static void main(String[] args) {
		AllAncestorsOfANodeInADirectedAcyclicGraph test = new AllAncestorsOfANodeInADirectedAcyclicGraph();
		System.out.println(test.getAncestors(8, new int[][] {
			{ 0, 3 },
			{ 0, 4 },
			{ 1, 3 },
			{ 2, 4 },
			{ 2, 7 },
			{ 3, 5 },
			{ 3, 6 },
			{ 3, 7 },
			{ 4, 6 }
		}));
		System.out.println(test.getAncestors(8, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 0, 3 },
			{ 0, 4 },
			{ 1, 2 },
			{ 1, 3 },
			{ 1, 4 },
			{ 2, 3 },
			{ 2, 4 },
			{ 3, 4 }
		}));
	}

	public List<List<Integer>> getAncestors(int n, int[][] edges) {
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> childs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(new ArrayList<>());
			childs.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			childs.get(edge[0]).add(edge[1]);
		}
		for (int i = 0; i < n; i++) {
			this.dfs(result, childs, i, i);
		}
		return result;
	}

	private void dfs(List<List<Integer>> result, List<List<Integer>> childs, int node, int curr) {
		for (int child : childs.get(curr)) {
			List<Integer> list = result.get(child);
			if (list.size() == 0 || list.get(list.size() - 1) != node) {
				list.add(node);
				this.dfs(result, childs, node, child);
			}
		}
	}

}
