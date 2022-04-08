package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class FlattenBinaryTreeToLinkedList {

	// https://leetcode.com/submissions/detail/532960140/
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
		test.flatten(treeNode1);
		print(treeNode1, true, false);
		TreeNode treeNode2 = new TreeNode();
		test.flatten(treeNode2);
		print(treeNode2, true, false);
		TreeNode treeNode3 = new TreeNode(0);
		test.flatten(treeNode3);
		print(treeNode3, true, false);
	}

	public void flatten(TreeNode root) {
		this.recursive(root, null);
	}

	private TreeNode recursive(TreeNode treeNode, TreeNode temp) {
		if (treeNode == null) {
			return temp;
		}
		treeNode.right = this.recursive(treeNode.left, this.recursive(treeNode.right, temp));
		treeNode.left = null;
		return treeNode;
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
		if (isRoot) {
			System.out.println();
		}
	}

	private static void print(Object val) {
		System.out.print("(" + val + ")");
	}

}
