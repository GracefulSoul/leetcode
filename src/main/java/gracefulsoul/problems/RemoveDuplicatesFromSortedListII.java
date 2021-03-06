package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class RemoveDuplicatesFromSortedListII {

	// https://leetcode.com/submissions/detail/515857149/
	public static void main(String[] args) {
		RemoveDuplicatesFromSortedListII test = new RemoveDuplicatesFromSortedListII();
		PrintUtil.print(test.deleteDuplicates(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))))));
		PrintUtil.print(test.deleteDuplicates(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))))));
	}

	public ListNode deleteDuplicates(ListNode head) {
		return this.recursive(head, null);
	}

	private ListNode recursive(ListNode head, ListNode previous) {
		if (head == null) {
			return null;
		} else {
			if ((head.next != null && head.val == head.next.val) || (previous != null && head.val == previous.val)) {
				return this.recursive(head.next, head);
			} else {
				head.next = this.recursive(head.next, head);
				return head;
			}
		}
	}

}
