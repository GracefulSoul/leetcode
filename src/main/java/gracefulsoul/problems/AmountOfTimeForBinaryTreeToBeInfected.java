package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class AmountOfTimeForBinaryTreeToBeInfected {

	// https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/submissions/1141976701/
	public static void main(String[] args) {
		AmountOfTimeForBinaryTreeToBeInfected test = new AmountOfTimeForBinaryTreeToBeInfected();
		System.out.println(test.amountOfTime(new TreeNode(1, new TreeNode(5, null, new TreeNode(4, new TreeNode(9), new TreeNode(2))), new TreeNode(3, new TreeNode(10), new TreeNode(6))), 3));
		System.out.println(test.amountOfTime(new TreeNode(1), 1));
	}

	private int amount;

	public int amountOfTime(TreeNode root, int start) {
		this.dfs(root, start);
		return this.amount;
	}

	private int dfs(TreeNode root, int start) {
		if (root == null) {
			return 0;
		}
		int left = this.dfs(root.left, start);
		int right = this.dfs(root.right, start);
		if (root.val == start) {
			this.amount = Math.max(left, right);
			return -1;
		} else if (left >= 0 && right >= 0) {
			return Math.max(left, right) + 1;
		} else {
			this.amount = Math.max(this.amount, Math.abs(left - right));
			return Math.min(left, right) - 1;
		}
	}

}
