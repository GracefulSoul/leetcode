package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreeTilt {

	// https://leetcode.com/submissions/detail/742175784/
	public static void main(String[] args) {
		System.out.println(new BinaryTreeTilt().findTilt(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
		System.out.println(new BinaryTreeTilt().findTilt(new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)), new TreeNode(9, null, new TreeNode(7)))));
	}

	private int sum = 0;

	public int findTilt(TreeNode root) {
		this.recursive(root);
		return sum;
	}

	private int recursive(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = this.recursive(root.left);
		int right = this.recursive(root.right);
		sum += Math.abs(left - right);
		return left + right + root.val;
	}

}
