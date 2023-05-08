package gracefulsoul.problems;

public class MaximumSumCircularSubarray {

	// https://leetcode.com/problems/maximum-sum-circular-subarray/submissions/945710118/
	public static void main(String[] args) {
		MaximumSumCircularSubarray test = new MaximumSumCircularSubarray();
		System.out.println(test.maxSubarraySumCircular(new int[] { 1, -2, 3, -2 }));
		System.out.println(test.maxSubarraySumCircular(new int[] { 5, -3, 5 }));
		System.out.println(test.maxSubarraySumCircular(new int[] { -3, -2, -3 }));
	}

	public int maxSubarraySumCircular(int[] nums) {
		int max1 = this.getMaximumSubarray(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			nums[i] = -nums[i];
		}
		int max2 = sum + this.getMaximumSubarray(nums);
		if (max2 == 0) {
			return max1;
		} else {
			return Math.max(max1, max2);
		}
	}

	private int getMaximumSubarray(int[] nums) {
		int sum = nums[0];
		int max = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(sum + nums[i], nums[i]);
			max = Math.max(max, sum);
		}
		return max;
	}

}
