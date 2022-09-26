package gracefulsoul.problems;

public class NumberOfLongestIncreasingSubsequence {

	// https://leetcode.com/submissions/detail/808928313/
	public static void main(String[] args) {
		NumberOfLongestIncreasingSubsequence test = new NumberOfLongestIncreasingSubsequence();
		System.out.println(test.findNumberOfLIS(new int[] { 1, 3, 5, 4, 7 }));
		System.out.println(test.findNumberOfLIS(new int[] { 2, 2, 2, 2, 2 }));
	}

	public int findNumberOfLIS(int[] nums) {
		int length = nums.length;
		int result = 0;
		int max = 0;
		int[] dp = new int[length];
		int[] count = new int[length];
		for (int i = 0; i < length; i++) {
			dp[i] = count[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (dp[i] == dp[j] + 1) {
						count[i] += count[j];
					} else if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						count[i] = count[j];
					}
				}
			}
			if (max == dp[i]) {
				result += count[i];
			} else if (max < dp[i]) {
				max = dp[i];
				result = count[i];
			}
		}
		return result;
	}

}
