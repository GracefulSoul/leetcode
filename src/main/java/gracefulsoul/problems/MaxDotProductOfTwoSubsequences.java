package gracefulsoul.problems;

import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {

	// https://leetcode.com/problems/max-dot-product-of-two-subsequences/submissions/1070142738/
	public static void main(String[] args) {
		MaxDotProductOfTwoSubsequences test = new MaxDotProductOfTwoSubsequences();
		System.out.println(test.maxDotProduct(new int[] { 2, 1, -2, 5 }, new int[] { 3, 0, -6 }));
		System.out.println(test.maxDotProduct(new int[] { 3, -2 }, new int[] { 2, -6, 7 }));
		System.out.println(test.maxDotProduct(new int[] { -1, -1 }, new int[] { 1, 1 }));
	}

	public int maxDotProduct(int[] nums1, int[] nums2) {
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;
		int[][] dp = new int[nums1Length + 1][nums2Length + 1];
		for (int[] r : dp) {
			Arrays.fill(r, Integer.MIN_VALUE);
		}
		for (int i = 0; i < nums1Length; i++) {
			for (int j = 0; j < nums2Length; j++) {
				dp[i + 1][j + 1] = Math.max(Math.max(dp[i][j + 1], dp[i + 1][j]),
						(nums1[i] * nums2[j]) + Math.max(0, dp[i][j]));
			}
		}
		return dp[nums1Length][nums2Length];
	}

}
