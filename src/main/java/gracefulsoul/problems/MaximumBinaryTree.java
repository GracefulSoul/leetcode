package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class MaximumBinaryTree {

	// https://leetcode.com/submissions/detail/796999457/
	public static void main(String[] args) {
		MaximumBinaryTree test = new MaximumBinaryTree();
		PrintUtil.print(test.constructMaximumBinaryTree(new int[] { 3, 2, 1, 6, 0, 5 }), true, false);
		PrintUtil.print(test.constructMaximumBinaryTree(new int[] { 3, 2, 1 }), true, false);
	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		TreeNode root = new TreeNode(Integer.MAX_VALUE);
		this.recursive(nums, root, 0);
		return root.right;
	}

	private int recursive(int[] nums, TreeNode root, int index) {
		while (index > -1 && index < nums.length) {
			if (nums[index] < root.val) {
				TreeNode curr = new TreeNode(nums[index]);
				TreeNode right = root.right;
				root.right = curr;
				curr.left = right;
				index = this.recursive(nums, curr, index + 1);
			} else {
				return index;
			}
		}
		return -1;
	}

}
