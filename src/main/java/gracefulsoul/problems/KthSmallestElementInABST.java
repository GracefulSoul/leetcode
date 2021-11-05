package gracefulsoul.problems;

import java.util.Stack;

import gracefulsoul.object.TreeNode;

public class KthSmallestElementInABST {

	// https://leetcode.com/submissions/detail/582204311/
	public static void main(String[] args) {
		KthSmallestElementInABST test = new KthSmallestElementInABST();
		System.out.println(test.kthSmallest(new TreeNode(3, new TreeNode(1, null, new TreeNode(2)), new TreeNode(4)), 1));
		System.out.println(test.kthSmallest(new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6)), 3));
	}

	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
		while (k != 0) {
			TreeNode n = stack.pop();
			if (--k == 0) {
				return n.val;
			}
			TreeNode right = n.right;
			while (right != null) {
				stack.push(right);
				right = right.left;
			}
		}
		return -1;
	}

}
