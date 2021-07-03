package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class RemoveDuplicatesFromSortedList {

	// https://leetcode.com/submissions/detail/516540403/
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
		print(test.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2)))));
		print(test.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
	}

	public ListNode deleteDuplicates(ListNode head) {
		return this.recursive(head);
	}

	private ListNode recursive(ListNode head) {
		if (head == null) {
			return null;
		} else {
			if ((head.next != null && head.val == head.next.val)) {
				return this.recursive(head.next);
			} else {
				head.next = this.recursive(head.next);
				return head;
			}
		}
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			if (listNode.next != null) {
				System.out.print(",");
			}
			listNode = listNode.next;
		}
		System.out.println();
	}

}
