package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class CountCompleteTreeNodes {

	// https://leetcode.com/submissions/detail/578414775/
	public static void main(String[] args) {
		CountCompleteTreeNodes test = new CountCompleteTreeNodes();
		System.out.println(test.countNodes(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
		System.out.println(test.countNodes(null));
		System.out.println(test.countNodes(new TreeNode(1)));
	}

//	Default
//	public int countNodes(TreeNode root) {
//		return root == null ? 0 : 1 + this.countNodes(root.left) + this.countNodes(root.right);
//	}

	public int countNodes(TreeNode root) {
		int depth = this.getDepth(root);
		if (depth == 0) {
			return 0;
		} else {
			if (this.getDepth(root.right) == depth - 1) {
				return (1 << depth - 1) + this.countNodes(root.right);
			} else {
				return (1 << depth - 2) + this.countNodes(root.left);
			}
		}
	}

	private int getDepth(TreeNode root) {
		return root == null ? 0 : 1 + this.getDepth(root.left);
	}

}
