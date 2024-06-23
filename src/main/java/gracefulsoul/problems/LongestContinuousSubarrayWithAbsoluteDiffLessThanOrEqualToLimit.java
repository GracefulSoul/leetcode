package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

	// https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/submissions/1297210337/
	public static void main(String[] args) {
		LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit test = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
		System.out.println(test.longestSubarray(new int[] { 8, 2, 4, 7 }, 4));
		System.out.println(test.longestSubarray(new int[] { 10, 1, 2, 4, 7, 2 }, 5));
		System.out.println(test.longestSubarray(new int[] { 4, 2, 2, 2, 4, 4, 2, 2 }, 0));
	}

	public int longestSubarray(int[] nums, int limit) {
		Deque<Integer> maxDeque = new ArrayDeque<>();
		Deque<Integer> minDeque = new ArrayDeque<>();
		int i = 0;
		int j;
		for (j = 0; j < nums.length; j++) {
			while (!maxDeque.isEmpty() && nums[j] > maxDeque.peekLast()) {
				maxDeque.pollLast();
			}
			while (!minDeque.isEmpty() && nums[j] < minDeque.peekLast()) {
				minDeque.pollLast();
			}
			maxDeque.add(nums[j]);
			minDeque.add(nums[j]);
			if (maxDeque.peek() - minDeque.peek() > limit) {
				if (maxDeque.peek() == nums[i]) {
					maxDeque.poll();
				}
				if (minDeque.peek() == nums[i]) {
					minDeque.poll();
				}
				i++;
			}
		}
		return j - i;
	}

}
