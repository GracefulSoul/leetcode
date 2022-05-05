package gracefulsoul.object.solution.random.node;

import java.util.Random;

import gracefulsoul.object.node.ListNode;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
public class Solution {

	private ListNode listNode;
	private int size;
	private Random random;

	public Solution(ListNode head) {
		this.listNode = head;
		this.size = 0;
		ListNode curr = head;
		while (curr != null) {
			this.size++;
			curr = curr.next;
		}
		this.random = new Random();
	}

	public int getRandom() {
		int num = this.random.nextInt(this.size);
		ListNode curr = this.listNode;
		while (num > 0) {
			curr = curr.next;
			num--;
		}
		return curr.val;
	}

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(head); int param_1 = obj.getRandom();
 */