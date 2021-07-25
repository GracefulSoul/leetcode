package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class MaximumDepthOfBinaryTree {

	// https://leetcode.com/submissions/detail/527787818/
	public static void main(String[] args) {
		MaximumDepthOfBinaryTree test = new MaximumDepthOfBinaryTree();
		System.out.println(test.maxDepth(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.maxDepth(new TreeNode(1, null, new TreeNode(2))));
		System.out.println(test.maxDepth(null));
		System.out.println(test.maxDepth(new TreeNode(0)));
	}

	public int maxDepth(TreeNode root) {
		return this.recursive(root, 0);
	}

	private int recursive(TreeNode treeNode, int depth) {
		if (treeNode == null) {
			return depth;
		} else {
			return Math.max(this.recursive(treeNode.left, depth + 1), this.recursive(treeNode.right, depth + 1));
		}
	}

}
