package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class InsertIntoABinarySearchTree {

	// https://leetcode.com/submissions/detail/828508648/
	public static void main(String[] args) {
		InsertIntoABinarySearchTree test = new InsertIntoABinarySearchTree();
		System.out.println(test.insertIntoBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7)), 5));
		System.out.println(test.insertIntoBST(new TreeNode(40, new TreeNode(20, new TreeNode(10), new TreeNode(30)), new TreeNode(60, new TreeNode(50), new TreeNode(70))), 25));
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		} else if (root.val > val) {
			root.left = this.insertIntoBST(root.left, val);
		} else {
			root.right = this.insertIntoBST(root.right, val);
		}
		return root;
	}

}
