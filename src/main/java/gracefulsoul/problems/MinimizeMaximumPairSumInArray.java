package gracefulsoul.problems;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

	// https://leetcode.com/problems/minimize-maximum-pair-sum-in-array/submissions/1101011886/
	public static void main(String[] args) {
		MinimizeMaximumPairSumInArray test = new MinimizeMaximumPairSumInArray();
		System.out.println(test.minPairSum(new int[] { 3, 5, 2, 3 }));
		System.out.println(test.minPairSum(new int[] { 3, 5, 4, 2, 4, 6 }));
	}

	public int minPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		int length = nums.length;
		for (int i = 0; i < length / 2; i++) {
			result = Math.max(result, nums[i] + nums[length - i - 1]);
		}
		return result;
	}

}
