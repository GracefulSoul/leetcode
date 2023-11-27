package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class SplitLinkedListInParts {

	// https://leetcode.com/submissions/detail/842294041/
	public static void main(String[] args) {
		SplitLinkedListInParts test = new SplitLinkedListInParts();
		PrintUtil.print(test.splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3))), 5));
		PrintUtil.print(test.splitListToParts(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5,new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(9, new ListNode(10)))))))))), 3));
	}

	public ListNode[] splitListToParts(ListNode head, int k) {
		ListNode[] parts = new ListNode[k];
		int length = 0;
		for (ListNode node = head; node != null; node = node.next) {
			length++;
		}
		int quotient = length / k;
		int remainder = length % k;
		ListNode curr = head;
		ListNode prev = null;
		for (int i = 0; curr != null && i < k; i++, remainder--) {
			parts[i] = curr;
			for (int j = 0; j < quotient + (remainder > 0 ? 1 : 0); j++) {
				prev = curr;
				curr = curr.next;
			}
			prev.next = null;
		}
		return parts;
	}

}
