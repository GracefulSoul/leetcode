package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class MaximumProductOfSplittedBinaryTree {

	// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/submissions/1877366478/
	public static void main(String[] args) {
		MaximumProductOfSplittedBinaryTree test = new MaximumProductOfSplittedBinaryTree();
		System.out.println(test.maxProduct(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
		System.out.println(test.maxProduct(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), new TreeNode(4, new TreeNode(5), new TreeNode(6))))));
	}

	private long result;
	private long total;

	public int maxProduct(TreeNode root) {
		this.result = 0;
		this.total = this.dfs(root);
		this.dfs(root);
		return (int) (this.result % (int) (1000000007));
	}

	private long dfs(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			long sum = root.val + this.dfs(root.left) + this.dfs(root.right);
			this.result = Math.max(this.result, sum * (this.total - sum));
			return sum;
		}
	}

}
