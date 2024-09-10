package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class InsertGreatestCommonDivisorsInLinkedList {

	// https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list/submissions/1385177379/
	public static void main(String[] args) {
		InsertGreatestCommonDivisorsInLinkedList test = new InsertGreatestCommonDivisorsInLinkedList();
		PrintUtil.print(test.insertGreatestCommonDivisors(new ListNode(18, new ListNode(6, new ListNode(10, new ListNode(3))))));
		PrintUtil.print(test.insertGreatestCommonDivisors(new ListNode(7)));
	}

	public ListNode insertGreatestCommonDivisors(ListNode head) {
		if (head.next != null) {
			ListNode node = head;
			while (node.next != null) {
				ListNode temp = new ListNode(this.getGcd(node.val, node.next.val), node.next);
				node.next = temp;
				node = temp.next;
			}
		}
		return head;
	}

	private int getGcd(int m, int n) {
		if (n == 0) {
			return m;
		} else {
			return this.getGcd(n, m % n);
		}
	}

}
