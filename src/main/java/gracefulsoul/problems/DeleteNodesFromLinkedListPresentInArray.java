package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;
import gracefulsoul.util.PrintUtil;

public class DeleteNodesFromLinkedListPresentInArray {

	// https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array/submissions/1380908373/
	public static void main(String[] args) {
		DeleteNodesFromLinkedListPresentInArray test = new DeleteNodesFromLinkedListPresentInArray();
		PrintUtil.print(test.modifiedList(new int[] { 1, 2, 3 }, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))))));
		PrintUtil.print(test.modifiedList(new int[] { 1 }, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2, new ListNode(1, new ListNode(2))))))));
		PrintUtil.print(test.modifiedList(new int[] { 5 }, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))));
	}

	public ListNode modifiedList(int[] nums, ListNode head) {
		int max = -1;
		for (int num : nums) {
			max = num > max ? num : max;
		}
		boolean[] freq = new boolean[max + 1];
		for (int num : nums) {
			freq[num] = true;
		}
		ListNode temp = new ListNode();
		ListNode curr = temp;
		while (head != null) {
			if (head.val > max || freq[head.val] == false) {
				curr.next = head;
				curr = curr.next;
			}
			head = head.next;
		}
		curr.next = null;
		return temp.next;
	}

}
