package gracefulsoul.problems;

import java.util.ArrayDeque;
import java.util.Deque;

public class ConstrainedSubsequenceSum {

	// https://leetcode.com/problems/constrained-subsequence-sum/submissions/1080257807/
	public static void main(String[] args) {
		ConstrainedSubsequenceSum test = new ConstrainedSubsequenceSum();
		System.out.println(test.constrainedSubsetSum(new int[] { 10, 2, -10, 5, 20 }, 2));
		System.out.println(test.constrainedSubsetSum(new int[] { -1, -2, -3 }, 1));
		System.out.println(test.constrainedSubsetSum(new int[] { 10, -2, -10, -5, 20 }, 2));
	}

	public int constrainedSubsetSum(int[] nums, int k) {
		int result = nums[0];
		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 0; i < nums.length; ++i) {
			nums[i] += !deque.isEmpty() ? deque.peek() : 0;
			result = Math.max(result, nums[i]);
			while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
				deque.pollLast();
			}
			if (nums[i] > 0) {
				deque.offer(nums[i]);
			}
			if (i >= k && !deque.isEmpty() && deque.peek() == nums[i - k]) {
				deque.poll();
			}
		}
		return result;
	}

}
