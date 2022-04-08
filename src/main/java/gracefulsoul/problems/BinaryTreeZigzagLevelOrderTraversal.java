package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class BinaryTreeZigzagLevelOrderTraversal {

	// https://leetcode.com/submissions/detail/526784911/
	public static void main(String[] args) {
		BinaryTreeZigzagLevelOrderTraversal test = new BinaryTreeZigzagLevelOrderTraversal();
		System.out.println(test.zigzagLevelOrder(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.zigzagLevelOrder(new TreeNode(1)));
		System.out.println(test.zigzagLevelOrder(new TreeNode()));
	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
		if (level % 2 == 0) {
			result.get(level).add(treeNode.val);
		} else {
			result.get(level).add(0, treeNode.val);
		}
		this.recursive(treeNode.left, result, level + 1);
		this.recursive(treeNode.right, result, level + 1);
	}

}
