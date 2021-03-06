package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class RemoveDuplicatesFromSortedList {

	// https://leetcode.com/submissions/detail/516540403/
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
		PrintUtil.print(test.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2)))));
		PrintUtil.print(test.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))))));
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

}
