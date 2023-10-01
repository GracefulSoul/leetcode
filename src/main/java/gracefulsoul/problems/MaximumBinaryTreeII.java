package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class MaximumBinaryTreeII {

	// https://leetcode.com/problems/maximum-binary-tree-ii/submissions/1063657701/
	public static void main(String[] args) {
		MaximumBinaryTreeII test = new MaximumBinaryTreeII();
		PrintUtil.print(test.insertIntoMaxTree(new TreeNode(4, new TreeNode(1), new TreeNode(3, new TreeNode(2), null)), 5), true, false);
		PrintUtil.print(test.insertIntoMaxTree(new TreeNode(5, new TreeNode(2, null, new TreeNode(1)), new TreeNode(4)), 3), true, false);
		PrintUtil.print(test.insertIntoMaxTree(new TreeNode(5, new TreeNode(2, null, new TreeNode(1)), new TreeNode(3)), 4), true, false);
	}

	public TreeNode insertIntoMaxTree(TreeNode root, int val) {
		if (root == null || val > root.val) {
			TreeNode treeNode = new TreeNode(val);
			treeNode.left = root;
			return treeNode;
		} else {
			root.right = this.insertIntoMaxTree(root.right, val);
			return root;
		}
	}

}
