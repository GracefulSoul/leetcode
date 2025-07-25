package gracefulsoul.problems;

public class MaximumUniqueSubarraySumAfterDeletion {

	// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/submissions/1710876592/
	public static void main(String[] args) {
		MaximumUniqueSubarraySumAfterDeletion test = new MaximumUniqueSubarraySumAfterDeletion();
		System.out.println(test.maxSum(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.maxSum(new int[] { 1, 1, 0, 1, 1 }));
		System.out.println(test.maxSum(new int[] { 1, 2, -1, -2, 1, 0, -1 }));
	}

	public int maxSum(int[] nums) {
		boolean isAllNegative = true;
		int max = Integer.MIN_VALUE;
		for (int num : nums) {
			if (0 <= num) {
				isAllNegative = false;
			}
			if (max < num) {
				max = num;
			}
		}
		if (isAllNegative) {
			return max;
		}
		boolean[] seen = new boolean[101];
		for (int num : nums) {
			if (0 <= num && num < 101) {
				seen[num] = true;
			}
		}
		int sum = 0;
		for (int i = 1; i < 101; i++) {
			if (seen[i]) {
				sum += i;
			}
		}
		return sum;
	}

}
