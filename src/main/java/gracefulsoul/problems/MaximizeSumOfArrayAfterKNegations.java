package gracefulsoul.problems;

import java.util.Arrays;

public class MaximizeSumOfArrayAfterKNegations {

	// https://leetcode.com/problems/maximize-sum-of-array-after-k-negations/submissions/1082060488/
	public static void main(String[] args) {
		MaximizeSumOfArrayAfterKNegations test = new MaximizeSumOfArrayAfterKNegations();
		System.out.println(test.largestSumAfterKNegations(new int[] { 4, 2, 3 }, 1));
		System.out.println(test.largestSumAfterKNegations(new int[] { 3, -1, 0, 2 }, 3));
		System.out.println(test.largestSumAfterKNegations(new int[] { 2, -3, -1, 5, -4 }, 2));
	}

	public int largestSumAfterKNegations(int[] nums, int k) {
		Arrays.sort(nums);
		for (int i = 0; k > 0 && i < nums.length && nums[i] < 0; i++, k--) {
			nums[i] = -nums[i];
		}
		int result = 0;
		int min = Integer.MAX_VALUE;
		for (int num : nums) {
			result += num;
			min = Math.min(min, num);
		}
		return result - ((k % 2) * min * 2);
	}

}
