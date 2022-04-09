package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class RemoveNthNodeFromEndOfList {

	// https://leetcode.com/submissions/detail/486695652/
	public static void main(String[] args) {
		RemoveNthNodeFromEndOfList test = new RemoveNthNodeFromEndOfList();
		PrintUtil.print(test.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode result = new ListNode(0, head);
		ListNode pointer = result;
		ListNode temp = result;
		for (int i = 0; i <= n; i++) {
			pointer = pointer.next;
		}
		while (pointer != null) {
			temp = temp.next;
			pointer = pointer.next;
		}
		temp.next = temp.next.next;
		return result.next;
	}

}
