package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class DeleteNodeInALinkedList {

	public static void main(String[] args) {
		DeleteNodeInALinkedList test = new DeleteNodeInALinkedList();
		ListNode listNode1 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
		test.deleteNode(listNode1);
		PrintUtil.print(listNode1);
		ListNode listNode2 = new ListNode(4, new ListNode(5, new ListNode(1, new ListNode(9))));
		test.deleteNode(listNode2);
		PrintUtil.print(listNode2);
	}

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
