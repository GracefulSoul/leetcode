package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class RecoverATreeFromPreorderTraversal {

	// https://leetcode.com/problems/recover-a-tree-from-preorder-traversal/submissions/1153445603/
	public static void main(String[] args) {
		RecoverATreeFromPreorderTraversal test = new RecoverATreeFromPreorderTraversal();
		System.out.println(test.recoverFromPreorder("1-2--3--4-5--6--7"));
		System.out.println(test.recoverFromPreorder("1-2--3---4-5--6---7"));
		System.out.println(test.recoverFromPreorder("1-401--349---90--88"));
	}

	private int index = 0;

	public TreeNode recoverFromPreorder(String traversal) {
		return this.dfs(traversal, 0);
	}

	private TreeNode dfs(String traversal, int depth) {
		int num = 0;
		while (this.index + num < traversal.length() && traversal.charAt(this.index + num) == '-') {
			num++;
		}
		if (num != depth) {
			return null;
		}
		int next = this.index + num;
		while (next < traversal.length() && traversal.charAt(next) != '-') {
			next++;
		}
		int val = Integer.parseInt(traversal.substring(this.index + num, next));
		this.index = next;
		TreeNode root = new TreeNode(val);
		root.left = this.dfs(traversal, depth + 1);
		root.right = this.dfs(traversal, depth + 1);
		return root;
	}

}
