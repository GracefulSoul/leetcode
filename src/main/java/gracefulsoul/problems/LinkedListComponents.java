package gracefulsoul.problems;

import gracefulsoul.object.node.ListNode;

public class LinkedListComponents {

	// https://leetcode.com/problems/linked-list-components/submissions/885618789/
	public static void main(String[] args) {
		LinkedListComponents test = new LinkedListComponents();
		System.out.println(test.numComponents(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))), new int[] { 0, 1, 3 }));
		System.out.println(test.numComponents(new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))), new int[] { 0, 3, 1, 4 }));
	}

	public int numComponents(ListNode head, int[] nums) {
		int max = 0;
		for (int num : nums) {
			max = Math.max(max, num);
		}
		int[] dp = new int[max + 1];
		for (int num : nums) {
			dp[num]++;
		}
		int connected = 0;
		int result = 0;
		while (head != null) {
			if (head.val <= max && dp[head.val] == 1) {
				connected++;
			} else if (connected > 0) {
				result++;
				connected = 0;
			}
			head = head.next;
		}
		if (connected > 0) {
			result++;
		}
		return result;
	}

}
