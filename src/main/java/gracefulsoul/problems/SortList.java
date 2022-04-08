package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class SortList {

	// https://leetcode.com/submissions/detail/550127723/
	public static void main(String[] args) {
		SortList test = new SortList();
		print(test.sortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
//		print(test.sortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))))));
	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode prev = null;
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			prev = slow;
			fast = fast.next.next;
			slow = slow.next;
		}
		prev.next = null;
		return this.merge(this.sortList(head), this.sortList(slow));
	}

	private ListNode merge(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode();
		ListNode temp = listNode;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				temp.next = l1;
				l1 = l1.next;
			} else {
				temp.next = l2;
				l2 = l2.next;
			}
			temp = temp.next;
		}
		if (l1 != null) {
			temp.next = l1;
		}
		if (l2 != null) {
			temp.next = l2;
		}
		return listNode.next;
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
