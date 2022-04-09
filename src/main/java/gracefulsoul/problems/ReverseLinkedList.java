package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class ReverseLinkedList {

	// https://leetcode.com/submissions/detail/569213974/
	public static void main(String[] args) {
		ReverseLinkedList test = new ReverseLinkedList();
		PrintUtil.print(test.reverseList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
		PrintUtil.print(test.reverseList(new ListNode(1, new ListNode(2))));
		PrintUtil.print(test.reverseList(null));
	}

	public ListNode reverseList(ListNode head) {
		ListNode listNode = null;
		while (head != null) {
			ListNode temp = head.next;
			head.next = listNode;
			listNode = head;
			head = temp;
		}
		return listNode;
	}

}
