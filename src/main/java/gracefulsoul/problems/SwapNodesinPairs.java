package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class SwapNodesinPairs {

	public static void main(String[] args) {
		SwapNodesinPairs test = new SwapNodesinPairs();
		print(test.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
		print(test.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, null)))));
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode n = head.next;
		head.next = swapPairs(head.next.next);
		n.next = head;
		return n;
	}

	private static void print(ListNode listNode) {
		if (listNode != null) {
			System.out.printf("%d ", listNode.val);
			print(listNode.next);
		} else {
			System.out.println();
		}
	}

}
