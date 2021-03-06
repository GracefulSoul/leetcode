package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class AddTwoNumbers {

	// https://leetcode.com/submissions/detail/478103072/
	public static void main(String[] args) {
		AddTwoNumbers test = new AddTwoNumbers();
		test.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4))));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode();
		ListNode temp = listNode;
		int quotient = 0;
		while (l1 != null || l2 != null) {
			int sum = quotient + this.getValue(l1) + this.getValue(l2);
			quotient = sum / 10;
			temp.next = new ListNode(sum % 10);
			temp = temp.next;
			l1 = this.getNext(l1);
			l2 = this.getNext(l2);
		}
		if (quotient > 0) {
			temp.next = new ListNode(quotient);
		}
		return listNode.next;
	}

	private int getValue(ListNode listNode) {
		return listNode != null ? listNode.val : 0;
	}

	private ListNode getNext(ListNode listNode) {
		return listNode != null ? listNode.next : null;
	}

}
