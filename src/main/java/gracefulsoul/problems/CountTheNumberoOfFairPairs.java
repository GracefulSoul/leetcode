package gracefulsoul.problems;

import java.util.Arrays;

public class CountTheNumberoOfFairPairs {

	// https://leetcode.com/problems/count-the-number-of-fair-pairs/submissions/1451454361/
	public static void main(String[] args) {
		CountTheNumberoOfFairPairs test = new CountTheNumberoOfFairPairs();
		System.out.println(test.countFairPairs(new int[] { 0, 1, 7, 4, 4, 5 }, 3, 6));
		System.out.println(test.countFairPairs(new int[] { 1, 7, 9, 2, 5 }, 11, 11));
	}

	public long countFairPairs(int[] nums, int lower, int upper) {
		Arrays.sort(nums);
		return this.countLess(nums, upper) - this.countLess(nums, lower - 1);
	}

	private long countLess(int[] nums, int sum) {
		long result = 0;
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			if (nums[left] + nums[right] <= sum) {
				result += right - left++;
			} else {
				right--;
			}
		}
		return result;
	}

}
