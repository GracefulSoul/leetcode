package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class RotateList {

	// https://leetcode.com/submissions/detail/506375322/
	public static void main(String[] args) {
		RotateList test = new RotateList();
		print(test.rotateRight(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
//		print(test.rotateRight(new ListNode(0, new ListNode(1, new ListNode(2))), 4));
	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0) {
			return head;
		}
		ListNode temp = head;
		int size = 1;
		while (temp.next != null) {
			temp = temp.next;
			size++;
		}
		temp.next = head;
		for (int idx = 0; idx < size - (k % size); idx++) {
			temp = temp.next;
		}
		head = temp.next;
		temp.next = null;
		return head;
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			if (listNode.next != null) {
				System.out.print(",");
			}
			listNode = listNode.next;
		}
		System.out.println();
	}

}
