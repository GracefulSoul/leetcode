package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.TreeNode;

public class BinaryTreeInorderTraversal {

	// https://leetcode.com/submissions/detail/522184336/
	public static void main(String[] args) {
		BinaryTreeInorderTraversal test = new BinaryTreeInorderTraversal();
		System.out.println(test.inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null))));
		System.out.println(test.inorderTraversal(new TreeNode(1, new TreeNode(2), null)));
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		this.recursive(result, root);
		return result;
	}

	private void recursive(List<Integer> result, TreeNode node) {
		if (node != null) {
			this.recursive(result, node.left);
			result.add(node.val);
			this.recursive(result, node.right);
		}
	}

}
