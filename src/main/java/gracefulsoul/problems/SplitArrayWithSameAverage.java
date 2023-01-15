package gracefulsoul.problems;

import java.util.Arrays;

public class SplitArrayWithSameAverage {

	// https://leetcode.com/problems/split-array-with-same-average/submissions/878297318/
	public static void main(String[] args) {
		SplitArrayWithSameAverage test = new SplitArrayWithSameAverage();
		System.out.println(test.splitArraySameAverage(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
		System.out.println(test.splitArraySameAverage(new int[] { 3, 1 }));
	}

	public boolean splitArraySameAverage(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return false;
		}
		Arrays.sort(nums);
		int[] sums = new int[length];
		sums[0] = nums[0];
		for (int idx = 1; idx < length; idx++) {
			sums[idx] = sums[idx - 1] + nums[idx];
		}
		int sum = sums[length - 1];
		for (int idx = 1; idx <= length / 2; idx++) {
			if ((sum * idx) % length == 0 && this.dfs(nums, sums, idx, length - 1, (sum * idx) / length)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(int[] nums, int[] sums, int k, int index, int target) {
		if (k == 1) {
			return Arrays.binarySearch(nums, 0, index + 1, target) >= 0;
		} else if (sums[k - 1] <= target) {
			for (int idx = index; idx >= k && sums[idx] - sums[idx - k] >= target; idx--) {
				if (this.dfs(nums, sums, k - 1, idx - 1, target - nums[idx])) {
					return true;
				}
			}
		}
		return false;
	}

}
