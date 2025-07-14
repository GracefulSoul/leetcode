package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

	// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/submissions/1697560799/
	public static void main(String[] args) {
		ConvertBinaryNumberInALinkedListToInteger test = new ConvertBinaryNumberInALinkedListToInteger();
		System.out.println(test.getDecimalValue(new ListNode(1, new ListNode(0, new ListNode(1)))));
		System.out.println(test.getDecimalValue(new ListNode(0)));
	}

	public int getDecimalValue(ListNode head) {
		int result = 0;
		while (head != null) {
			result *= 2;
			result += head.val;
			head = head.next;
		}
		return result;
	}

}
