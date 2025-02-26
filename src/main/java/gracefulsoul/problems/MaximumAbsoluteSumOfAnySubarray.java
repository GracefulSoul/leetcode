package gracefulsoul.problems;

public class MaximumAbsoluteSumOfAnySubarray {

	// https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray/submissions/1555526317/
	public static void main(String[] args) {
		MaximumAbsoluteSumOfAnySubarray test = new MaximumAbsoluteSumOfAnySubarray();
		System.out.println(test.maxAbsoluteSum(new int[] { 1, -3, 2, 3, -4 }));
		System.out.println(test.maxAbsoluteSum(new int[] { 2, -5, 1, -4, 3, -2 }));
	}

	public int maxAbsoluteSum(int[] nums) {
		int sum = 0;
		int max = 0;
		int min = 0;
		for (int num : nums) {
			sum += num;
			max = Math.max(max, sum);
			min = Math.min(min, sum);
		}
		return max - min;
	}

}
