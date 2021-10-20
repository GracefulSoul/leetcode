package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAnArray {

	// https://leetcode.com/submissions/detail/574144798/
	public static void main(String[] args) {
		KthLargestElementInAnArray test = new KthLargestElementInAnArray();
		System.out.println(test.findKthLargest(new int[] { 3, 2, 1, 5, 6, 4 }, 2));
		System.out.println(test.findKthLargest(new int[] { 3, 2, 3, 1, 2, 4, 5, 5, 6 }, 4));
	}

	public int findKthLargest(int[] nums, int k) {
		Queue<Integer> queue = new PriorityQueue<>();
		for (int num : nums) {
			queue.add(num);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		return queue.poll();
	}

}
