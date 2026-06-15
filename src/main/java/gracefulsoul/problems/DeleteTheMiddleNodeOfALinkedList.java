package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class DeleteTheMiddleNodeOfALinkedList {

	// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/submissions/2033875115/
	public static void main(String[] args) {
		DeleteTheMiddleNodeOfALinkedList test = new DeleteTheMiddleNodeOfALinkedList();
		PrintUtil.print(test.deleteMiddle(new ListNode(1, new ListNode(3, new ListNode(4, new ListNode(7, new ListNode(1, new ListNode(2, new ListNode(6)))))))));
		PrintUtil.print(test.deleteMiddle(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
		PrintUtil.print(test.deleteMiddle(new ListNode(2, new ListNode(1))));
	}

	public ListNode deleteMiddle(ListNode head) {
		ListNode prev = new ListNode(0);
		prev.next = head;
		ListNode slow = prev;
		ListNode fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		slow.next = slow.next.next;
		return prev.next;
	}

}
