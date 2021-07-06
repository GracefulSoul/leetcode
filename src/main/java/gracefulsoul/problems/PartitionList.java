package gracefulsoul.problems;

import gracefulsoul.object.ListNode;

public class PartitionList {

	// https://leetcode.com/submissions/detail/518055175/
	public static void main(String[] args) {
		PartitionList test = new PartitionList();
		print(test.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
	}

	public ListNode partition(ListNode head, int x) {
		ListNode result = new ListNode();
		result.next = head;
		ListNode temp = result;
		ListNode pointer = result;
		while (pointer.next != null) {
			if (pointer.next.val < x) {
				if (pointer == temp) {
					pointer = pointer.next;
				} else if (temp.next != null && pointer.next != null) {
					this.swap(temp, pointer);
				}
				temp = temp.next;
			} else {
				pointer = pointer.next;
			}
		}
		return result.next;
	}

	private void swap(ListNode ln1, ListNode ln2) {
		ListNode ln1Next = ln1.next;
		ListNode ln2Next = ln2.next;
		ln2.next = ln2Next.next;
		ln2Next.next = ln1Next;
		ln1.next = ln2Next;
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
