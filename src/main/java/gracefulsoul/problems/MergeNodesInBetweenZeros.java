package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class MergeNodesInBetweenZeros {

	// https://leetcode.com/problems/merge-nodes-in-between-zeros/submissions/1309222219/
	public static void main(String[] args) {
		MergeNodesInBetweenZeros test = new MergeNodesInBetweenZeros();
		PrintUtil.print(test.mergeNodes(new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0))))))))));
		PrintUtil.print(test.mergeNodes(new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(0))))))))));
	}

	public ListNode mergeNodes(ListNode head) {
		ListNode temp = head.next;
		ListNode next = temp;
		while (next != null) {
			int sum = 0;
			while (next.val != 0) {
				sum += next.val;
				next = next.next;
			}
			temp.val = sum;
			next = next.next;
			temp.next = next;
			temp = temp.next;
		}
		return head.next;
	}

}
