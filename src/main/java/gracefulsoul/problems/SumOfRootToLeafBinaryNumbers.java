package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SumOfRootToLeafBinaryNumbers {

	// https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/submissions/1147678631/
	public static void main(String[] args) {
		SumOfRootToLeafBinaryNumbers test = new SumOfRootToLeafBinaryNumbers();
		System.out.println(test.sumRootToLeaf(new TreeNode(1, new TreeNode(0, new TreeNode(0), new TreeNode(1)), new TreeNode(1, new TreeNode(0), new TreeNode(1)))));
		System.out.println(test.sumRootToLeaf(new TreeNode(1)));
	}

	public int sumRootToLeaf(TreeNode root) {
		return this.dfs(root, 0);
	}

	private int dfs(TreeNode root, int val) {
		if (root == null) {
			return 0;
		} else {
			val = (val * 2) + root.val;
			return root.left == root.right ? val : this.dfs(root.left, val) + this.dfs(root.right, val);
		}
	}

}
