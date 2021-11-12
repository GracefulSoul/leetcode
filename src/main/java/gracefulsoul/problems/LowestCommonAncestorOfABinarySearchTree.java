package gracefulsoul.problems;

import gracefulsoul.object.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree {

	// https://leetcode.com/submissions/detail/585843867/
	public static void main(String[] args) {
		LowestCommonAncestorOfABinarySearchTree test = new LowestCommonAncestorOfABinarySearchTree();
		TreeNode treeNode1 = new TreeNode(4, new TreeNode(3), new TreeNode(5));
		TreeNode treeNode2 = new TreeNode(2, new TreeNode(0), treeNode1);
		TreeNode treeNode3 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
		TreeNode root = new TreeNode(6, treeNode2, treeNode3);
		System.out.println(test.lowestCommonAncestor(root, treeNode2, treeNode3).val);
		System.out.println(test.lowestCommonAncestor(root, treeNode2, treeNode1).val);
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while ((root.val - p.val) * (root.val - q.val) > 0) {
			root = root.val > p.val ? root.left : root.right;
		}
		return root;
	}

}
