package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class RemoveNodesFromLinkedList {

	// https://leetcode.com/problems/remove-nodes-from-linked-list/submissions/1250452814/
	public static void main(String[] args) {
		RemoveNodesFromLinkedList test = new RemoveNodesFromLinkedList();
		PrintUtil.print(test.removeNodes(new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))))));
		PrintUtil.print(test.removeNodes(new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))));
	}

	public ListNode removeNodes(ListNode head) {
		if (head != null) {
			head.next = this.removeNodes(head.next);
			if (head.next != null && head.val < head.next.val) {
				return head.next;
			}
		}
		return head;
	}

}
