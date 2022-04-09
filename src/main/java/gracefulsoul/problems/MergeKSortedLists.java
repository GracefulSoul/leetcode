package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class MergeKSortedLists {

	// https://leetcode.com/submissions/detail/487692525/
	public static void main(String[] args) {
		MergeKSortedLists test = new MergeKSortedLists();
		PrintUtil.print(test.mergeKLists(new ListNode[] { new ListNode(1, new ListNode(4, new ListNode(5))), new ListNode(1, new ListNode(3, new ListNode(4))), new ListNode(2, new ListNode(6)) }));
		PrintUtil.print(test.mergeKLists(new ListNode[] {}));
		PrintUtil.print(test.mergeKLists(new ListNode[] { new ListNode() }));
	}

	public ListNode mergeKLists(ListNode[] lists) {
		return this.mergeListsRecursion(lists, 0, lists.length - 1);
	}

	private ListNode mergeListsRecursion(ListNode[] lists, int start, int end) {
		if (start == end) {
			return lists[start];
		} else if (start < end) {
			int half = (start + end) / 2;
			ListNode l1 = this.mergeListsRecursion(lists, start, half);
			ListNode l2 = this.mergeListsRecursion(lists, half + 1, end);
			return this.mergeTwoLists(l1, l2);
		} else {
			return null;
		}
	}

	private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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