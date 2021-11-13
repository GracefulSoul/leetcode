package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

	// https://leetcode.com/submissions/detail/586287147/
	public static void main(String[] args) {
		LowestCommonAncestorOfABinaryTree test = new LowestCommonAncestorOfABinaryTree();
		TreeNode treeNode1 = new TreeNode(4);
		TreeNode treeNode2 = new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), treeNode1));
		TreeNode treeNode3 = new TreeNode(1, new TreeNode(0), new TreeNode(8));
		TreeNode root1 = new TreeNode(3, treeNode2, treeNode3);
		System.out.println(test.lowestCommonAncestor(root1, treeNode2, treeNode3).val);
		System.out.println(test.lowestCommonAncestor(root1, treeNode2, treeNode1).val);
		TreeNode treeNode4 = new TreeNode(2);
		TreeNode root2 = new TreeNode(1, treeNode4, null);
		System.out.println(test.lowestCommonAncestor(root2, root2, treeNode4).val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		} else {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);
			if (left == null) {
				return right;
			} else if (right == null) {
				return left;
			} else {
				return root;
			}
		}
	}

}
