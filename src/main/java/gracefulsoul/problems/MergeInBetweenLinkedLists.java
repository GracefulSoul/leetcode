package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class MergeInBetweenLinkedLists {

	// https://leetcode.com/problems/merge-in-between-linked-lists/submissions/1209080606/
	public static void main(String[] args) {
		MergeInBetweenLinkedLists test = new MergeInBetweenLinkedLists();
		PrintUtil.print(test.mergeInBetween(new ListNode(10, new ListNode(1, new ListNode(13, new ListNode(16, new ListNode(9, new ListNode(5)))))), 3, 4, new ListNode(1000000, new ListNode(1000001, new ListNode(1000002)))));
		PrintUtil.print(test.mergeInBetween(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))))), 2, 5, new ListNode(1000001, new ListNode(1000002, new ListNode(1000003, new ListNode(1000004))))));
	}

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode head = list1;
		for (int i = 1; i < a; i++) {
			head = head.next;
		}
		ListNode tail = head;
		for (int i = a; i <= b; i++) {
			tail = tail.next;
		}
		head.next = list2;
		while (list2.next != null) {
			list2 = list2.next;
		}
		list2.next = tail.next;
		return list1;
	}

}
