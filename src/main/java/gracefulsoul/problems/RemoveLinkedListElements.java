package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class RemoveLinkedListElements {

	// https://leetcode.com/submissions/detail/567033188/
	public static void main(String[] args) {
		RemoveLinkedListElements test = new RemoveLinkedListElements();
		print(test.removeElements(new ListNode(1, new ListNode(2, new ListNode(6, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 6));
		print(test.removeElements(null, 1));
		print(test.removeElements(new ListNode(7, new ListNode(7, new ListNode(7, new ListNode(7)))), 7));
	}

	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return null;
		}
		ListNode next = this.removeElements(head.next, val);
		if (head.val == val) {
			return next;
		} else {
			head.next = next;
			return head;
		}
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
			if (listNode != null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
