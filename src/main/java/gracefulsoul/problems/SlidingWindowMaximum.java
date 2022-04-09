package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SlidingWindowMaximum {

	// https://leetcode.com/submissions/detail/587459227/
	public static void main(String[] args) {
		SlidingWindowMaximum test = new SlidingWindowMaximum();
		PrintUtil.print(test.maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3));
		PrintUtil.print(test.maxSlidingWindow(new int[] { 1 }, 1));
		PrintUtil.print(test.maxSlidingWindow(new int[] { 1, -1 }, 1));
		PrintUtil.print(test.maxSlidingWindow(new int[] { 9, 11 }, 2));
		PrintUtil.print(test.maxSlidingWindow(new int[] { 4, -2 }, 2));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int length = nums.length;
		int[] left = new int[length];
		int[] right = new int[length];
		for (int i = 0; i < length; i += k) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j < i + k && j < length; j++) {
				max = Math.max(max, nums[j]);
				left[j] = max;
			}
		}
		int decrement = length % k == 0 ? k : length % k;
		for (int i = length - 1; i >= 0; i -= decrement, decrement = k) {
			int max = Integer.MIN_VALUE;
			for (int j = i; j > i - decrement && j >= 0; j--) {
				max = Math.max(max, nums[j]);
				right[j] = max;
			}
		}
		int[] result = new int[length - k + 1];
		for (int i = k - 1; i < length; i++) {
			if ((i + 1) % k == 0) {
				result[i - k + 1] = left[i];
			} else {
				result[i - k + 1] = Math.max(left[i], right[i - k + 1]);
			}
		}
		return result;
	}

}
