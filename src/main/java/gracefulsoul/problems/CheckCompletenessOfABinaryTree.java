package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;

public class CheckCompletenessOfABinaryTree {

	// https://leetcode.com/problems/check-completeness-of-a-binary-tree/submissions/1003461143/
	public static void main(String[] args) {
		CheckCompletenessOfABinaryTree test = new CheckCompletenessOfABinaryTree();
		System.out.println(test.isCompleteTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, new TreeNode(6), null))));
		System.out.println(test.isCompleteTree(new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3, null, new TreeNode(7)))));
	}

	public boolean isCompleteTree(TreeNode root) {
		boolean lastNode = false;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode curr = queue.poll();
			if (curr == null) {
				lastNode = true;
			} else if (lastNode) {
				return false;
			} else {
				queue.add(curr.left);
				queue.add(curr.right);
			}
		}
		return true;
	}

}
