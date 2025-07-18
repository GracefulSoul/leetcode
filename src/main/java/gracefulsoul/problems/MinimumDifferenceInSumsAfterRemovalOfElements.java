package gracefulsoul.problems;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumDifferenceInSumsAfterRemovalOfElements {

	// https://leetcode.com/problems/minimum-difference-in-sums-after-removal-of-elements/submissions/1702220056/
	public static void main(String[] args) {
		MinimumDifferenceInSumsAfterRemovalOfElements test = new MinimumDifferenceInSumsAfterRemovalOfElements();
		System.out.println(test.minimumDifference(new int[] { 3, 1, 2 }));
		System.out.println(test.minimumDifference(new int[] { 7, 9, 5, 8, 1, 3 }));
	}

	public long minimumDifference(int[] nums) {
		int length = nums.length;
		int k = length / 3;
		long[] mins = new long[length];
		long[] maxs = new long[length];
		long sum = 0;
		Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
		for (int i = 0; i < k; i++) {
			queue.offer(nums[i]);
			sum += nums[i];
		}
		mins[k - 1] = sum;
		for (int i = k; i < length - k; i++) {
			int x = nums[i];
			if (x < queue.peek()) {
				sum += x - queue.poll();
				queue.offer(x);
			}
			mins[i] = sum;
		}
		sum = 0;
		queue = new PriorityQueue<>();
		for (int i = length - 1; i >= length - k; i--) {
			queue.offer(nums[i]);
			sum += nums[i];
		}
		maxs[length - k] = sum;
		for (int i = length - k - 1; i >= k - 1; i--) {
			int x = nums[i];
			if (x > queue.peek()) {
				sum += x - queue.poll();
				queue.offer(x);
			}
			maxs[i] = sum;
		}
		long result = Long.MAX_VALUE;
		for (int i = k - 1; i < length - k; i++) {
			result = Math.min(result, mins[i] - maxs[i + 1]);
		}
		return result;
	}

}
