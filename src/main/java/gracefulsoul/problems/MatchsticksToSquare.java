package gracefulsoul.problems;

import java.util.Arrays;

public class MatchsticksToSquare {

	// https://leetcode.com/submissions/detail/689464791/
	public static void main(String[] args) {
		MatchsticksToSquare test = new MatchsticksToSquare();
		System.out.println(test.makesquare(new int[] { 1, 1, 2, 2, 2 }));
		System.out.println(test.makesquare(new int[] { 3, 3, 3, 3, 4 }));
	}

	public boolean makesquare(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 4 != 0) {
			return false;
		}
		Arrays.sort(nums);
		return this.dfs(nums, new boolean[nums.length], 0, sum / 4, 0, 1);
	}

	private boolean dfs(int[] nums, boolean[] dp, int curr, int target, int sum, int group) {
		if (group == 4) {
			return true;
		} else if (sum == target) {
			return this.dfs(nums, dp, 0, target, 0, group + 1);
		} else if (sum > target) {
			return false;
		} else {
			for (int idx = curr; idx < nums.length; idx++) {
				if (dp[idx] || (idx > 0 && nums[idx] == nums[idx - 1] && !dp[idx - 1])) {
					continue;
				}
				dp[idx] = true;
				if (this.dfs(nums, dp, idx + 1, target, sum + nums[idx], group)) {
					return true;
				}
				dp[idx] = false;
			}
			return false;
		}
	}

}
