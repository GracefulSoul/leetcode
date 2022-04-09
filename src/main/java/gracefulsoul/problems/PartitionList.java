package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class PartitionList {

	// https://leetcode.com/submissions/detail/518146184/
	public static void main(String[] args) {
		PartitionList test = new PartitionList();
		PrintUtil.print(test.partition(new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2)))))), 3));
	}

	public ListNode partition(ListNode head, int x) {
		ListNode result = new ListNode(0, head);
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
		ListNode temp = ln2.next;
		ln2.next = temp.next;
		temp.next = ln1.next;
		ln1.next = temp;
	}

}
