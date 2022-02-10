package gracefulsoul.problems;

import java.util.Random;

import gracefulsoul.object.ListNode;

public class LinkedListRandomNode {

	// https://leetcode.com/submissions/detail/638387842/
	public static void main(String[] args) {
		Solution solution = new Solution(new ListNode(1, new ListNode(2, new ListNode(3))));
		System.out.println(solution.getRandom()); // return 1
		System.out.println(solution.getRandom()); // return 3
		System.out.println(solution.getRandom()); // return 2
		System.out.println(solution.getRandom()); // return 2
		System.out.println(solution.getRandom()); // return 3
		// getRandom() should return either 1, 2, or 3 randomly. Each element should
		// have equal probability of returning.
	}

}

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {

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
		ListNode curr = listNode;
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