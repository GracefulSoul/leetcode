package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class InsertionSortList {

	public static void main(String[] args) {
		InsertionSortList test = new InsertionSortList();
		PrintUtil.print(test.insertionSortList(new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))))));
		PrintUtil.print(test.insertionSortList(new ListNode(-1, new ListNode(5, new ListNode(3, new ListNode(4, new ListNode(0)))))));
	}

	// https://leetcode.com/submissions/detail/549720352/
	public ListNode insertionSortList(ListNode head) {
		ListNode result = new ListNode();
		ListNode curr = head;
		ListNode next = null;
		ListNode temp = null;
		while (curr != null) {
			next = curr.next;
			temp = result;
			while (temp.next != null && temp.next.val < curr.val) {
				temp = temp.next;
			}
			curr.next = temp.next;
			temp.next = curr;
			curr = next;
		}
		return result.next;
	}

}
