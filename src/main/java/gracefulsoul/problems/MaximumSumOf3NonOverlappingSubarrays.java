package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class MaximumSumOf3NonOverlappingSubarrays {

	// https://leetcode.com/submissions/detail/820049846/
	public static void main(String[] args) {
		MaximumSumOf3NonOverlappingSubarrays test = new MaximumSumOf3NonOverlappingSubarrays();
		PrintUtil.print(test.maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2));
		PrintUtil.print(test.maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 1 }, 2));
	}

	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int length = nums.length;
		int[] sum = new int[length + 1];
		int[] left = new int[length];
		int[] right = new int[length];
		for (int idx = 0; idx < length; idx++) {
			sum[idx + 1] = sum[idx] + nums[idx];
		}
		int total = sum[k] - sum[0];
		for (int idx = k; idx < length; idx++) {
			int rangeSum = sum[idx + 1] - sum[idx + 1 - k];
			if (rangeSum > total) {
				left[idx] = idx + 1 - k;
				total = rangeSum;
			} else {
				left[idx] = left[idx - 1];
			}
		}
		total = sum[length] - sum[length - k];
		right[length - k] = length - k;
		for (int idx = length - k - 1; idx >= 0; idx--) {
			int subSum = sum[idx + k] - sum[idx];
			if (subSum >= total) {
				right[idx] = idx;
				total = subSum;
			} else {
				right[idx] = right[idx + 1];
			}
		}
		int max = 0;
		int[] result = new int[3];
		for (int idx = k; idx <= length - k - k; idx++) {
			int leftMax = left[idx - 1];
			int rightMax = right[idx + k];
			total = (sum[leftMax + k] - sum[leftMax]) + (sum[idx + k] - sum[idx]) + (sum[rightMax + k] - sum[rightMax]);
			if (total > max) {
				max = total;
				result[0] = leftMax;
				result[1] = idx;
				result[2] = rightMax;
			}
		}
		return result;
	}

}
