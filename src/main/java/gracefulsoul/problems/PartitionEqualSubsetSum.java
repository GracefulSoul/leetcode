package gracefulsoul.problems;

public class PartitionEqualSubsetSum {

	// https://leetcode.com/submissions/detail/660906769/
	public static void main(String[] args) {
		PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
		System.out.println(test.canPartition(new int[] { 1, 5, 11, 5 }));
		System.out.println(test.canPartition(new int[] { 1, 2, 3, 5 }));
	}

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if ((sum & 1) > 0) {
			return false;
		}
		int target = sum / 2;
		return this.dfs(nums, new boolean[target + 1], 0, target);
	}

	private boolean dfs(int[] nums, boolean[] dp, int index, int target) {
		if (index >= nums.length) {
			return false;
		} else if (nums[index] == target) {
			return true;
		} else {
			int num = target - nums[index];
			if (num > 0 && !dp[num]) {
				dp[num] = true;
				return this.dfs(nums, dp, index + 1, num) || this.dfs(nums, dp, index + 1, target);
			} else {
				return this.dfs(nums, dp, index + 1, target);
			}
		}
	}

}
