package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class CompleteBinaryTreeInserter {

	// https://leetcode.com/problems/complete-binary-tree-inserter/submissions/946595762/
	public static void main(String[] args) {
		CBTInserter cBTInserter = new CBTInserter(new TreeNode(1, new TreeNode(2), null));
		System.out.println(cBTInserter.insert(3));				// return 1
		System.out.println(cBTInserter.insert(4));				// return 2
		PrintUtil.print(cBTInserter.get_root(), true, false);	// return [1, 2, 3, 4]
	}

}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {

	private Queue<TreeNode> queue;
	private TreeNode root;

	public CBTInserter(TreeNode root) {
		this.root = root;
		this.queue = new LinkedList<>();
		this.queue.offer(this.root);
		while (this.queue.peek().left != null && this.queue.peek().right != null) {
			TreeNode treeNode = this.queue.poll();
			this.queue.offer(treeNode.left);
			this.queue.offer(treeNode.right);
		}
		if (this.queue.peek().left != null) {
			this.queue.offer(this.queue.peek().left);
		}
	}

	public int insert(int val) {
		TreeNode treeNode = this.queue.peek();
		if (treeNode.left == null) {
			treeNode.left = new TreeNode(val);
			this.queue.offer(treeNode.left);
		} else {
			treeNode.right = new TreeNode(val);
			this.queue.poll();
			this.queue.offer(treeNode.right);
		}
		return treeNode.val;
	}

	public TreeNode get_root() {
		return this.root;
	}

}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */