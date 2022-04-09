package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class IntersectionOfTwoLinkedLists {

	// https://leetcode.com/submissions/detail/553983942/
	public static void main(String[] args) {
		IntersectionOfTwoLinkedLists test = new IntersectionOfTwoLinkedLists();
		ListNode listNode1 = new ListNode(8, new ListNode(4, new ListNode(5)));
		PrintUtil.print(test.getIntersectionNode(new ListNode(4, new ListNode(1, listNode1)), new ListNode(5, new ListNode(6, new ListNode(1, listNode1)))));
		ListNode listNode2 = new ListNode(2, new ListNode(4));
		PrintUtil.print(test.getIntersectionNode(new ListNode(1, new ListNode(9, new ListNode(1, listNode2))), new ListNode(3, listNode2)));
		PrintUtil.print(test.getIntersectionNode(new ListNode(2, new ListNode(6, new ListNode(4))), new ListNode(1, new ListNode(5))));
	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode listNodeA = headA;
		ListNode listNodeB = headB;
		while (listNodeA != listNodeB) {
			listNodeA = listNodeA == null ? headB : listNodeA.next;
			listNodeB = listNodeB == null ? headA : listNodeB.next;
		}
		return listNodeA;
	}

}
