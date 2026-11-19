package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumScoreByChangingTwoElements {

	// https://leetcode.com/problems/minimum-score-by-changing-two-elements/submissions/2199301811/
	public static void main(String[] args) {
		MinimumScoreByChangingTwoElements test = new MinimumScoreByChangingTwoElements();
		System.out.println(test.minimizeSum(new int[] { 1, 4, 7, 8, 5 }));
		System.out.println(test.minimizeSum(new int[] { 1, 4, 3 }));
	}

	public int minimizeSum(int[] nums) {
		int length = nums.length;
		Arrays.sort(nums);
		return Math.min(Math.min(nums[length - 1] - nums[2], nums[length - 3] - nums[0]), nums[length - 2] - nums[1]);
	}

}
