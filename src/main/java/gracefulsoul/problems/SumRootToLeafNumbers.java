package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class SumRootToLeafNumbers {

	// https://leetcode.com/submissions/detail/540187160/
	public static void main(String[] args) {
		SumRootToLeafNumbers test = new SumRootToLeafNumbers();
		System.out.println(test.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))));
		System.out.println(test.sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))));
	}

	public int sumNumbers(TreeNode root) {
		return this.recursive(root, 0);
	}

	private int recursive(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		} else if (node.left == null && node.right == null) {
			return sum * 10 + node.val;
		} else {
			return this.recursive(node.left, sum * 10 + node.val) + this.recursive(node.right, sum * 10 + node.val);
		}
	}

}
