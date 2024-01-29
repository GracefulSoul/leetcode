package gracefulsoul.problems;

public class MaximumSumOfTwoNonOverlappingSubarrays {

	// https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/submissions/1159974265/
	public static void main(String[] args) {
		MaximumSumOfTwoNonOverlappingSubarrays test = new MaximumSumOfTwoNonOverlappingSubarrays();
		System.out.println(test.maxSumTwoNoOverlap(new int[] { 0, 6, 5, 2, 2, 5, 1, 9, 4 }, 1, 2));
		System.out.println(test.maxSumTwoNoOverlap(new int[] { 3, 8, 1, 3, 2, 1, 8, 9, 0 }, 3, 2));
		System.out.println(test.maxSumTwoNoOverlap(new int[] { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 }, 4, 3));
	}

	public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
		return Math.max(this.maxSum(nums, firstLen, secondLen), this.maxSum(nums, secondLen, firstLen));
	}

	private int maxSum(int[] nums, int firstLen, int secondLen) {
		int sumFirstLen = 0;
		int sumSecondLen = 0;
		for (int i = 0; i < firstLen + secondLen; i++) {
			if (i < firstLen) {
				sumFirstLen += nums[i];
			} else {
				sumSecondLen += nums[i];
			}
		}
		int result = sumFirstLen  + sumSecondLen;
		for (int i = firstLen + secondLen, max = sumFirstLen; i < nums.length; i++) {
			sumFirstLen += nums[i - secondLen] - nums[i - firstLen - secondLen];
			sumSecondLen += nums[i] - nums[i - secondLen];
			max = Math.max(max, sumFirstLen);
			result = Math.max(result, max + sumSecondLen);
		}
		return result;
	}

}
