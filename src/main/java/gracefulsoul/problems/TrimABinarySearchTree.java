package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class TrimABinarySearchTree {

	// https://leetcode.com/submissions/detail/805989501/
	public static void main(String[] args) {
		TrimABinarySearchTree test = new TrimABinarySearchTree();
		PrintUtil.print(test.trimBST(new TreeNode(1, new TreeNode(0), new TreeNode(2)), 1, 2), true, false);
		PrintUtil.print(test.trimBST(new TreeNode(3, new TreeNode(0, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4)), 1, 3), true, false);
	}

	public TreeNode trimBST(TreeNode root, int low, int high) {
		if (root == null) {
			return null;
		} else if (root.val < low) {
			return this.trimBST(root.right, low, high);
		} else if (root.val > high) {
			return this.trimBST(root.left, low, high);
		} else {
			root.left = this.trimBST(root.left, low, high);
			root.right = this.trimBST(root.right, low, high);
			return root;
		}
	}

}
