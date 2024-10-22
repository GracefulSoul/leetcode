package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;

public class KthLargestSumInABinaryTree {

	// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/submissions/1430216236/
	public static void main(String[] args) {
		KthLargestSumInABinaryTree test = new KthLargestSumInABinaryTree();
		System.out.println(test.kthLargestLevelSum(new TreeNode(5, new TreeNode(8, new TreeNode(2, new TreeNode(4), new TreeNode(6)), new TreeNode(1)), new TreeNode(9, new TreeNode(3), new TreeNode(7))), 2));
		System.out.println(test.kthLargestLevelSum(new TreeNode(1, new TreeNode(2, new TreeNode(3), null), null), 1));
	}

	public long kthLargestLevelSum(TreeNode root, int k) {
		Queue<Long> result = new PriorityQueue<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			long sum = 0;
			while (size-- > 0) {
				TreeNode temp = queue.poll();
				sum += temp.val;
				if (temp.left != null) {
					queue.add(temp.left);
				}
				if (temp.right != null) {
					queue.add(temp.right);
				}
			}
			result.add(sum);
			if (result.size() > k) {
				result.poll();
			}
		}
		return result.size() < k ? -1 : result.peek();
	}

}
