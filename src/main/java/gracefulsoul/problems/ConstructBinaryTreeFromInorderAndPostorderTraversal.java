package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	// https://leetcode.com/submissions/detail/528894574/
	public static void main(String[] args) {
		ConstructBinaryTreeFromInorderAndPostorderTraversal test = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
		print(test.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }), true, false);
		print(test.buildTree(new int[] { -1 }, new int[] { -1 }), true, false);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int idx = 0; idx < inorder.length; idx++) {
			inorderMap.put(inorder[idx], idx);
		}
		return this.recursive(postorder, inorderMap, 0, inorder.length - 1, 0, postorder.length - 1);
	}

	private TreeNode recursive(int[] postorder, Map<Integer, Integer> inorderMap, int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd) {
			return null;
		}
		TreeNode treeNode = new TreeNode(postorder[postEnd]);
		int inOrderIndex = inorderMap.get(treeNode.val);
		int numsLeft = inOrderIndex - inStart;
		treeNode.left = this.recursive(postorder, inorderMap, inStart, inOrderIndex - 1, postStart, postStart + numsLeft - 1);
		treeNode.right = this.recursive(postorder, inorderMap, inOrderIndex + 1, inEnd, postStart + numsLeft, postEnd - 1);
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
