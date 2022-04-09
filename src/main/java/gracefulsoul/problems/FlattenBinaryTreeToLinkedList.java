package gracefulsoul.problems;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class FlattenBinaryTreeToLinkedList {

	// https://leetcode.com/submissions/detail/532960140/
	public static void main(String[] args) {
		FlattenBinaryTreeToLinkedList test = new FlattenBinaryTreeToLinkedList();
		TreeNode treeNode1 = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
		test.flatten(treeNode1);
		PrintUtil.print(treeNode1, true, false);
		TreeNode treeNode2 = new TreeNode();
		test.flatten(treeNode2);
		PrintUtil.print(treeNode2, true, false);
		TreeNode treeNode3 = new TreeNode(0);
		test.flatten(treeNode3);
		PrintUtil.print(treeNode3, true, false);
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

}
