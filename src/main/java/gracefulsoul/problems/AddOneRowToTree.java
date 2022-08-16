package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class AddOneRowToTree {

	// https://leetcode.com/submissions/detail/775049230/
	public static void main(String[] args) {
		AddOneRowToTree test = new AddOneRowToTree();
		PrintUtil.print(test.addOneRow(new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), new TreeNode(6, new TreeNode(5), null)), 1, 2), true, false);
		PrintUtil.print(test.addOneRow(new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), null), 1, 3), true, false);
	}

	public TreeNode addOneRow(TreeNode root, int val, int depth) {
		if (root != null) {
			if (depth == 1) {
				TreeNode treeNode = new TreeNode(val);
				treeNode.left = root;
				return treeNode;
			} else if (depth == 2) {
				TreeNode left = new TreeNode(val);
				left.left = root.left;
				TreeNode right = new TreeNode(val);
				right.right = root.right;
				root.left = left;
				root.right = right;
			} else {
				root.left = this.addOneRow(root.left, val, depth - 1);
				root.right = this.addOneRow(root.right, val, depth - 1);
			}
		}
		return root;
	}

}
