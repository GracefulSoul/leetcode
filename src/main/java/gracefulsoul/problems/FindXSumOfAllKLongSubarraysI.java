package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class FindXSumOfAllKLongSubarraysI {

	// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/submissions/1820446778/
	public static void main(String[] args) {
		FindXSumOfAllKLongSubarraysI test = new FindXSumOfAllKLongSubarraysI();
		PrintUtil.print(test.findXSum(new int[] { 1, 1, 2, 2, 3, 4, 2, 3 }, 6, 2));
		PrintUtil.print(test.findXSum(new int[] { 3, 8, 7, 8, 7, 5 }, 2, 2));
	}

	public int[] findXSum(int[] nums, int k, int x) {
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < result.length; i++) {
			result[i] = this.findXSum(nums, i, i + k - 1, x);
		}
		return result;
	}

	private int findXSum(int[] nums, int left, int right, int x) {
		int result = 0;
		int unique = 0;
		int[] counts = new int[51];
		for (int i = left; i <= right; i++) {
			result += nums[i];
			if (counts[nums[i]] == 0) {
				unique++;
			}
			counts[nums[i]]++;
		}
		if (unique < x) {
			return result;
		}
		result = 0;
		for (int i = 0; i < x; i++) {
			int count = -1;
			int num = -1;
			for (int val = 50; val >= 1; val--) {
				if (counts[val] > count) {
					count = counts[val];
					num = val;
				}
			}
			if (num != -1) {
				result += num * count;
				counts[num] = 0;
			}
		}
		return result;
	}

}
