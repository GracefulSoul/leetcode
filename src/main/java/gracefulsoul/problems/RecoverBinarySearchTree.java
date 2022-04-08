package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;

public class RecoverBinarySearchTree {

	// https://leetcode.com/submissions/detail/524830104/
	public static void main(String[] args) {
		RecoverBinarySearchTree test = new RecoverBinarySearchTree();
		TreeNode treeNode1 = new TreeNode(1, new TreeNode(3, null, new TreeNode(2)), null);
		test.recoverTree(treeNode1);
		print(treeNode1, true, false);
		System.out.println();
		TreeNode treeNode2 = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
		test.recoverTree(treeNode2);
		print(treeNode2, true, false);
		System.out.println();
	}

	public void recoverTree(TreeNode root) {
		TreeNode previous = null;
		TreeNode first = null;
		TreeNode second = null;
		TreeNode temp = null;
		while (root != null) {
			if (root.left != null) {
				temp = root.left;
				while (temp.right != null && temp.right != root) {
					temp = temp.right;
				}
				if (temp.right != null) {
					if (previous != null && previous.val > root.val) {
						if (first == null) {
							first = previous;
						}
						second = root;
					}
					previous = root;
					temp.right = null;
					root = root.right;
				} else {
					temp.right = root;
					root = root.left;
				}
			} else {
				if (previous != null && previous.val > root.val) {
					if (first == null) {
						first = previous;
					}
					second = root;
				}
				previous = root;
				root = root.right;
			}
		}
		if (first != null && second != null) {
			int tempVal = first.val;
			first.val = second.val;
			second.val = tempVal;
		}
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
