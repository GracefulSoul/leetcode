package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeArrayContinuous {

	// https://leetcode.com/problems/minimum-number-of-operations-to-make-array-continuous/submissions/1071691807/
	public static void main(String[] args) {
		MinimumNumberOfOperationsToMakeArrayContinuous test = new MinimumNumberOfOperationsToMakeArrayContinuous();
		System.out.println(test.minOperations(new int[] { 4, 2, 5, 3 }));
		System.out.println(test.minOperations(new int[] { 1, 2, 3, 5, 6 }));
		System.out.println(test.minOperations(new int[] { 1, 10, 100, 1000 }));
	}

	public int minOperations(int[] nums) {
		Arrays.sort(nums);
		int result = Integer.MAX_VALUE;
		int j = 1;
		int count = 0;
		int[] dp = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			while (j < nums.length && nums[j] <= nums[i] + nums.length - 1) {
				if (nums[j] == nums[j - 1]) {
					count++;
				}
				dp[j] = count;
				j++;
			}
			result = Math.min(result, i + (nums.length - j) + count - dp[i]);
		}
		return result;
	}

}
