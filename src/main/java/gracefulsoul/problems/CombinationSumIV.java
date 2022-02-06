package gracefulsoul.problems;

import java.util.Arrays;

public class CombinationSumIV {

	// https://leetcode.com/submissions/detail/635349215/
	public static void main(String[] args) {
		CombinationSumIV test = new CombinationSumIV();
		System.out.println(test.combinationSum4(new int[] { 1, 2, 3 }, 4));
		System.out.println(test.combinationSum4(new int[] { 9 }, 3));
	}

	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		return this.resursive(nums, dp, target);
	}

	private int resursive(int[] nums, int[] dp, int target) {
		if (target == 0) {
			return 1;
		} else if (target < 0) {
			return 0;
		} else if (dp[target] == -1) {
			int result = 0;
			for (int num : nums) {
				result += this.resursive(nums, dp, target - num);
			}
			dp[target] = result;
		}
		return dp[target];
	}

}
