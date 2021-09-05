package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class InsertionSortList {

	public static void main(String[] args) {
		InsertionSortList test = new InsertionSortList();
		print(test.insertionSortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
		print(test.insertionSortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))))));
	}

	// https://leetcode.com/submissions/detail/549720352/
	public ListNode insertionSortList(ListNode head) {
		ListNode curr = head;
		ListNode next = null;
		ListNode result = new ListNode();
		ListNode temp = null;
		while (curr != null) {
			next = curr.next;
			temp = result;
			while (temp.next != null && temp.next.val < curr.val) {
				temp = temp.next;
			}
			curr.next = temp.next;
			temp.next = curr;
			curr = next;
		}
		return result.next;
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
			if (listNode != null) {
				System.out.print(", ");
			}
		}
	}

}
