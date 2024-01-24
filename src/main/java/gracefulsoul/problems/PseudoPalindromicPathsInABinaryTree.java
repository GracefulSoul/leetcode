package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class PseudoPalindromicPathsInABinaryTree {

	// https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/submissions/1155474239/
	public static void main(String[] args) {
		PseudoPalindromicPathsInABinaryTree test = new PseudoPalindromicPathsInABinaryTree();
		System.out.println(test.pseudoPalindromicPaths(new TreeNode(2, new TreeNode(3, new TreeNode(3), new TreeNode(1)), new TreeNode(1, null, new TreeNode(1)))));
		System.out.println(test.pseudoPalindromicPaths(new TreeNode(2, new TreeNode(1, new TreeNode(1), new TreeNode(3, null, new TreeNode(1))), new TreeNode(1))));
		System.out.println(test.pseudoPalindromicPaths(new TreeNode(9)));
	}

	public int pseudoPalindromicPaths(TreeNode root) {
		return this.dfs(root, 0);
	}

	private int dfs(TreeNode root, int count) {
		if (root == null) {
			return 0;
		}
		count ^= 1 << (root.val - 1);
		int result = this.dfs(root.left, count) + this.dfs(root.right, count);
		if (root.left == root.right && (count & (count - 1)) == 0) {
			result++;
		}
		return result;
	}

}
