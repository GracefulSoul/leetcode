package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;

public class AverageOfLevelsInBinaryTree {

	// https://leetcode.com/submissions/detail/782965294/
	public static void main(String[] args) {
		AverageOfLevelsInBinaryTree test = new AverageOfLevelsInBinaryTree();
		System.out.println(test.averageOfLevels(new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)))));
		System.out.println(test.averageOfLevels(new TreeNode(3, new TreeNode(9, new TreeNode(15), new TreeNode(7)), new TreeNode(20))));
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int count = size;
			double sum = 0;
			while (size-- > 0) {
				TreeNode treeNode = queue.poll();
				sum += treeNode.val;
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
			result.add(sum / count);
		}
		return result;
	}

}
