package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class PathSum {

	// https://leetcode.com/submissions/detail/531831278/
	public static void main(String[] args) {
		PathSum test = new PathSum();
		System.out.println(test.hasPathSum(new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1)))), 22));
		System.out.println(test.hasPathSum(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 5));
		System.out.println(test.hasPathSum(new TreeNode(1, new TreeNode(2), null), 0));
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null && targetSum - root.val == 0) {
			return true;
		} else {
			int sum = targetSum - root.val;
			return this.hasPathSum(root.left, sum) || this.hasPathSum(root.right, sum);
		}
	}

}
