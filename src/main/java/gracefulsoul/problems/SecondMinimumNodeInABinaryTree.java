package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SecondMinimumNodeInABinaryTree {

	// https://leetcode.com/submissions/detail/807183220/
	public static void main(String[] args) {
		SecondMinimumNodeInABinaryTree test = new SecondMinimumNodeInABinaryTree();
		System.out.println(test.findSecondMinimumValue(new TreeNode(2, new TreeNode(2), new TreeNode(5, new TreeNode(5), new TreeNode(7)))));
		System.out.println(test.findSecondMinimumValue(new TreeNode(2, new TreeNode(2), new TreeNode(2))));
	}

	public int findSecondMinimumValue(TreeNode root) {
		if (root == null) {
			return -1;
		} else {
			return this.dfs(root, root.val);
		}
	}

	private int dfs(TreeNode root, int min) {
		if (root == null) {
			return -1;
		} else if (root.val > min) {
			return root.val;
		} else {
			int left = this.dfs(root.left, min);
			int right = this.dfs(root.right, min);
			return left == -1 || right == -1 ? Math.max(left, right) : Math.min(left, right);
		}
	}

}
