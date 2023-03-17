package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class MiddleOfTheLinkedList {

	// https://leetcode.com/problems/middle-of-the-linked-list/submissions/917111684/
	public static void main(String[] args) {
		MiddleOfTheLinkedList test = new MiddleOfTheLinkedList();
		System.out.println(test.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
		System.out.println(test.middleNode(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))));
	}

	public ListNode middleNode(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

}
