package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class FlipBinaryTreeToMatchPreorderTraversal {

	// https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/submissions/1015535309/
	public static void main(String[] args) {
		FlipBinaryTreeToMatchPreorderTraversal test = new FlipBinaryTreeToMatchPreorderTraversal();
		System.out.println(test.flipMatchVoyage(new TreeNode(1, new TreeNode(2), null), new int[] { 2, 1 }));
		System.out.println(test.flipMatchVoyage(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new int[] { 1, 3, 2 }));
		System.out.println(test.flipMatchVoyage(new TreeNode(1, new TreeNode(2), new TreeNode(3)), new int[] { 1, 2, 3 }));
	}

	private int index;

	public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
		this.index = 0;
		List<Integer> result = new ArrayList<>();
		return this.dfs(root, voyage, result) ? result : Arrays.asList(-1);
	}

	private boolean dfs(TreeNode node, int[] voyage, List<Integer> result) {
		if (node == null) {
			return true;
		} else if (node.val != voyage[index++]) {
			return false;
		} else if (node.left != null && node.left.val != voyage[index]) {
			result.add(node.val);
			return this.dfs(node.right, voyage, result) && this.dfs(node.left, voyage, result);
		} else {
			return this.dfs(node.left, voyage, result) && this.dfs(node.right, voyage, result);
		}
	}

}
