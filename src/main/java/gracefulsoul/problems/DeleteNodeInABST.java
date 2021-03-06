package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class DeleteNodeInABST {

	// https://leetcode.com/submissions/detail/676682079/
	public static void main(String[] args) {
		DeleteNodeInABST test = new DeleteNodeInABST();
		PrintUtil.print(test.deleteNode(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 3), true, false);
		PrintUtil.print(test.deleteNode(new TreeNode(5, new TreeNode(2, null, new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 0), true, false);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		} else if (key < root.val) {
			root.left = this.deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = this.deleteNode(root.right, key);
		} else if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		} else {
			root.val = this.findMinValue(root.right);
			root.right = this.deleteNode(root.right, root.val);
		}
		return root;
	}

	private int findMinValue(TreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root.val;
	}

}
