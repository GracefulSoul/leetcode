package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;

public class MaximumLevelSumOfABinaryTree {

	// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/submissions/1355210252/
	public static void main(String[] args) {
		MaximumLevelSumOfABinaryTree test = new MaximumLevelSumOfABinaryTree();
		System.out.println(test.maxLevelSum(new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0))));
		System.out.println(test.maxLevelSum(new TreeNode(989, null, new TreeNode(10250, new TreeNode(98693), new TreeNode(-89388, null, new TreeNode(-32127))))));
	}

	public int maxLevelSum(TreeNode root) {
		int result = 1;
		int max = Integer.MIN_VALUE;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		for (int i = 1; !queue.isEmpty(); i++) {
			int sum = 0;
			for (int size = queue.size(); size > 0; size--) {
				TreeNode node = queue.poll();
				sum += node.val;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (max < sum) {
				max = sum;
				result = i;
			}
		}
		return result;
	}

}
