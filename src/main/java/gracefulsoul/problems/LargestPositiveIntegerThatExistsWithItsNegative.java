package gracefulsoul.problems;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

	// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/submissions/1247262016/
	public static void main(String[] args) {
		LargestPositiveIntegerThatExistsWithItsNegative test = new LargestPositiveIntegerThatExistsWithItsNegative();
		System.out.println(test.findMaxK(new int[] { -1, 2, -3, 3 }));
		System.out.println(test.findMaxK(new int[] { -1, 10, 6, 7, -7, 1 }));
		System.out.println(test.findMaxK(new int[] { -10, 8, 6, 7, -2, -3 }));
	}

	public int findMaxK(int[] nums) {
		Arrays.sort(nums);
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > 0 && Arrays.binarySearch(nums, -nums[i]) >= 0) {
				return nums[i];
			}
		}
		return -1;
	}

}
