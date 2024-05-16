package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class EvaluateBooleanBinaryTree {

	// https://leetcode.com/problems/evaluate-boolean-binary-tree/submissions/1259343388/
	public static void main(String[] args) {
		EvaluateBooleanBinaryTree test = new EvaluateBooleanBinaryTree();
		System.out.println(test.evaluateTree(new TreeNode(2, new TreeNode(1), new TreeNode(3, new TreeNode(0), new TreeNode(3)))));
		System.out.println(test.evaluateTree(new TreeNode()));
	}

	public boolean evaluateTree(TreeNode root) {
		if (root.left == null && root.right == null) {
			return root.val == 1;
		} else {
			boolean left = this.evaluateTree(root.left);
			boolean right = this.evaluateTree(root.right);
			return root.val == 2 ? left || right : left && right;
		}
	}

}
