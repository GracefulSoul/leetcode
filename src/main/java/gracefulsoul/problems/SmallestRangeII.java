package gracefulsoul.problems;

import java.util.Arrays;

public class SmallestRangeII {

	// https://leetcode.com/problems/smallest-range-ii/submissions/940559463/
	public static void main(String[] args) {
		SmallestRangeII test = new SmallestRangeII();
		System.out.println(test.smallestRangeII(new int[] { 1 }, 0));
		System.out.println(test.smallestRangeII(new int[] { 0, 10 }, 2));
		System.out.println(test.smallestRangeII(new int[] { 1, 3, 6 }, 3));

	}

	public int smallestRangeII(int[] nums, int k) {
		Arrays.sort(nums);
		int length = nums.length;
		int max = nums[length - 1];
		int min = nums[0];
		int result = max - min;
		for (int i = 0; i < length - 1; i++) {
			max = Math.max(max, nums[i] + (k * 2));
			min = Math.min(nums[i + 1], nums[0] + (k * 2));
			result = Math.min(result, max - min);
		}
		return result;
	}

}
