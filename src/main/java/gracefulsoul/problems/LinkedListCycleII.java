package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class LinkedListCycleII {

	// https://leetcode.com/submissions/detail/546937975/
	public static void main(String[] args) {
		LinkedListCycleII test = new LinkedListCycleII();
		ListNode listNode1 = new ListNode(2);
		listNode1.next = new ListNode(0, new ListNode(-4, listNode1));
		ListNode listNode2 = new ListNode(3, listNode1);
		print(listNode2, test.detectCycle(listNode2));
		ListNode listNode3 = new ListNode(1);
		listNode3.next = new ListNode(2, listNode3);
		print(listNode3, test.detectCycle(listNode3));
		ListNode listNode4 = new ListNode(1);
		print(listNode4, test.detectCycle(listNode4));
	}

	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow) {
				ListNode search = head;
				while (slow != search) {
					slow = slow.next;
					search = search.next;
				}
				return search;
			}
		}
		return null;
	}
	
	private static void print(ListNode head, ListNode cycle) {
		int idx = 0;
		while (head != cycle) {
			head = head.next;
			idx++;
		}
		System.out.println(cycle == null ? -1 : idx);
	}

}
