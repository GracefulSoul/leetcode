package gracefulsoul.problems;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {

	// https://leetcode.com/problems/max-dot-product-of-two-subsequences/submissions/
	public static void main(String[] args) {
		MaxDotProductOfTwoSubsequences test = new MaxDotProductOfTwoSubsequences();
		System.out.println(test.maxDotProduct(new int[] { 2, 1, -2, 5 }, new int[] { 3, 0, -6 }));
		System.out.println(test.maxDotProduct(new int[] { 3, -2 }, new int[] { 2, -6, 7 }));
		System.out.println(test.maxDotProduct(new int[] { -1, -1 }, new int[] { 1, 1 }));
	}

	public int maxDotProduct(int[] nums1, int[] nums2) {
		int row = nums1.length;
		int col = nums2.length;
		int[][] dp = new int[row + 1][col + 1];
		for (int[] r : dp) {
			Arrays.fill(r, Integer.MIN_VALUE);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]),
						(nums1[i] * nums2[j]) + Math.max(0, dp[i][j]));
			}
		}
		return dp[row][col];
	}

}
