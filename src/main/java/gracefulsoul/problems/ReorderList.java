package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class ReorderList {

	// https://leetcode.com/submissions/detail/547526259/
	public static void main(String[] args) {
		ReorderList test = new ReorderList();
		ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
		test.reorderList(listNode1);
		print(listNode1);
		ListNode listNode2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
		test.reorderList(listNode2);
		print(listNode2);

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		ListNode node = this.reverseHalfAfterMiddleListNodes(head);
		ListNode temp1 = head;
		ListNode temp2 = node.next;
		while (temp1 != node) {
			node.next = temp2.next;
			temp2.next = temp1.next;
			temp1.next = temp2;
			temp1 = temp2.next;
			temp2 = node.next;
		}
	}

	private ListNode reverseHalfAfterMiddleListNodes(ListNode node) {
		ListNode mid = this.findMiddleListNode(node);
		ListNode cur = mid.next;
		while (cur.next != null) {
			ListNode temp = cur.next;
			cur.next = temp.next;
			temp.next = mid.next;
			mid.next = temp;
		}
		return mid;
	}

	private ListNode findMiddleListNode(ListNode node) {
		ListNode fast = node;
		ListNode slow = node;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	private static void print(ListNode node) {
		while (node != null) {
			System.out.print(node.val);
			if (node.next != null) {
				System.out.print(", ");
			}
			node = node.next;
		}
		System.out.println();
	}

}
