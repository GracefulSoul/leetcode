package gracefulsoul.problems;

public class MaximumAscendingSubarraySum {

	// https://leetcode.com/problems/maximum-ascending-subarray-sum/submissions/1530899854/
	public static void main(String[] args) {
		MaximumAscendingSubarraySum test = new MaximumAscendingSubarraySum();
		System.out.println(test.maxAscendingSum(new int[] { 10, 20, 30, 5, 10, 50 }));
		System.out.println(test.maxAscendingSum(new int[] { 10, 20, 30, 40, 50 }));
		System.out.println(test.maxAscendingSum(new int[] { 12, 17, 15, 13, 10, 11, 12 }));
	}

	public int maxAscendingSum(int[] nums) {
		int result = nums[0];
		int curr = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] < nums[i]) {
				curr += nums[i];
			} else {
				curr = nums[i];
			}
			result = Math.max(result, curr);
		}
		return result;
	}

}
