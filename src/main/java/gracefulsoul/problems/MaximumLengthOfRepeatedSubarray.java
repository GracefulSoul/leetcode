package gracefulsoul.problems;

public class MaximumLengthOfRepeatedSubarray {

	// https://leetcode.com/submissions/detail/838597570/
	public static void main(String[] args) {
		MaximumLengthOfRepeatedSubarray test = new MaximumLengthOfRepeatedSubarray();
		System.out.println(test.findLength(new int[] { 1, 2, 3, 2, 1 }, new int[] { 3, 2, 1, 4, 7 }));
		System.out.println(test.findLength(new int[] { 0, 0, 0, 0, 0 }, new int[] { 0, 0, 0, 0, 0 }));
	}

	public int findLength(int[] nums1, int[] nums2) {
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;
		int[][] dp = new int[nums1Length + 1][nums2Length + 1];
		int max = 0;
		for (int i = 0; i < nums1Length; i++) {
			for (int j = 0; j < nums2Length; j++) {
				if (nums1[i] == nums2[j]) {
					dp[i + 1][j + 1] = dp[i][j] + 1;
					max = Math.max(max, dp[i + 1][j + 1]);
				}
			}
		}
		return max;
	}

}
