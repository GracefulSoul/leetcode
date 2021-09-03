package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.TreeNode;

public class BinaryTreePostorderTraversal {

	// https://leetcode.com/submissions/detail/548623955/
	public static void main(String[] args) {
		BinaryTreePostorderTraversal test = new BinaryTreePostorderTraversal();
		System.out.println(test.postorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
		System.out.println(test.postorderTraversal(new TreeNode(1, new TreeNode(2), null)));
		System.out.println(test.postorderTraversal(new TreeNode(1, null, new TreeNode(2))));
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		return this.recursive(root, new ArrayList<>());
	}

	private List<Integer> recursive(TreeNode treeNode, List<Integer> list) {
		if (treeNode != null) {
			this.recursive(treeNode.left, list);
			this.recursive(treeNode.right, list);
			list.add(treeNode.val);
		}
		return list;
	}

}
