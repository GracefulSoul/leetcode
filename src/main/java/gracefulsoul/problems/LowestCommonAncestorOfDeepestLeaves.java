package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class LowestCommonAncestorOfDeepestLeaves {

	// https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/submissions/1287915135/
	public static void main(String[] args) {
		LowestCommonAncestorOfDeepestLeaves test = new LowestCommonAncestorOfDeepestLeaves();
		PrintUtil.print(test.lcaDeepestLeaves(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)))), true, false);
		PrintUtil.print(test.lcaDeepestLeaves(new TreeNode(1)), true, false);
	}

	private int level = 0;
	private TreeNode root;

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		this.dfs(root, 0);
		return this.root;
	}

	private int dfs(TreeNode node, int level) {
		this.level = Math.max(this.level, level);
		if (node == null) {
			return level;
		} else {
			int left = this.dfs(node.left, level + 1);
			int right = this.dfs(node.right, level + 1);
			if (left == this.level && right == this.level) {
				this.root = node;
			}
			return Math.max(left, right);
		}
	}

}
