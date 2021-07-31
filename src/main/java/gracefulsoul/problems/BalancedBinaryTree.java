package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class BalancedBinaryTree {

	// https://leetcode.com/submissions/detail/530932178/
	public static void main(String[] args) {
		BalancedBinaryTree test = new BalancedBinaryTree();
		System.out.println(test.isBalanced(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4), new TreeNode(4)), new TreeNode(3)), new TreeNode(2))));
		System.out.println(test.isBalanced(new TreeNode()));
	}

	public boolean isBalanced(TreeNode root) {
		return this.recursive(root) != -1;
	}

	private int recursive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = this.recursive(root.left);
		int right = this.recursive(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		} else {
			return Math.max(left, right) + 1;
		}
	}

}
