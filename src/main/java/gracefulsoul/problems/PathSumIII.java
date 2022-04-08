package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;

public class PathSumIII {

	// https://leetcode.com/submissions/detail/669405657/
	public static void main(String[] args) {
		PathSumIII test = new PathSumIII();
		System.out.println(test.pathSum(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(3), new TreeNode(-2)), new TreeNode(2, null, new TreeNode(1))), new TreeNode(-3, null, new TreeNode(11))), 8));
//		System.out.println(test.pathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13, new TreeNode(5), new TreeNode(1)), new TreeNode(4))), 22));
	}

	public int pathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return 0;
		} else {
			Map<Integer, Integer> map = new HashMap<>();
			map.put(0, 1);
			return this.dfs(root, targetSum, map, 0);
		}
	}

	private int dfs(TreeNode node, int targetSum, Map<Integer, Integer> map, int sum) {
		int result = 0;
		sum += node.val;
		if (map.containsKey(sum - targetSum)) {
			result += map.get(sum - targetSum);
		}
		map.put(sum, map.getOrDefault(sum, 0) + 1);
		if (node.left != null) {
			result += this.dfs(node.left, targetSum, map, sum);
		}
		if (node.right != null) {
			result += this.dfs(node.right, targetSum, map, sum);
		}
		map.put(sum, map.get(sum) - 1);
		return result;
	}

}
