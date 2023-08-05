package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreeCameras {

	// https://leetcode.com/problems/binary-tree-cameras/submissions/1012535198/
	public static void main(String[] args) {
		BinaryTreeCameras test = new BinaryTreeCameras();
		System.out.println(test.minCameraCover(new TreeNode(0, new TreeNode(-1, new TreeNode(0), new TreeNode(0)), null)));
		System.out.println(test.minCameraCover(new TreeNode(0, new TreeNode(-1, new TreeNode(0, null, new TreeNode(-1, null, new TreeNode(0))), null), null)));
	}

	private int result = 0;

	public int minCameraCover(TreeNode root) {
		this.result = 0;
		return (dfs(root) < 1 ? 1 : 0) + this.result;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 2;
		}
		int left = this.dfs(root.left);
		int right = this.dfs(root.right);
		if (left == 0 || right == 0) {
			this.result++;
			return 1;
		}
		return left == 1 || right == 1 ? 2 : 0;
	}

}
