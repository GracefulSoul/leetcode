package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class RangeSumOfBST {

	// https://leetcode.com/problems/range-sum-of-bst/submissions/982259826/
	public static void main(String[] args) {
		RangeSumOfBST test = new RangeSumOfBST();
		System.out.println(test.rangeSumBST(new TreeNode(10, new TreeNode(5, new TreeNode(3), new TreeNode(7)), new TreeNode(15, null, new TreeNode(18))), 7, 15));
		System.out.println(test.rangeSumBST(new TreeNode(10, new TreeNode(5, new TreeNode(3, new TreeNode(1), null), new TreeNode(7, new TreeNode(6), null)), new TreeNode(15, new TreeNode(13), new TreeNode(18))), 7, 15));
	}

	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null) {
			return 0;
		} else if (root.val > high) {
			return this.rangeSumBST(root.left, low, high);
		} else if (root.val < low) {
			return this.rangeSumBST(root.right, low, high);
		} else {
			return root.val + this.rangeSumBST(root.left, low, high) + this.rangeSumBST(root.right, low, high);
		}
	}

}
