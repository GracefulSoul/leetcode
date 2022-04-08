package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SameTree {

	// https://leetcode.com/submissions/detail/525281341/
	public static void main(String[] args) {
		SameTree test = new SameTree();
		System.out.println(test.isSameTree(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new TreeNode(1, new TreeNode(2), new TreeNode(3))));
		System.out.println(test.isSameTree(new TreeNode(1, new TreeNode(2), null), new TreeNode(1, null, new TreeNode(2))));
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val == q.val) {
			return this.isSameTree(p.left, q.left) && this.isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

}
