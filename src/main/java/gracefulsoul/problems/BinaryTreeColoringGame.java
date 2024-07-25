package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreeColoringGame {

	// https://leetcode.com/problems/binary-tree-coloring-game/submissions/1332868270/
	public static void main(String[] args) {
		BinaryTreeColoringGame test = new BinaryTreeColoringGame();
		System.out.println(test.btreeGameWinningMove(new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(8), new TreeNode(9)), new TreeNode(5, new TreeNode(10), new TreeNode(11))), new TreeNode(3, new TreeNode(6), new TreeNode(7))), 11, 3));
		System.out.println(test.btreeGameWinningMove(new TreeNode(1, new TreeNode(2), new TreeNode(3)), 3, 1));
	}

	public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
		if (root == null) {
			return false;
		} else if (root.val == x) {
			int left = this.getCount(root.left);
			int right = this.getCount(root.right);
			int parent = n - (left + right + 1);
			return parent > (left + right) || left > (parent + right) || right > (left + parent);
		} else {
			return this.btreeGameWinningMove(root.left, n, x) || this.btreeGameWinningMove(root.right, n, x);
		}
	}

	private int getCount(TreeNode node) {
		if (node == null) {
			return 0;
		} else {
			return this.getCount(node.left) + this.getCount(node.right) + 1;
		}
	}

}
