package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class SymmetricTree {

	// https://leetcode.com/submissions/detail/525723018/
	public static void main(String[] args) {
		SymmetricTree test = new SymmetricTree();
		System.out.println(test.isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)))));
		System.out.println(test.isSymmetric(new TreeNode(1, new TreeNode(2, null, new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)))));
	}

	public boolean isSymmetric(TreeNode root) {
		return this.recursive(root.left, root.right);
	}

	private boolean recursive(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		} else if (p == null || q == null) {
			return false;
		} else if (p.val == q.val) {
			return this.recursive(p.left, q.right) && this.recursive(p.right, q.left);
		} else {
			return false;
		}
	}

}
