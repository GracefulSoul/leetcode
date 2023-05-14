package gracefulsoul.problems;

public class UncrossedLines {

	// https://leetcode.com/problems/uncrossed-lines/submissions/950009302/
	public static void main(String[] args) {
		UncrossedLines test = new UncrossedLines();
		System.out.println(test.maxUncrossedLines(new int[] { 2, 5, 1, 2, 5 }, new int[] { 10, 5, 2, 1, 5, 2 }));
		System.out.println(test.maxUncrossedLines(new int[] { 1, 3, 7, 1, 7, 5 }, new int[] { 1, 9, 2, 5, 1 }));
	}

	public int maxUncrossedLines(int[] nums1, int[] nums2) {
		int nums1Length = nums1.length;
		int nums2Length = nums2.length;
		if (nums1Length < nums2Length) {
			return this.maxUncrossedLines(nums2, nums1);
		}
		int dp[] = new int[nums2Length + 1];
		for (int i = 0; i < nums1Length; i++) {
			for (int j = 0, prev = 0; j < nums2Length; j++) {
				int curr = dp[j + 1];
				if (nums1[i] == nums2[j]) {
					dp[j + 1] = 1 + prev;
				} else {
					dp[j + 1] = Math.max(dp[j + 1], dp[j]);
				}
				prev = curr;
			}
		}
		return dp[nums2Length];
	}

}
