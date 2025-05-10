package gracefulsoul.problems;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {

	// https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros/submissions/1629806571/
	public static void main(String[] args) {
		MinimumEqualSumOfTwoArraysAfterReplacingZeros test = new MinimumEqualSumOfTwoArraysAfterReplacingZeros();
		System.out.println(test.minSum(new int[] { 3, 2, 0, 1, 0 }, new int[] { 6, 5, 0 }));
		System.out.println(test.minSum(new int[] { 2, 0, 2, 0 }, new int[] { 1, 4 }));
	}

	public long minSum(int[] nums1, int[] nums2) {
		long[] sums = new long[2];
		int[] counts = new int[2];
		for (int num : nums1) {
			if (num == 0) {
				counts[0]++;
			}
			sums[0] += Math.max(num, 1);
		}
		for (int num : nums2) {
			if (num == 0) {
				counts[1]++;
			}
			sums[1] += Math.max(num, 1);
		}
		if ((sums[0] < sums[1] && counts[0] == 0) || (sums[1] < sums[0] && counts[1] == 0)) {
			return -1;
		} else {
			return Math.max(sums[0], sums[1]);
		}
	}

}
