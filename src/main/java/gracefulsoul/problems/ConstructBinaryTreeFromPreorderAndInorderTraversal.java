package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	// https://leetcode.com/submissions/detail/528473265/
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndInorderTraversal test = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
		PrintUtil.print(test.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 }), true, false);
		PrintUtil.print(test.buildTree(new int[] { -1 }, new int[] { -1 }), true, false);
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int idx = 0; idx < inorder.length; idx++) {
			inorderMap.put(inorder[idx], idx);
		}
		return this.recursive(preorder, inorderMap, 0, preorder.length - 1, 0);
	}

	private TreeNode recursive(int[] preorder, Map<Integer, Integer> inorderMap, int preStart, int preEnd, int inStart) {
		if (preStart > preEnd) {
			return null;
		}
		TreeNode treeNode = new TreeNode(preorder[preStart]);
		int inOrderIndex = inorderMap.get(treeNode.val);
		int numsLeft = inOrderIndex - inStart;
		treeNode.left = this.recursive(preorder, inorderMap, preStart + 1, preStart + numsLeft, inStart);
		treeNode.right = this.recursive(preorder, inorderMap, preStart + numsLeft + 1, preEnd, inOrderIndex + 1);
		return treeNode;
	}

}
