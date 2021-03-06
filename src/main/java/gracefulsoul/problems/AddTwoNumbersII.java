package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class AddTwoNumbersII {

	// https://leetcode.com/submissions/detail/673560144/
	public static void main(String[] args) {
		AddTwoNumbersII test = new AddTwoNumbersII();
		PrintUtil.print(test.addTwoNumbers(new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))), new ListNode(5, new ListNode(6, new ListNode(4)))));
		PrintUtil.print(test.addTwoNumbers(new ListNode(2, new ListNode(4, new ListNode(3))), new ListNode(5, new ListNode(6, new ListNode(4)))));
		PrintUtil.print(test.addTwoNumbers(new ListNode(0), new ListNode(0)));
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = this.reverseList(l1);
		l2 = this.reverseList(l2);
		ListNode result = null;
		ListNode temp = result;
		int carry = 0;
		while (l1 != null && l2 != null) {
			int sum = carry + l1.val + l2.val;
			carry = sum / 10;
			ListNode listNode = new ListNode(sum % 10);
			if (result == null) {
				result = listNode;
				temp = result;
			} else {
				temp.next = listNode;
				temp = temp.next;
			}
			l1 = l1.next;
			l2 = l2.next;
		}
		while (l1 != null) {
			int sum = carry + l1.val;
			carry = sum / 10;
			temp.next = new ListNode(sum % 10);
			l1 = l1.next;
			temp = temp.next;
		}
		while (l2 != null) {
			int sum = carry + l2.val;
			carry = sum / 10;
			temp.next = new ListNode(sum % 10);
			l2 = l2.next;
			temp = temp.next;
		}
		while (carry != 0) {
			temp.next = new ListNode(carry % 10);
			carry /= 10;
			temp = temp.next;
		}
		return this.reverseList(result);
	}

	private ListNode reverseList(ListNode ls) {
		ListNode reverse = new ListNode(ls.val);
		while (ls.next != null) {
			ls = ls.next;
			reverse = new ListNode(ls.val, reverse);
		}
		return reverse;
	}

}
