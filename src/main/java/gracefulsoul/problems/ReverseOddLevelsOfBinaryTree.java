package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class ReverseOddLevelsOfBinaryTree {

	// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree/submissions/1483655049/
	public static void main(String[] args) {
		ReverseOddLevelsOfBinaryTree test = new ReverseOddLevelsOfBinaryTree();
		System.out.println(test.reverseOddLevels(new TreeNode(2, new TreeNode(3, new TreeNode(8), new TreeNode(13)), new TreeNode(5, new TreeNode(21), new TreeNode(34)))));
		System.out.println(test.reverseOddLevels(new TreeNode(7, new TreeNode(13), new TreeNode(11))));
		System.out.println(test.reverseOddLevels(new TreeNode(0, new TreeNode(2, new TreeNode(0, new TreeNode(2), new TreeNode(2)), new TreeNode(0, new TreeNode(2), new TreeNode(2))), new TreeNode(1, new TreeNode(0, new TreeNode(1), new TreeNode(1)), new TreeNode(0, new TreeNode(1), new TreeNode(1))))));
	}

	public TreeNode reverseOddLevels(TreeNode root) {
		this.dfs(root.left, root.right, 1);
		return root;
	}

	private void dfs(TreeNode node1, TreeNode node2, int level) {
		if (node1 != null && node2 != null) {
			if (level % 2 == 1) {
				int temp = node1.val;
				node1.val = node2.val;
				node2.val = temp;
			}
			this.dfs(node1.left, node2.right, level + 1);
			this.dfs(node1.right, node2.left, level + 1);
		}
	}

}
