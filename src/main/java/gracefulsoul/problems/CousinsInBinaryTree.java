package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;

public class CousinsInBinaryTree {

	// https://leetcode.com/problems/cousins-in-binary-tree/submissions/1048241981/
	public static void main(String[] args) {
		CousinsInBinaryTree test = new CousinsInBinaryTree();
		System.out.println(test.isCousins(new TreeNode(1, new TreeNode(2, new TreeNode(4), null), new TreeNode(3)), 4, 3));
		System.out.println(test.isCousins(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3, null, new TreeNode(5))), 5, 4));
		System.out.println(test.isCousins(new TreeNode(1, new TreeNode(2, null, new TreeNode(4)), new TreeNode(3)), 2, 3));
	}

	public boolean isCousins(TreeNode root, int x, int y) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			boolean foundX = false;
			boolean foundY = false;
			for (int i = 0; i < size; i++) {
				TreeNode curr = queue.poll();
				if (curr.val == x) {
					foundX = true;
				}
				if (curr.val == y) {
					foundY = true;
				}
				if (curr.left != null && curr.right != null) {
					if ((curr.left.val == x && curr.right.val == y) || (curr.left.val == y && curr.right.val == x)) {
						return false;
					}
				}
				if (curr.left != null) {
					queue.offer(curr.left);
				}
				if (curr.right != null) {
					queue.offer(curr.right);
				}
			}
			if (foundX && foundY) {
				return true;
			}
		}
		return false;
	}
    
}
