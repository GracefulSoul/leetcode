package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreePreorderTraversal {

	// https://leetcode.com/submissions/detail/548101028/
	public static void main(String[] args) {
		BinaryTreePreorderTraversal test = new BinaryTreePreorderTraversal();
		System.out.println(test.preorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
		System.out.println(test.preorderTraversal(new TreeNode(1, new TreeNode(2), null)));
		System.out.println(test.preorderTraversal(new TreeNode(1, null, new TreeNode(2))));
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		return this.recursive(root, new ArrayList<>());
	}

	private List<Integer> recursive(TreeNode treeNode, List<Integer> list) {
		if (treeNode != null) {
			list.add(treeNode.val);
			this.recursive(treeNode.left, list);
			this.recursive(treeNode.right, list);
		}
		return list;
	}

}
