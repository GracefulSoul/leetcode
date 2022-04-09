package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.object.node.TreeNode;
import gracefulsoul.util.PrintUtil;

public class ConvertSortedListToBinarySearchTree {

	// https://leetcode.com/submissions/detail/530474745/
	public static void main(String[] args) {
		ConvertSortedListToBinarySearchTree test = new ConvertSortedListToBinarySearchTree();
		PrintUtil.print(test.sortedListToBST(new ListNode(-10, new ListNode(-3, new ListNode(0, new ListNode(5, new ListNode(9)))))), true, false);
		PrintUtil.print(test.sortedListToBST(new ListNode()), true, false);
		PrintUtil.print(test.sortedListToBST(new ListNode(0)), true, false);
		PrintUtil.print(test.sortedListToBST(new ListNode(1, new ListNode(3))), true, false);
	}

	public TreeNode sortedListToBST(ListNode head) {
		return this.recursive(head, null);
	}

	private TreeNode recursive(ListNode head, ListNode tail) {
		if (head == null || head == tail) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode treeNode = new TreeNode(slow.val);
		treeNode.left = this.recursive(head, slow);
		treeNode.right = this.recursive(slow.next, tail);
		return treeNode;
	}

}
