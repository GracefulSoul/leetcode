package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class DoubleANumberRepresentedAsALinkedList {

	// https://leetcode.com/problems/double-a-number-represented-as-a-linked-list/submissions/1251623729/
	public static void main(String[] args) {
		DoubleANumberRepresentedAsALinkedList test = new DoubleANumberRepresentedAsALinkedList();
		PrintUtil.print(test.doubleIt(new ListNode(1, new ListNode(8, new ListNode(9)))));
		PrintUtil.print(test.doubleIt(new ListNode(9, new ListNode(9, new ListNode(9)))));
	}

	public ListNode doubleIt(ListNode head) {
		if (head.val > 4) {
			head = new ListNode(0, head);
		}
		for (ListNode temp = head; temp != null; temp = temp.next) {
			temp.val = (temp.val * 2) % 10;
			if (temp.next != null && temp.next.val > 4) {
				temp.val++;
			}
		}
		return head;
	}

}
