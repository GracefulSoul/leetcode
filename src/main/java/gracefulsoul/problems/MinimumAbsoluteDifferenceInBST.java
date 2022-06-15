package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class MinimumAbsoluteDifferenceInBST {

	// https://leetcode.com/submissions/detail/722799319/
	public static void main(String[] args) {
		System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(6))));
		System.out.println(new MinimumAbsoluteDifferenceInBST().getMinimumDifference(new TreeNode(1, new TreeNode(0), new TreeNode(48, new TreeNode(12), new TreeNode(49)))));
	}

	private int min = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root) {
		this.dfs(root, null);
		return this.min;
	}

	private TreeNode dfs(TreeNode root, TreeNode prev) {
		if (root == null) {
			return prev;
		}
		prev = this.dfs(root.left, prev);
		if (prev != null) {
			this.min = Math.min(this.min, Math.abs(root.val - prev.val));
		}
		return this.dfs(root.right, root);
	}

}
