package gracefulsoul.problems;

import gracefulsoul.object.solution.random.node.Solution;

import gracefulsoul.object.node.ListNode;

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
