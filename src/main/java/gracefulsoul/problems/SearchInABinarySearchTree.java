package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SearchInABinarySearchTree {

	// https://leetcode.com/submissions/detail/827626066/
	public static void main(String[] args) {
		SearchInABinarySearchTree test = new SearchInABinarySearchTree();
		System.out.println(test.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 2));
		System.out.println(test.searchBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 5));
	}

	public TreeNode searchBST(TreeNode root, int val) {
		while (root != null && root.val != val) {
			root = val < root.val ? root.left : root.right;
		}
		return root;
	}

}
