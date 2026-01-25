package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

	// https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores/submissions/1895866269/
	public static void main(String[] args) {
		MinimumDifferenceBetweenHighestAndLowestOfKScores test = new MinimumDifferenceBetweenHighestAndLowestOfKScores();
		System.out.println(test.minimumDifference(new int[] { 90 }, 1));
		System.out.println(test.minimumDifference(new int[] { 9, 4, 1, 7 }, 2));
	}

	public int minimumDifference(int[] nums, int k) {
		if (nums.length == 1) {
			return 0;
		}
		Arrays.sort(nums);
		int result = Integer.MAX_VALUE;
		for (int i = k - 1; i < nums.length; i++) {
			result = Math.min(result, nums[i] - nums[i - k + 1]);
		}
		return result;
	}

}
