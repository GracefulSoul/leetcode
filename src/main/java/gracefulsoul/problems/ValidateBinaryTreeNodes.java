package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

public class ValidateBinaryTreeNodes {

	// https://leetcode.com/problems/validate-binary-tree-nodes/submissions/1077612912/
	public static void main(String[] args) {
		ValidateBinaryTreeNodes test = new ValidateBinaryTreeNodes();
		System.out.println(test.validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, -1, -1, -1 }));
		System.out.println(test.validateBinaryTreeNodes(4, new int[] { 1, -1, 3, -1 }, new int[] { 2, 3, -1, -1 }));
		System.out.println(test.validateBinaryTreeNodes(2, new int[] { 1, 0 }, new int[] { -1, -1 }));
	}

	public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
		int[] edges = new int[n];
		for (int i = 0; i < n; i++) {
			if (leftChild[i] != -1) {
				edges[leftChild[i]]++;
			}
			if (rightChild[i] != -1) {
				edges[rightChild[i]]++;
			}
		}
		int root = -1;
		for (int i = 0; i < n && root == -1; i++) {
			if (edges[i] == 0) {
				root = i;
			}
		}
		if (root == -1) {
			return false;
		} else {
			Queue<Integer> queue = new LinkedList<>();
			boolean[] visited = new boolean[n];
			queue.offer(root);
			while (!queue.isEmpty()) {
				int size = queue.size();
				for (int i = 0; i < size; i++) {
					int node = queue.poll();
					if (visited[node]) {
						return false;
					}
					visited[node] = true;
					n--;
					if (leftChild[node] != -1) {
						queue.offer(leftChild[node]);
					}
					if (rightChild[node] != -1) {
						queue.offer(rightChild[node]);
					}
				}
			}
			return n == 0;
		}
	}

}
