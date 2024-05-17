package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class DeleteLeavesWithAGivenValue {

	// https://leetcode.com/problems/delete-leaves-with-a-given-value/submissions/1260447191/
	public static void main(String[] args) {
		DeleteLeavesWithAGivenValue test = new DeleteLeavesWithAGivenValue();
		PrintUtil.print(test.removeLeafNodes(new TreeNode(1, new TreeNode(2, new TreeNode(2), null), new TreeNode(3, new TreeNode(2), new TreeNode(4))), 2), true, false);
		PrintUtil.print(test.removeLeafNodes(new TreeNode(1, new TreeNode(3, new TreeNode(3), new TreeNode(2)), new TreeNode(3)), 3), true, false);
	}

	public TreeNode removeLeafNodes(TreeNode root, int target) {
		if (root.left != null) {
			root.left = this.removeLeafNodes(root.left, target);
		}
		if (root.right != null) {
			root.right = this.removeLeafNodes(root.right, target);
		}
		return root.left == root.right && root.val == target ? null : root;
	}

}
