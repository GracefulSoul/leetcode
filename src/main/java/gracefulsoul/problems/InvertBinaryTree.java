package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class InvertBinaryTree {

	// https://leetcode.com/submissions/detail/580299155/
	public static void main(String[] args) {
		InvertBinaryTree test = new InvertBinaryTree();
		print(test.invertTree(new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(7, new TreeNode(6), new TreeNode(9)))), true, false);
		System.out.println();
		print(test.invertTree(new TreeNode(2, new TreeNode(1), new TreeNode(3))), true, false);
	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		} else if (root.left != null || root.right != null) {
			TreeNode left = root.left;
			root.left = this.invertTree(root.right);
			root.right = this.invertTree(left);
		}
		return root;
	}

	private static void print(TreeNode treeNode, boolean isRoot, boolean isLeft) {
		if (treeNode != null) {
			if (!isRoot) {
				System.out.print("(");
			}
			print(treeNode.left, false, true);
			print(treeNode.val);
			System.out.print(", ");
			print(treeNode.right, false, false);
			if (!isRoot) {
				System.out.print(")");
			}
		} else {
			print("null");
		}
		if (isLeft) {
			System.out.print(", ");
		}
	}

	private static void print(Object val) {
		System.out.print("(" + val + ")");
	}

}
