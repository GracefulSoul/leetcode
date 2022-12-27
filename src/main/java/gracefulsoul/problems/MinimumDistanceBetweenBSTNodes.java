package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class MinimumDistanceBetweenBSTNodes {

	// https://leetcode.com/problems/minimum-distance-between-bst-nodes/submissions/865549066/
	public static void main(String[] args) {
		MinimumDistanceBetweenBSTNodes test = new MinimumDistanceBetweenBSTNodes();
		System.out.println(test.minDiffInBST(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
		System.out.println(test.minDiffInBST(new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)))));
	}

	private int min = Integer.MAX_VALUE;
	private int pre = -1;

	public int minDiffInBST(TreeNode root) {
		if (root.left != null) {
			this.minDiffInBST(root.left);
		}
		if (this.pre != -1) {
			this.min = Math.min(this.min, root.val - this.pre);
		}
		this.pre = root.val;
		if (root.right != null) {
			this.minDiffInBST(root.right);
		}
		return this.min;
	}

}
