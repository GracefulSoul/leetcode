package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;

public class MaximumWidthOfBinaryTree {

	// https://leetcode.com/submissions/detail/801658943/
	public static void main(String[] args) {
		MaximumWidthOfBinaryTree test = new MaximumWidthOfBinaryTree();
		System.out.println(test.widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5), new TreeNode(3)), new TreeNode(2, null, new TreeNode(9)))));
		System.out.println(test.widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5, new TreeNode(6), null), null), new TreeNode(2, null, new TreeNode(9, new TreeNode(7), null)))));
		System.out.println(test.widthOfBinaryTree(new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2))));
	}

	public int widthOfBinaryTree(TreeNode root) {
		return this.dfs(root, 0, 0, new HashMap<>(), 1);
	}

	private int dfs(TreeNode treeNode, int level, int max, Map<Integer, Integer> map, int id) {
		if (treeNode == null) {
			return 0;
		} else {
			map.putIfAbsent(level, id);
			max = Math.max(max, id - map.get(level) + 1);
			max = Math.max(max, this.dfs(treeNode.left, level + 1, max, map, 2 * id));
			max = Math.max(max, this.dfs(treeNode.right, level + 1, max, map, 2 * id + 1));
			return max;
		}
	}

}
