package gracefulsoul.problems;

import java.util.Arrays;

import gracefulsoul.util.PrintUtil;

public class DivideArrayIntoArraysWithMaxDifference {

	// https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/submissions/1668266654/
	public static void main(String[] args) {
		DivideArrayIntoArraysWithMaxDifference test = new DivideArrayIntoArraysWithMaxDifference();
		PrintUtil.print(test.divideArray(new int[] { 1, 3, 4, 8, 7, 9, 3, 5, 1 }, 2));
		PrintUtil.print(test.divideArray(new int[] { 2, 4, 2, 2, 5, 2 }, 2));
		PrintUtil.print(test.divideArray(new int[] { 4, 2, 9, 8, 2, 12, 7, 12, 10, 5, 8, 5, 5, 7, 9, 2, 5, 11 }, 14));
	}

	public int[][] divideArray(int[] nums, int k) {
		Arrays.sort(nums);
		int length = nums.length;
		int[][] result = new int[length / 3][3];
		for (int i = 2; i < length; i += 3) {
			if (nums[i] - nums[i - 2] > k) {
				return new int[0][];
			} else {
				result[i / 3] = new int[] { nums[i - 2], nums[i - 1], nums[i] };
			}
		}
		return result;
	}

}
