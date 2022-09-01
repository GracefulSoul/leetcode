package gracefulsoul.problems;

public class MaximumAverageSubarrayI {

	// https://leetcode.com/submissions/detail/788746584/
	public static void main(String[] args) {
		MaximumAverageSubarrayI test = new MaximumAverageSubarrayI();
		System.out.println(test.findMaxAverage(new int[] { 1, 12, -5, -6, 50, 3 }, 4));
		System.out.println(test.findMaxAverage(new int[] { 5 }, 1));
	}

	public double findMaxAverage(int[] nums, int k) {
		long sum = 0;
		long max = Long.MIN_VALUE;
		for (int idx = 0; idx < nums.length; idx++) {
			sum += nums[idx];
			if (idx > k - 1) {
				sum -= nums[idx - k];
			}
			if (idx >= k - 1) {
				max = Math.max(max, sum);
			}
		}
		return (double) max / k;
	}

}
