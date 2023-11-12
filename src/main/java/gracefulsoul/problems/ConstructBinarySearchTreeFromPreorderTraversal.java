package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConstructBinarySearchTreeFromPreorderTraversal {

	// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/submissions/1096974151/
	public static void main(String[] args) {
		ConstructBinarySearchTreeFromPreorderTraversal test = new ConstructBinarySearchTreeFromPreorderTraversal();
		PrintUtil.print(test.bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 }), true, false);
		PrintUtil.print(test.bstFromPreorder(new int[] { 1, 3 }), true, false);
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		return this.bstFromPreorder(preorder, Integer.MAX_VALUE, new int[] { 0 });
	}

	private TreeNode bstFromPreorder(int[] preorder, int bound, int[] i) {
		if (i[0] == preorder.length || preorder[i[0]] > bound) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[i[0]++]);
		root.left = this.bstFromPreorder(preorder, root.val, i);
		root.right = this.bstFromPreorder(preorder, bound, i);
		return root;
	}

}
