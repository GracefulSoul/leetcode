package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargestElementInAStream {

	// https://leetcode.com/submissions/detail/829228487/
	public static void main(String[] args) {
		KthLargest kthLargest = new KthLargest(3, new int[] { 4, 5, 8, 2 });
		System.out.println(kthLargest.add(3));	// return 4
		System.out.println(kthLargest.add(5));	// return 5
		System.out.println(kthLargest.add(10));	// return 5
		System.out.println(kthLargest.add(9));	// return 8
		System.out.println(kthLargest.add(4));	// return 8
	}

}

class KthLargest {

	private Queue<Integer> queue;
	private int k;

	public KthLargest(int k, int[] nums) {
		this.k = k;
		this.queue = new PriorityQueue<Integer>(k);
		for (int num : nums) {
			this.add(num);
		}
	}

	public int add(int val) {
		this.queue.add(val);
		if (this.queue.size() > k) {
			this.queue.poll();
		}
		return this.queue.peek();
	}

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */