package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumAlternatingSumOfSquares {

	// https://leetcode.com/problems/maximum-alternating-sum-of-squares/submissions/2171090702/
	public static void main(String[] args) {
		MaximumAlternatingSumOfSquares test = new MaximumAlternatingSumOfSquares();
		System.out.println(test.maxAlternatingSum(new int[] { 1, 2, 3 }));
		System.out.println(test.maxAlternatingSum(new int[] { 1, -1, 2, -2, 3, -3 }));
	}

	public long maxAlternatingSum(int[] nums) {
		int length = nums.length;
		for (int i = 0; i < length; i++) {
			nums[i] *= nums[i];
		}
		int half = length / 2;
		Arrays.sort(nums);
		long result = 0;
		for (int i = 0; i < length; i++) {
			if (i < half) {
				result -= nums[i];
			} else {
				result += nums[i];
			}
		}
		return result;
	}

}
