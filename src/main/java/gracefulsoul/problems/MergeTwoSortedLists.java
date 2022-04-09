package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class MergeTwoSortedLists {

	// https://leetcode.com/submissions/detail/487337839/
	public static void main(String[] args) {
		MergeTwoSortedLists test = new MergeTwoSortedLists();
		PrintUtil.print(test.mergeTwoLists(new ListNode(1, new ListNode(2, new ListNode(4, null))), new ListNode(1, new ListNode(3, new ListNode(4, null)))));
		PrintUtil.print(test.mergeTwoLists(new ListNode(), new ListNode()));
		PrintUtil.print(test.mergeTwoLists(new ListNode(), new ListNode(0)));
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