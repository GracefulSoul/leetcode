package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		DeleteNodeInALinkedList test = new DeleteNodeInALinkedList();
		ListNode listNode1 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
		test.deleteNode(listNode1);
		print(listNode1);
		ListNode listNode2 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
		test.deleteNode(listNode2);
		print(listNode2);
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

	private static void print(ListNode listNode) {
		while (listNode != null) {
			System.out.print(listNode.val);
			listNode = listNode.next;
			if (listNode != null) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
