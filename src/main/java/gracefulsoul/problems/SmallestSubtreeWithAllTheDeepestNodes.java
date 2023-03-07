package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SmallestSubtreeWithAllTheDeepestNodes {

	// https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/submissions/910765273/
	public static void main(String[] args) {
		SmallestSubtreeWithAllTheDeepestNodes test = new SmallestSubtreeWithAllTheDeepestNodes();
		System.out.println(test.subtreeWithAllDeepest(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)))));
		System.out.println(test.subtreeWithAllDeepest(new TreeNode(1)));
		System.out.println(test.subtreeWithAllDeepest(new TreeNode(0, new TreeNode(1, null, new TreeNode(2)), new TreeNode(3))));
	}

	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		if (root == null) {
			return null;
		}
		int left = this.getDepth(root.left);
		int right = this.getDepth(root.right);
		if (left > right) {
			return this.subtreeWithAllDeepest(root.left);
		} else if (left < right) {
			return this.subtreeWithAllDeepest(root.right);
		} else {
			return root;
		}
	}

	private int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(this.getDepth(root.left), this.getDepth(root.right)) + 1;
		}
	}

}
