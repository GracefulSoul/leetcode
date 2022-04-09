package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class OddEvenLinkedList {

	// https://leetcode.com/submissions/detail/612825695/
	public static void main(String[] args) {
		OddEvenLinkedList test = new OddEvenLinkedList();
		PrintUtil.print(test.oddEvenList(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
		PrintUtil.print(test.oddEvenList(new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))))));
	}

	public ListNode oddEvenList(ListNode head) {
		if (head != null) {
			ListNode odd = head;
			ListNode even = head.next;
			ListNode temp = head.next;
			while (even != null && even.next != null) {
				odd.next = even.next;
				even.next = even.next.next;
				odd = odd.next;
				even = even.next;
			}
			odd.next = temp;
		}
		return head;
	}

}
