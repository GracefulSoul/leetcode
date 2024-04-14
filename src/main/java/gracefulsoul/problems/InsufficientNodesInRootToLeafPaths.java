package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class InsufficientNodesInRootToLeafPaths {

	// https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/submissions/1231664484/
	public static void main(String[] args) {
		InsufficientNodesInRootToLeafPaths test = new InsufficientNodesInRootToLeafPaths();
		PrintUtil.print(test.sufficientSubset(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(-99, new TreeNode(-99), new TreeNode(-99))), new TreeNode(3, new TreeNode(-99, new TreeNode(12), new TreeNode(13)), new TreeNode(7, new TreeNode(-99), new TreeNode(14)))), 1), true, false);
		PrintUtil.print(test.sufficientSubset(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(1)), null), new TreeNode(8, new TreeNode(17), new TreeNode(4, new TreeNode(5), new TreeNode(3)))), 22), true, false);
		PrintUtil.print(test.sufficientSubset(new TreeNode(1, new TreeNode(2, new TreeNode(-5), null), new TreeNode(-3, new TreeNode(4), null)), -1), true, false);
	}

	public TreeNode sufficientSubset(TreeNode root, int limit) {
		if (root == null) {
			return null;
		} else if (root.left == null && root.right == null) {
			return root.val < limit ? null : root;
		} else {
			root.left = this.sufficientSubset(root.left, limit - root.val);
			root.right = this.sufficientSubset(root.right, limit - root.val);
			return root.left == root.right ? null : root;
		}
	}

}
