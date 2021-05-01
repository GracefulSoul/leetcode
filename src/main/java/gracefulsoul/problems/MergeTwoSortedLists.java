package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class MergeTwoSortedLists {

	// https://leetcode.com/submissions/detail/487336661/
	public static void main(String[] args) {
		MergeTwoSortedLists test = new MergeTwoSortedLists();
		ListNode node1 = null;
		ListNode node2 = new ListNode(0, null);
		test.mergeTwoLists(node1, node2);

	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		} else if (l2 == null) {
			return l1;
		} else {
			if (l1.val < l2.val) {
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			} else {
				l2.next = mergeTwoLists(l1, l2.next);
				return l2;
			}
		}
	}

}