package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreePruning {

	// https://leetcode.com/problems/binary-tree-pruning/submissions/883611179/
	public static void main(String[] args) {
		BinaryTreePruning test = new BinaryTreePruning();
		System.out.println(test.pruneTree(new TreeNode(1, null, new TreeNode(0, new TreeNode(0), new TreeNode(1)))));
		System.out.println(test.pruneTree(new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(0)), new TreeNode(1, new TreeNode(0), new TreeNode(1)))));
		System.out.println(test.pruneTree(new TreeNode(1, new TreeNode(1, new TreeNode(1, new TreeNode(1), null), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)))));
	}

	public TreeNode pruneTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		root.left = this.pruneTree(root.left);
		root.right = this.pruneTree(root.right);
		if (root.left == null && root.right == null && root.val == 0) {
			return null;
		} else {
			return root;
		}
	}

}
