package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class UnivaluedBinaryTree {

	// https://leetcode.com/problems/univalued-binary-tree/submissions/1011065731/
	public static void main(String[] args) {
		UnivaluedBinaryTree test = new UnivaluedBinaryTree();
		System.out.println(test.isUnivalTree(new TreeNode(1, new TreeNode(1, new TreeNode(1), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)))));
		System.out.println(test.isUnivalTree(new TreeNode(2, new TreeNode(2, new TreeNode(5), new TreeNode(1)), new TreeNode(2))));
	}

	public boolean isUnivalTree(TreeNode root) {
		return this.isUnivalTree(root.left, root.val) && this.isUnivalTree(root.right, root.val);
	}

	private boolean isUnivalTree(TreeNode root, int value) {
		if (root != null) {
			return root.val == value && this.isUnivalTree(root.left, value) && this.isUnivalTree(root.right, value);
		} else {
			return true;
		}
	}

}
