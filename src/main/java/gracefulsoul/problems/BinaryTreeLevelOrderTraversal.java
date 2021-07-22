package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.TreeNode;

public class BinaryTreeLevelOrderTraversal {

	// https://leetcode.com/submissions/detail/526359175/
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal test = new BinaryTreeLevelOrderTraversal();
		print(test.levelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		print(test.levelOrder(new TreeNode(1)));
		print(test.levelOrder(new TreeNode()));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		this.recursive(root, result, 0);
		return result;
	}

	private void recursive(TreeNode treeNode, List<List<Integer>> result, int level) {
		if (treeNode == null) {
			return;
		}
		if (result.size() < level + 1) {
			result.add(new ArrayList<>());
		}
		result.get(level).add(treeNode.val);
		this.recursive(treeNode.left, result, level + 1);
		this.recursive(treeNode.right, result, level + 1);
	}

	private static void print(List<List<Integer>> lists) {
		for (List<Integer> list : lists) {
			System.out.print(list);
		}
		System.out.println();
	}

}
