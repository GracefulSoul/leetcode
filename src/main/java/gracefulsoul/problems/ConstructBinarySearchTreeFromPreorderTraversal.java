package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/1097021993/
	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorderTraversal test = new ConstructBinarySearchTreeFromPreorderTraversal();
		PrintUtil.print(test.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 }), true, false);
		PrintUtil.print(test.bstFromPreorder(new int[] { 1, 3 }), true, false);
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		return this.bst(preorder, Integer.MAX_VALUE, new int[] { 0 });
	}

	private TreeNode bst(int[] preorder, int bound, int[] i) {
		if (i[0] == preorder.length || bound < preorder[i[0]]) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[i[0]++]);
		root.left = this.bst(preorder, root.val, i);
		root.right = this.bst(preorder, bound, i);
		return root;
	}

}
