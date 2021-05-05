package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

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
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			if (head.next == null) {
				list.add(head.val);
				head = head.next;
			} else {
				ListNode temp = head.next;
				list.add(temp.val);
				list.add(head.val);
				head = head.next.next;
			}
		}
		ListNode ln = null;
		for (int idx = list.size(); idx > 0; idx--) {
			ln = new ListNode(list.get(idx - 1), ln);
		}
		return ln;
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
