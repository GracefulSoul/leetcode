package gracefulsoul.problems;

public class MaximumTotalSubarrayValueI {

	// https://leetcode.com/problems/maximum-total-subarray-value-i/submissions/2027537660/
	public static void main(String[] args) {
		MaximumTotalSubarrayValueI test = new MaximumTotalSubarrayValueI();
		System.out.println(test.maxTotalValue(new int[] { 1, 3, 2 }, 2));
		System.out.println(test.maxTotalValue(new int[] { 4, 2, 5, 1 }, 3));
	}

	public long maxTotalValue(int[] nums, int k) {
		int max = nums[0];
		int min = nums[0];
		for (int num : nums) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		return (long) (max - min) * k;
	}

}
