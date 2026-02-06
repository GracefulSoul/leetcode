package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumRemovalsToBalanceArray {

	// https://leetcode.com/problems/minimum-removals-to-balance-array/submissions/1910121818/
	public static void main(String[] args) {
		MinimumRemovalsToBalanceArray test = new MinimumRemovalsToBalanceArray();
		System.out.println(test.minRemoval(new int[] { 2, 1, 5 }, 2));
		System.out.println(test.minRemoval(new int[] { 1, 6, 2, 9 }, 3));
		System.out.println(test.minRemoval(new int[] { 4, 6 }, 2));
	}

	public int minRemoval(int[] nums, int k) {
		Arrays.sort(nums);
		int length = nums.length;
		int max = 0;
		for (int left = 0, right = 0; right < length; right++) {
			while (nums[right] > (long) k * nums[left]) {
				left++;
			}
			max = Math.max(max, right - left + 1);
		}
		return length - max;
	}

}
