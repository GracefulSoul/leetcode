package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class LinkedListCycle {

	// https://leetcode.com/submissions/detail/546457252/
	public static void main(String[] args) {
		LinkedListCycle test = new LinkedListCycle();
		ListNode listNode1 = new ListNode(2);
		listNode1.next = new ListNode(0, new ListNode(-4, listNode1));
		System.out.println(test.hasCycle(new ListNode(3, listNode1)));
		ListNode listNode2 = new ListNode(1);
		listNode2.next = new ListNode(2, listNode2);
		System.out.println(test.hasCycle(listNode2));
		System.out.println(test.hasCycle(new ListNode(1)));
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				return true;
			}
		}
		return false;
	}

}
