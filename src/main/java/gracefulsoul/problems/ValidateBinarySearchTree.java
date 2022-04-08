package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class ValidateBinarySearchTree {

	// https://leetcode.com/submissions/detail/524270998/
	public static void main(String[] args) {
		ValidateBinarySearchTree test = new ValidateBinarySearchTree();
		System.out.println(test.isValidBST(new TreeNode(2, new TreeNode(1), new TreeNode(3))));
		System.out.println(test.isValidBST(new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)))));
	}

	public boolean isValidBST(TreeNode root) {
		return this.recursive(root, null, null);
	}

	private boolean recursive(TreeNode root, Integer min, Integer max) {
		if (root == null) {
			return true;
		} else if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
			return false;
		} else {
			return this.recursive(root.left, min, root.val) && this.recursive(root.right, root.val, max);
		}
	}

}
