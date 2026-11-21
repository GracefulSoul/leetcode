package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.util.PrintUtil;

public class FindSubtreeSizesAfterChanges {

	// https://leetcode.com/problems/find-subtree-sizes-after-changes/submissions/2200579767/
	public static void main(String[] args) {
		FindSubtreeSizesAfterChanges test = new FindSubtreeSizesAfterChanges();
		PrintUtil.print(test.findSubtreeSizes(new int[] { -1, 0, 0, 1, 1, 1 }, "abaabc"));
		PrintUtil.print(test.findSubtreeSizes(new int[] { -1, 0, 4, 0, 1 }, "abbba"));
	}

	public int[] findSubtreeSizes(int[] parent, String s) {
		int n = parent.length;
		List<List<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			adj.get(parent[i]).add(i);
		}
		int[] nParent = Arrays.copyOf(parent, n);
		this.dfs(0, s, adj, new HashMap<>(), nParent);
		List<List<Integer>> nAdj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nAdj.add(new ArrayList<>());
		}
		for (int i = 1; i < n; i++) {
			nAdj.get(nParent[i]).add(i);
		}
		int[] result = new int[n];
		this.dfs(0, nAdj, result);
		return result;
	}

	private void dfs(int i, String s, List<List<Integer>> adj, Map<Character, Integer> map, int[] nParent) {
		char c = s.charAt(i);
		Integer prev = map.get(c);
		if (prev != null && prev != nParent[i]) {
			nParent[i] = prev;
		}
		Integer num = map.put(c, i);
		for (int child : adj.get(i)) {
			this.dfs(child, s, adj, map, nParent);
		}
		if (num == null) {
			map.remove(c);
		} else {
			map.put(c, num);
		}
	}

	private int dfs(int node, List<List<Integer>> adj, int[] answer) {
		int count = 1;
		for (int child : adj.get(node)) {
			count += this.dfs(child, adj, answer);
		}
		answer[node] = count;
		return count;
	}

}
