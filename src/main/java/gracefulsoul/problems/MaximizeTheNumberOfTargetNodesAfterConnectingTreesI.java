package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesI {

	// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-i/submissions/1646918953/
	public static void main(String[] args) {
		MaximizeTheNumberOfTargetNodesAfterConnectingTreesI test = new MaximizeTheNumberOfTargetNodesAfterConnectingTreesI();
		PrintUtil.print(test.maxTargetNodes(new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 2, 3 },
			{ 2, 4 }
		}, new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 0, 3 },
			{ 2, 7 },
			{ 1, 4 },
			{ 4, 5 },
			{ 4, 6 }
		}, 2));
		PrintUtil.print(test.maxTargetNodes(new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 0, 3 },
			{ 0, 4 }
		}, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 3 }
		}, 1));
	}

	public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
		List<List<Integer>> list = this.parseList(edges2);
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			max = Math.max(max, this.dfs(list, k - 1, i, -1));
		}
		list = this.parseList(edges1);
		int length = list.size();
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = this.dfs(list, k, i, -1) + max;
		}
		return result;
	}

	private List<List<Integer>> parseList(int[][] edges) {
		int length = edges.length + 1;
		List<List<Integer>> list = new ArrayList<>(length);
		for (int i = 0; i < length; i++) {
			list.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		return list;
	}

	private int dfs(List<List<Integer>> list, int k, int i, int target) {
		if (k < 0) {
			return 0;
		} else {
			int count = 1;
			for (int value : list.get(i)) {
				if (value != target) {
					count += this.dfs(list, k - 1, value, i);
				}
			}
			return count;
		}
	}

}
