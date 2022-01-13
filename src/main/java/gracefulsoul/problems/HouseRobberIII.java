package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class HouseRobberIII {

	// https://leetcode.com/submissions/detail/618697308/
	public static void main(String[] args) {
		HouseRobberIII test = new HouseRobberIII();
		System.out.println(test.rob(new TreeNode(3, new TreeNode(2, null, new TreeNode(3)), new TreeNode(3, null, new TreeNode(1)))));
		System.out.println(test.rob(new TreeNode(3, new TreeNode(4, new TreeNode(1), new TreeNode(3)), new TreeNode(5, null, new TreeNode(1)))));
	}

	public int rob(TreeNode root) {
		int[] result = this.recursive(root);
		return Math.max(result[0], result[1]);
	}

	private int[] recursive(TreeNode root) {
		int[] result = new int[2];
		if (root == null) {
			return result;
		}
		int[] left = this.recursive(root.left);
		int[] right = this.recursive(root.right);
		result[0] = root.val + left[1] + right[1];
		result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		return result;
	}

}
