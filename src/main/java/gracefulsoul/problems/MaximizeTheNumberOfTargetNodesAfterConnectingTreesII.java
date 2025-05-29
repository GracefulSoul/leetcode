package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class MaximizeTheNumberOfTargetNodesAfterConnectingTreesII {

	// https://leetcode.com/problems/maximize-the-number-of-target-nodes-after-connecting-trees-ii/submissions/1647850124/
	public static void main(String[] args) {
		MaximizeTheNumberOfTargetNodesAfterConnectingTreesII test = new MaximizeTheNumberOfTargetNodesAfterConnectingTreesII();
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
		}));
		PrintUtil.print(test.maxTargetNodes(new int[][] {
			{ 0, 1 },
			{ 0, 2 },
			{ 0, 3 },
			{ 0, 4 }
		}, new int[][] {
			{ 0, 1 },
			{ 1, 2 },
			{ 2, 3 }
		}));
	}

	private int[][] counts;

	public int[] maxTargetNodes(int[][] edges1, int[][] edges2) {
		List<List<Integer>> listA = this.paresList(edges1);
		List<List<Integer>> listB = this.paresList(edges2);
		int length = listA.size();
		int[] colorA = new int[listA.size()];
		int[] colorB = new int[listB.size()];
		Arrays.fill(colorA, -1);
		Arrays.fill(colorB, -1);
		this.counts = new int[2][2];
		colorA[0] = 0;
		this.dfs(listA, 0, -1, colorA, true);
		colorB[0] = 0;
		this.dfs(listB, 0, -1, colorB, false);
		int max = Math.max(this.counts[1][0], this.counts[1][1]);
		int[] result = new int[length];
		for (int i = 0; i < length; i++) {
			result[i] = (colorA[i] == 0 ? this.counts[0][1] : this.counts[0][0]) + max;
		}
		return result;
	}

	private List<List<Integer>> paresList(int[][] edges) {
		int length = edges.length + 1;
		List<List<Integer>> list = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			list.add(new ArrayList<>());
		}
		for (int[] edge : edges) {
			list.get(edge[0]).add(edge[1]);
			list.get(edge[1]).add(edge[0]);
		}
		return list;
	}

	private void dfs(List<List<Integer>> list, int i, int target, int[] color, boolean isA) {
		if (color[i] == 0) {
			if (isA) {
				this.counts[0][1]++;
			} else {
				this.counts[1][1]++;
			}
		} else {
			if (isA) {
				this.counts[0][0]++;
			} else {
				this.counts[1][0]++;
			}
		}
		for (int value : list.get(i)) {
			if (value != target) {
				color[value] = color[i] ^ 1;
				this.dfs(list, value, i, color, isA);
			}
		}
	}

}
