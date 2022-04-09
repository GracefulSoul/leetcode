package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class InvertBinaryTree {

	// https://leetcode.com/submissions/detail/580299155/
	public static void main(String[] args) {
		InvertBinaryTree test = new InvertBinaryTree();
		PrintUtil.print(test.invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)))), true, false);
		System.out.println();
		PrintUtil.print(test.invertTree(new TreeNode(2, new TreeNode(1), new TreeNode(3))), true, false);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		} else if (root.left != null || root.right != null) {
			TreeNode left = root.left;
			root.left = this.invertTree(root.right);
			root.right = this.invertTree(left);
		}
		return root;
	}

}
