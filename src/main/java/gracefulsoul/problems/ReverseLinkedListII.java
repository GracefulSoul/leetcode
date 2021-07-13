package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class ReverseLinkedListII {

	// https://leetcode.com/submissions/detail/521220264/
	public static void main(String[] args) {
		ReverseLinkedListII test = new ReverseLinkedListII();
		print(test.reverseBetween(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2, 4));
//		print(test.reverseBetween(new ListNode(5), 1, 1));
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode temp = new ListNode(0, head);
		ListNode pre = temp;
		ListNode cur = head;
		int idx = 1;
		while (cur.next != null && idx != left) {
			cur = cur.next;
			pre = pre.next;
			idx++;
		}
		while (cur.next != null && idx != right) {
			ListNode preNext = pre.next;
			ListNode curNext = cur.next;
			pre.next = cur.next;
			cur.next = curNext.next;
			curNext.next = preNext;
			idx++;
		}
		return temp.next;
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
