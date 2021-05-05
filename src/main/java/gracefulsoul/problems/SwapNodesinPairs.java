package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

import gracefulsoul.object.ListNode;

public class SwapNodesinPairs {

	// https://leetcode.com/submissions/detail/488972679/
	public static void main(String[] args) {
		SwapNodesinPairs test = new SwapNodesinPairs();
		print(test.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
		print(test.swapPairs(new ListNode(1, new ListNode(2, new ListNode(3, null)))));
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		List<Integer> list = this.getValuesInListNodeToList(head);
		ListNode ln = null;
		for (int idx = list.size(); idx > 0; idx--) {
			ln = new ListNode(list.get(idx - 1), ln);
		}
		return ln;
	}
	
	private List<Integer> getValuesInListNodeToList(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while (head != null) {
			if (head.next == null) {
				list.add(head.val);
				head = head.next;
			} else {
				list.add(head.next.val);
				list.add(head.val);
				head = head.next.next;
			}
		}
		return list;
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
