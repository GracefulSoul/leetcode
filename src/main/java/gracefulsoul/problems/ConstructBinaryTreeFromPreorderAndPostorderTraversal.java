package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

	// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/submissions/924831980/
	public static void main(String[] args) {
		ConstructBinaryTreeFromPreorderAndPostorderTraversal test = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
		PrintUtil.print(test.constructFromPrePost(new int[] { 1, 2, 4, 5, 3, 6, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 }), true, false);
		PrintUtil.print(test.constructFromPrePost(new int[] { 1 }, new int[] { 1 }), true, false);
	}

	private int pre = 0;
	private int post = 0;

	public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
		TreeNode root = new TreeNode(preorder[this.pre++]);
		if (root.val != postorder[this.post]) {
			root.left = this.constructFromPrePost(preorder, postorder);
		}
		if (root.val != postorder[this.post]) {
			root.right = this.constructFromPrePost(preorder, postorder);
		}
		this.post++;
		return root;
	}

}
