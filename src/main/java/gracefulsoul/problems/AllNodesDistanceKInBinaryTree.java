package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.TreeNode;

public class AllNodesDistanceKInBinaryTree {

	// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/submissions/910084313/
	public static void main(String[] args) {
		AllNodesDistanceKInBinaryTree test = new AllNodesDistanceKInBinaryTree();
		System.out.println(test.distanceK(new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8))), new TreeNode(5), 2));
		System.out.println(test.distanceK(new TreeNode(1), new TreeNode(1), 3));
	}

	public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
		List<Integer> result = new ArrayList<>();
		if (k == 0) {
			result.add(target.val);
		} else {
			this.dfs(root, target.val, k, 0, result);
		}
		return result;
	}

	private int dfs(TreeNode node, int target, int k, int depth, List<Integer> result) {
		if (node == null) {
			return 0;
		} else if (depth == k) {
			result.add(node.val);
			return 0;
		}
		int correction = node.val == target || depth > 0 ? 1 : 0;
		int left = this.dfs(node.left, target, k, depth + correction, result);
		int right = this.dfs(node.right, target, k, depth + correction, result);
		if (node.val == target) {
			return 1;
		} else if (left == k || right == k) {
			result.add(node.val);
			return 0;
		} else if (left > 0) {
			this.dfs(node.right, target, k, left + 1, result);
			return left + 1;
		} else if (right > 0) {
			this.dfs(node.left, target, k, right + 1, result);
			return right + 1;
		} else {
			return 0;
		}
	}

}
