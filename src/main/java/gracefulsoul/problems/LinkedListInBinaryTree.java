package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.object.node.TreeNode;

public class LinkedListInBinaryTree {

	// https://leetcode.com/problems/linked-list-in-binary-tree/submissions/1381610395/
	public static void main(String[] args) {
		LinkedListInBinaryTree test = new LinkedListInBinaryTree();
		System.out.println(test.isSubPath(new ListNode(4, new ListNode(2, new ListNode(8))),
				new TreeNode(1, new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4,
						new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null))));
		System.out.println(test.isSubPath(new ListNode(4, new ListNode(2, new ListNode(6))),
				new TreeNode(1, new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4,
						new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null))));
		System.out.println(test.isSubPath(new ListNode(1, new ListNode(4, new ListNode(2, new ListNode(6, new ListNode(8))))),
				new TreeNode(1, new TreeNode(4, null, new TreeNode(2, new TreeNode(1), null)), new TreeNode(4,
						new TreeNode(2, new TreeNode(6), new TreeNode(8, new TreeNode(1), new TreeNode(3))), null))));
	}

	public boolean isSubPath(ListNode head, TreeNode root) {
		List<Integer> nums = new ArrayList<>();
		List<Integer> dp = new ArrayList<>();
		nums.add(head.val);
		dp.add(0);
		int i = 0;
		while ((head = head.next) != null) {
			while (i > 0 && head.val != nums.get(i)) {
				i = dp.get(i - 1);
			}
			if (head.val == nums.get(i)) {
				i++;
			}
			nums.add(head.val);
			dp.add(i);
		}
		return this.dfs(root, nums, dp, 0);
	}

	private boolean dfs(TreeNode root, List<Integer> nums, List<Integer> dp, int i) {
		if (root == null) {
			return false;
		} else {
			while (i > 0 && root.val != nums.get(i)) {
				i = dp.get(i - 1);
			}
			if (root.val == nums.get(i)) {
				i++;
			}
			return i == dp.size() || this.dfs(root.left, nums, dp, i) || this.dfs(root.right, nums, dp, i);
		}
	}

}
