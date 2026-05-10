package gracefulsoul.problems;

public class MaximumNumberOfJumpsToReachTheLastIndex {

	// https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/submissions/1999314456/
	public static void main(String[] args) {
		MaximumNumberOfJumpsToReachTheLastIndex test = new MaximumNumberOfJumpsToReachTheLastIndex();
		System.out.println(test.maximumJumps(new int[] { 1, 3, 6, 4, 1, 2 }, 2));
		System.out.println(test.maximumJumps(new int[] { 1, 3, 6, 4, 1, 2 }, 3));
		System.out.println(test.maximumJumps(new int[] { 1, 3, 6, 4, 1, 2 }, 0));
	}

	public int maximumJumps(int[] nums, int target) {
		int length = nums.length;
		int[] dp = new int[length];
		dp[0] = 0;
		for (int j = 1; j < length; j++) {
			int max = -1;
			for (int i = 0; i < j; i++) {
				if ((long) nums[i] - target <= nums[j] && nums[j] <= (long) nums[i] + target && dp[i] != -1) {
					max = Math.max(max, dp[i] + 1);
				}
			}
			dp[j] = max;
		}
		return dp[length - 1];
	}

}
