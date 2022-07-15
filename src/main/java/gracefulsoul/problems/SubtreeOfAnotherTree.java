package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SubtreeOfAnotherTree {

	// https://leetcode.com/submissions/detail/747702224/
	public static void main(String[] args) {
		SubtreeOfAnotherTree test = new SubtreeOfAnotherTree();
		System.out.println(test.isSubtree(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2)), new TreeNode(5)), new TreeNode(4, new TreeNode(1), new TreeNode(2))));
		System.out.println(test.isSubtree(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(2, new TreeNode(0), null)), new TreeNode(5)), new TreeNode(4, new TreeNode(1), new TreeNode(2))));
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
			return false;
		} else if (this.isSameTree(root, subRoot)) {
			return true;
		} else {
			return this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
		}
	}

	private boolean isSameTree(TreeNode root, TreeNode subRoot) {
		if (root == null || subRoot == null) {
			return root == null && subRoot == null;
		} else if (root.val == subRoot.val) {
			return this.isSameTree(root.right, subRoot.right) && this.isSameTree(root.left, subRoot.left);
		} else {
			return false;
		}
	}

}
