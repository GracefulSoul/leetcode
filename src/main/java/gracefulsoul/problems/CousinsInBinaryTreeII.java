package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.Queue;

import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class CousinsInBinaryTreeII {

	// https://leetcode.com/problems/cousins-in-binary-tree-ii/submissions/1431221928/
	public static void main(String[] args) {
		CousinsInBinaryTreeII test = new CousinsInBinaryTreeII();
		PrintUtil.print(test.replaceValueInTree(new TreeNode(5, new TreeNode(4, new TreeNode(1), new TreeNode(10)), new TreeNode(9, null, new TreeNode(7)))), true, false);
		PrintUtil.print(test.replaceValueInTree(new TreeNode(3, new TreeNode(1), new TreeNode(2))), true, false);
	}

	public TreeNode replaceValueInTree(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int curr = root.val;
		while (!queue.isEmpty()) {
			int next = 0;
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				TreeNode left = node.left;
				TreeNode right = node.right;
				node.val = curr - node.val;
				if (left != null) {
					queue.offer(left);
					next += left.val;
				}
				if (right != null) {
					queue.offer(right);
					next += right.val;
				}
				if (left != null && right != null) {
					int sum = left.val + right.val;
					left.val = right.val = sum;
				}
			}
			curr = next;
		}
		return root;
	}

}
