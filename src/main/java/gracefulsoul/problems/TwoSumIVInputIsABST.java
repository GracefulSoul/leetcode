package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class TwoSumIVInputIsABST {

	// https://leetcode.com/submissions/detail/795158029/
	public static void main(String[] args) {
		TwoSumIVInputIsABST test = new TwoSumIVInputIsABST();
		System.out.println(test.findTarget(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 9));
		System.out.println(test.findTarget(new TreeNode(5, new TreeNode(3, new TreeNode(2), new TreeNode(4)), new TreeNode(6, null, new TreeNode(7))), 28));
	}

	public boolean findTarget(TreeNode root, int k) {
		return this.dfs(root, root, k);
	}

	private boolean dfs(TreeNode root, TreeNode curr, int k) {
		if (curr == null) {
			return false;
		} else {
			return this.search(root, curr, k - curr.val)
					|| this.dfs(root, curr.left, k)
					|| this.dfs(root, curr.right, k);
		}
	}

	private boolean search(TreeNode root, TreeNode curr, int k) {
		if (root == null) {
			return false;
		} else {
			return ((root.val == k) && (root != curr))
					|| ((root.val < k) && this.search(root.right, curr, k))
					|| ((root.val > k) && this.search(root.left, curr, k));
		}
	}

}
