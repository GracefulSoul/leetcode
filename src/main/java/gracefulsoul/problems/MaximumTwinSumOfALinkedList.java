package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class MaximumTwinSumOfALinkedList {

	// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/submissions/952024973/
	public static void main(String[] args) {
		MaximumTwinSumOfALinkedList test = new MaximumTwinSumOfALinkedList();
		System.out.println(test.pairSum(new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))))));
		System.out.println(test.pairSum(new ListNode(1, new ListNode(100000))));
	}

	public int pairSum(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		ListNode curr = head;
		while (fast != null) {
			fast = fast.next.next;
			curr = slow;
			slow = slow.next;
			curr.next = prev;
			prev = curr;
		}
		int result = 0;
		while (slow != null) {
			result = Math.max(result, prev.val + slow.val);
			slow = slow.next;
			prev = prev.next;
		}
		return result;
	}

}
