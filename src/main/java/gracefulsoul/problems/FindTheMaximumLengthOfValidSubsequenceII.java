package gracefulsoul.problems;

public class FindTheMaximumLengthOfValidSubsequenceII {

	// https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-ii/submissions/1701081679/
	public static void main(String[] args) {
		FindTheMaximumLengthOfValidSubsequenceII test = new FindTheMaximumLengthOfValidSubsequenceII();
		System.out.println(test.maximumLength(new int[] { 1, 2, 3, 4, 5 }, 2));
		System.out.println(test.maximumLength(new int[] { 1, 4, 2, 3, 1, 4 }, 3));
	}

	public int maximumLength(int[] nums, int k) {
		int[][] dp = new int[k][k];
		int max = 0;
		for (int num : nums) {
			for (int i = 0; i < k; i++) {
				int remainder = num % k;
				dp[remainder][i] = dp[i][remainder] + 1;
				max = Math.max(max, dp[remainder][i]);
			}
		}
		return max;
	}

}
