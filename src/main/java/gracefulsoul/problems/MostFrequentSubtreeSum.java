package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class MostFrequentSubtreeSum {

	// https://leetcode.com/submissions/detail/707968081/
	public static void main(String[] args) {
		PrintUtil.print(
				new MostFrequentSubtreeSum().findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-3))));
		PrintUtil.print(
				new MostFrequentSubtreeSum().findFrequentTreeSum(new TreeNode(5, new TreeNode(2), new TreeNode(-5))));
	}

	private int max = 0;

	public int[] findFrequentTreeSum(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		this.dfs(root, list, new HashMap<>());
		int[] result = new int[list.size()];
		for (int idx = 0; idx < list.size(); idx++) {
			result[idx] = list.get(idx);
		}
		return result;
	}

	private int dfs(TreeNode root, List<Integer> list, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		int sum = root.val + this.dfs(root.left, list, map) + this.dfs(root.right, list, map);
		int frequency = map.getOrDefault(sum, 0) + 1;
		map.put(sum, frequency);
		if (frequency > this.max) {
			max = frequency;
			list.clear();
			list.add(sum);
		} else if (frequency == this.max) {
			list.add(sum);
		}
		return sum;
	}

}
