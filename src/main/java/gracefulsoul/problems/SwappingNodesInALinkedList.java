package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class SwappingNodesInALinkedList {

	// https://leetcode.com/problems/swapping-nodes-in-a-linked-list/submissions/950712408/
	public static void main(String[] args) {
		SwappingNodesInALinkedList test = new SwappingNodesInALinkedList();
		System.out.println(test.swapNodes(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
		System.out.println(test.swapNodes(new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7,new ListNode(8, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5)))))))))), 5));
	}

	public ListNode swapNodes(ListNode head, int k) {
		ListNode first = null;
		ListNode last = null;
		for (ListNode listNode = head; listNode != null; listNode = listNode.next) {
			if (last != null) {
				last = last.next;
			}
			if (--k == 0) {
				first = listNode;
				last = head;
			}
		}
		int temp = first.val;
		first.val = last.val;
		last.val = temp;
		return head;
	}

}
