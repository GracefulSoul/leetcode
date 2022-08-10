package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class MergeTwoBinaryTrees {

	// https://leetcode.com/submissions/detail/770067658/
	public static void main(String[] args) {
		MergeTwoBinaryTrees test = new MergeTwoBinaryTrees();
		PrintUtil.print(test.mergeTrees(new TreeNode(1, new TreeNode(3, new TreeNode(5), null), new TreeNode(2)), new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(5, null, new TreeNode(7)))), true, false);
		PrintUtil.print(test.mergeTrees(new TreeNode(1), new TreeNode(1, new TreeNode(2), null)), true, false);
	}

	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}
		root1.val += root2.val;
		root1.left = this.mergeTrees(root1.left, root2.left);
		root1.right = this.mergeTrees(root1.right, root2.right);
		return root1;
	}

}
