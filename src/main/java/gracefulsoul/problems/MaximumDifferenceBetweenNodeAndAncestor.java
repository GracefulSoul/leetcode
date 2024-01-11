package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class MaximumDifferenceBetweenNodeAndAncestor {

	// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/submissions/1142865196/
	public static void main(String[] args) {
		MaximumDifferenceBetweenNodeAndAncestor test = new MaximumDifferenceBetweenNodeAndAncestor();
		System.out.println(test.maxAncestorDiff(new TreeNode(8, new TreeNode(3, new TreeNode(1), new TreeNode(6, new TreeNode(4), new TreeNode(7))), new TreeNode(10, null, new TreeNode(14, new TreeNode(13), null)))));
		System.out.println(test.maxAncestorDiff(new TreeNode(1, null, new TreeNode(2, null, new TreeNode(0, new TreeNode(3), null)))));
	}

	public int maxAncestorDiff(TreeNode root) {
		return dfs(root, root.val, root.val);
	}

	private int dfs(TreeNode root, int max, int min) {
		if (root == null) {
			return max - min;
		} else {
			max = Math.max(max, root.val);
			min = Math.min(min, root.val);
			return Math.max(this.dfs(root.left, max, min), this.dfs(root.right, max, min));
		}
	}

}
