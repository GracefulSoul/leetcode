package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class PalindromeLinkedList {

	// https://leetcode.com/submissions/detail/584758469/
	public static void main(String[] args) {
		PalindromeLinkedList test = new PalindromeLinkedList();
		System.out.println(test.isPalindrome(new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))))));
		System.out.println(test.isPalindrome(new ListNode(1, new ListNode(2))));
	}

	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			ListNode temp = prev;
			prev = slow;
			slow = slow.next;
			prev.next = temp;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (prev != null && prev.val == slow.val) {
			slow = slow.next;
			prev = prev.next;
		}
		return prev == null;
	}

}
