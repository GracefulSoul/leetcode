package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class DiameterOfBinaryTree {

	// https://leetcode.com/submissions/detail/730480177/
	public static void main(String[] args) {
		DiameterOfBinaryTree test = new DiameterOfBinaryTree();
		System.out.println(test.diameterOfBinaryTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3))));
		System.out.println(test.diameterOfBinaryTree(new TreeNode(1, new TreeNode(2), null)));
	}

	public int diameterOfBinaryTree(TreeNode root) {
		int[] result = new int[1];
		this.dfs(root, result);
		return result[0];
	}

	private int dfs(TreeNode root, int[] result) {
		if (root == null) {
			return -1;
		} else {
			int left = this.dfs(root.left, result);
			int right = this.dfs(root.right, result);
			result[0] = Math.max(result[0], left + right + 2);
			return Math.max(left + 1, right + 1);
		}
	}

}
