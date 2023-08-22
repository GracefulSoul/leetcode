package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class DistributeCoinsInBinaryTree {

	// https://leetcode.com/problems/distribute-coins-in-binary-tree/submissions/1028463957/
	public static void main(String[] args) {
		DistributeCoinsInBinaryTree test = new DistributeCoinsInBinaryTree();
		System.out.println(test.distributeCoins(new TreeNode(3, new TreeNode(0), new TreeNode(0))));
		System.out.println(test.distributeCoins(new TreeNode(0, new TreeNode(3), new TreeNode(0))));
	}

	private int result;

	public int distributeCoins(TreeNode root) {
		this.result = 0;
		this.dfs(root);
		return this.result;
	}

	private int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = this.dfs(root.left);
			int right = this.dfs(root.right);
			this.result += Math.abs(left) + Math.abs(right);
			return root.val + left + right - 1;
		}
	}

}
