package gracefulsoul.problems;

public class TargetSum {

	// https://leetcode.com/submissions/detail/699616849/
	public static void main(String[] args) {
		TargetSum test = new TargetSum();
		System.out.println(test.findTargetSumWays(new int[] { 1, 1, 1, 1, 1 }, 3));
		System.out.println(test.findTargetSumWays(new int[] { 1 }, 1));
	}

	public int findTargetSumWays(int[] nums, int target) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return sum < target || (sum + target) % 2 == 1 ? 0 : this.subset(nums, (target + sum) >> 1);
	}

	private int subset(int[] nums, int target) {
		if (target < 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int idx = target; idx >= num; idx--) {
				dp[idx] += dp[idx - num];
			}
		}
		return dp[target];
	}

}
