package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class LongestUnivaluePath {

	// https://leetcode.com/submissions/detail/817547458/
	public static void main(String[] args) {
		LongestUnivaluePath test = new LongestUnivaluePath();
		System.out.println(test.longestUnivaluePath(new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(1)), new TreeNode(5, null, new TreeNode(5)))));
		System.out.println(test.longestUnivaluePath(new TreeNode(1, new TreeNode(4, new TreeNode(4), new TreeNode(4)), new TreeNode(5, null, new TreeNode(5)))));
	}

	private int length;

	public int longestUnivaluePath(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			this.length = 0;
			this.getLength(root, root.val);
			return this.length;
		}
	}

	private int getLength(TreeNode node, int val) {
		if (node == null) {
			return 0;
		}
		int left = this.getLength(node.left, node.val);
		int right = this.getLength(node.right, node.val);
		this.length = Math.max(this.length, left + right);
		if (val == node.val) {
			return Math.max(left, right) + 1;
		} else {
			return 0;
		}
	}

}
