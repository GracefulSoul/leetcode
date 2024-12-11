package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {

	// https://leetcode.com/problems/maximum-beauty-of-an-array-after-applying-operation/submissions/1476104521/
	public static void main(String[] args) {
		MaximumBeautyOfAnArrayAfterApplyingOperation test = new MaximumBeautyOfAnArrayAfterApplyingOperation();
		System.out.println(test.maximumBeauty(new int[] { 4, 6, 1, 2 }, 2));
		System.out.println(test.maximumBeauty(new int[] { 1, 1, 1, 1 }, 10));
	}

	public int maximumBeauty(int[] nums, int k) {
		Arrays.sort(nums);
		int start = 0;
		int end = 0;
		while (start < nums.length) {
			if (nums[start++] - nums[end] > k * 2) {
				end++;
			}
		}
		return start - end;
	}

}
