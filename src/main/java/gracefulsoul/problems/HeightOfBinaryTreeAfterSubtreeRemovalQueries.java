package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class HeightOfBinaryTreeAfterSubtreeRemovalQueries {

	// https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries/submissions/1433855345/
	public static void main(String[] args) {
		HeightOfBinaryTreeAfterSubtreeRemovalQueries test = new HeightOfBinaryTreeAfterSubtreeRemovalQueries();
		PrintUtil.print(test.treeQueries(new TreeNode(1, new TreeNode(3, new TreeNode(2), null), new TreeNode(4, new TreeNode(6), new TreeNode(5, null, new TreeNode(7)))), new int[] { 4 }));
		PrintUtil.print(test.treeQueries(new TreeNode(5, new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)), new TreeNode(9, new TreeNode(3), new TreeNode(7))), new int[] { 3, 2, 4, 8 }));
	}

	private int[] heights;
	private int max;

	public int[] treeQueries(TreeNode root, int[] queries) {
		this.heights = new int[100001];
		this.max = 0;
		this.calculateLeftToRight(root, 0);
		this.max = 0;
		this.calculateRightToLeft(root, 0);
		int length = queries.length;
		int[] result = new int[length];
		for (int i = length - 1; i >= 0; i--) {
			result[i] = this.heights[queries[i]];
		}
		return result;
	}

	private void calculateLeftToRight(TreeNode node, int height) {
		if (node != null) {
			this.heights[node.val] = this.max;
			this.max = Math.max(this.max, height);
			this.calculateLeftToRight(node.left, height + 1);
			this.calculateLeftToRight(node.right, height + 1);
		}
	}

	private void calculateRightToLeft(TreeNode node, int height) {
		if (node != null) {
			this.heights[node.val] = Math.max(this.heights[node.val], this.max);
			this.max = Math.max(this.max, height);
			this.calculateRightToLeft(node.right, height + 1);
			this.calculateRightToLeft(node.left, height + 1);
		}
	}

}
