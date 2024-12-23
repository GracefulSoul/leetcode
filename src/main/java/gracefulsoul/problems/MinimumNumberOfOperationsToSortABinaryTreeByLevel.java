package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;

public class MinimumNumberOfOperationsToSortABinaryTreeByLevel {

	// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level/submissions/1486131932/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToSortABinaryTreeByLevel test = new MinimumNumberOfOperationsToSortABinaryTreeByLevel();
		System.out.println(test.minimumOperations(new TreeNode(1, new TreeNode(4, new TreeNode(7), new TreeNode(6)), new TreeNode(3, new TreeNode(8, new TreeNode(9), null), new TreeNode(5, new TreeNode(10), null)))));
		System.out.println(test.minimumOperations(new TreeNode(1, new TreeNode(3, new TreeNode(7), new TreeNode(6)), new TreeNode(2, new TreeNode(5), new TreeNode(4)))));
		System.out.println(test.minimumOperations(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
	}

	public int minimumOperations(TreeNode root) {
		Queue<TreeNode> queue = new ArrayDeque<>();
		int result = 0;
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int[] arr = new int[size];
			int[] sort = new int[size];
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				arr[i] = sort[i] = curr.val;
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			Arrays.sort(sort);
			Map<Integer, Integer> map = new HashMap<>();
			for (int i = 0; i < size; i++) {
				map.put(sort[i], i);
			}
			for (int i = 0; i < size; i++) {
				while (arr[i] != sort[i]) {
					int j = map.get(arr[i]);
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					result++;
				}
			}
		}
		return result;
	}

}
