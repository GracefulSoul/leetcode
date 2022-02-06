package gracefulsoul.problems;

import java.util.Arrays;

public class CombinationSumIV {

	// https://leetcode.com/submissions/detail/635345142/
	public static void main(String[] args) {
		CombinationSumIV test = new CombinationSumIV();
		System.out.println(test.combinationSum4(new int[] { 1, 2, 3 }, 4));
		System.out.println(test.combinationSum4(new int[] { 9 }, 3));
	}

	public int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		return this.resursive(nums, dp, 0, target);
	}

	private int resursive(int[] nums, int[] dp, int index, int target) {
		if (index == target) {
			return 1;
		} else if (index > target) {
			return 0;
		} else if (dp[target - index] == -1) {
			int result = 0;
			for (int num : nums) {
				result += this.resursive(nums, dp, index + num, target);
			}
			dp[target - index] = result;
		}
		return dp[target - index];
	}

}
