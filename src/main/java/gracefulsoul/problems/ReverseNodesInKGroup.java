package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class ReverseNodesInKGroup {

	// https://leetcode.com/submissions/detail/489565583/
	public static void main(String[] args) {
		ReverseNodesInKGroup test = new ReverseNodesInKGroup();
		PrintUtil.print(test.reverseKGroup(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 3));
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode curr = head;
		int count = 0;
		while (curr != null && count != k) {
			curr = curr.next;
			count++;
		}
		if (count == k) {
			curr = this.reverseKGroup(curr, k);
			while (count-- > 0) {
				ListNode tmp = head.next;
				head.next = curr;
				curr = head;
				head = tmp;
			}
			head = curr;
		}
		return head;
	}

}
