package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreeLevelOrderTraversalII {

	// https://leetcode.com/submissions/detail/529398676/
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversalII test = new BinaryTreeLevelOrderTraversalII();
		System.out.println(test.levelOrderBottom(new TreeNode(3, new TreeNode(9, new TreeNode(15), new TreeNode(7)), new TreeNode(20))));
		System.out.println(test.levelOrderBottom(new TreeNode(1)));
		System.out.println(test.levelOrderBottom(new TreeNode()));
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		this.recursive(root, result, 0);
		return result;
	}

	private void recursive(TreeNode treeNode, List<List<Integer>> result, int level) {
		if (treeNode == null) {
			return;
		}
		if (result.size() < level + 1) {
			result.add(0, new ArrayList<>());
		}
		this.recursive(treeNode.left, result, level + 1);
		this.recursive(treeNode.right, result, level + 1);
		result.get(result.size() - level - 1).add(treeNode.val);
	}

}
