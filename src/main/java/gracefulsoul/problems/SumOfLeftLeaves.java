package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class SumOfLeftLeaves {

	// https://leetcode.com/submissions/detail/653095449/
	public static void main(String[] args) {
		SumOfLeftLeaves test = new SumOfLeftLeaves();
		System.out.println(test.sumOfLeftLeaves(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.sumOfLeftLeaves(new TreeNode(1)));
	}

	public int sumOfLeftLeaves(TreeNode root) {
		return this.recursive(root, false);
	}

	private int recursive(TreeNode root, boolean isLeft) {
		if (root == null) {
			return 0;
		} else {
			if (root.left == null && root.right == null) {
				return isLeft ? root.val : 0;
			} else {
				return this.recursive(root.left, true) + this.recursive(root.right, false);
			}
		}
	}

}
