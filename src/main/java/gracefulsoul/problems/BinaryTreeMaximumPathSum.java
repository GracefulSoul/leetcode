package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class BinaryTreeMaximumPathSum {

	// https://leetcode.com/submissions/detail/538150367/
	public static void main(String[] args) {
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
		System.out.println(new BinaryTreeMaximumPathSum().maxPathSum(new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
	}

	private int max = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		this.recursive(root);
		return max;
	}

	private int recursive(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = Math.max(0, this.recursive(node.left));
		int right = Math.max(0, this.recursive(node.right));
		max = Math.max(max, node.val + left + right);
		return node.val + Math.max(left, right);
	}

}
