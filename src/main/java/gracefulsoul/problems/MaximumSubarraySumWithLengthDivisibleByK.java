package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumSubarraySumWithLengthDivisibleByK {

	// https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k/submissions/1840916693/
	public static void main(String[] args) {
		MaximumSubarraySumWithLengthDivisibleByK test = new MaximumSubarraySumWithLengthDivisibleByK();
		System.out.println(test.maxSubarraySum(new int[] { 1, 2 }, 1));
		System.out.println(test.maxSubarraySum(new int[] { -1, -2, -3, -4, -5 }, 4));
		System.out.println(test.maxSubarraySum(new int[] { -5, 1, 2, -3, 4 }, 2));
	}

	public long maxSubarraySum(int[] nums, int k) {
		long[] prefix = new long[k];
		Arrays.fill(prefix, (long) 1e15);
		prefix[k - 1] = 0;
		long result = (long) -1e15;
		long sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int index = i % k;
			result = Math.max(result, sum - prefix[index]);
			prefix[index] = Math.min(prefix[index], sum);
		}
		return result;
	}

}
