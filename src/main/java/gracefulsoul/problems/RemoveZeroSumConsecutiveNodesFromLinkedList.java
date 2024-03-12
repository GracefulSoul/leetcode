package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {

	// https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list/submissions/1201384225/
	public static void main(String[] args) {
		RemoveZeroSumConsecutiveNodesFromLinkedList test = new RemoveZeroSumConsecutiveNodesFromLinkedList();
		PrintUtil.print(test.removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(-3, new ListNode(3, new ListNode(1)))))));
		PrintUtil.print(test.removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(4)))))));
		PrintUtil.print(test.removeZeroSumSublists(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(-2)))))));
	}

	public ListNode removeZeroSumSublists(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode curr = head;
		int sum = 0;
		while (curr != null) {
			sum += curr.val;
			if (sum == 0) {
				return this.removeZeroSumSublists(curr.next);
			} else {
				curr = curr.next;
			}
		}
		head.next = this.removeZeroSumSublists(head.next);
		return head;
	}

}
