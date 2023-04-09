package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class IncreasingOrderSearchTree {

	// https://leetcode.com/problems/increasing-order-search-tree/submissions/930393509/
	public static void main(String[] args) {
		IncreasingOrderSearchTree test = new IncreasingOrderSearchTree();
		System.out.println(test.increasingBST(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6, null, new TreeNode(8, new TreeNode(7), new TreeNode(9))))));
		System.out.println(test.increasingBST(new TreeNode(5, new TreeNode(1), new TreeNode(7))));
	}

	public TreeNode increasingBST(TreeNode root) {
		return this.dfs(root, null);
	}

	private TreeNode dfs(TreeNode root, TreeNode tail) {
		if (root == null) {
			return tail;
		} else {
			TreeNode temp = this.dfs(root.left, root);
			root.left = null;
			root.right = this.dfs(root.right, tail);
			return temp;
		}
	}

}
