package gracefulsoul.problems;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		LongestIncreasingSubsequence test = new LongestIncreasingSubsequence();
		System.out.println(test.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(test.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
		System.out.println(test.lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7, 7 }));

	}

	// https://leetcode.com/submissions/detail/601031230/
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length + 1];
		dp[0] = Integer.MIN_VALUE;
		int length = 1;
		for (int idx = 0; idx < nums.length; idx++) {
			int right = length - 1;
			while (dp[right] >= nums[idx]) {
				right--;
			}
			if (right == length - 1) {
				length++;
			}
			dp[right + 1] = nums[idx];
		}
		return length - 1;
	}

}
