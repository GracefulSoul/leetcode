package gracefulsoul.problems;

import java.util.Arrays;

public class ReversePairs {

	// https://leetcode.com/submissions/detail/699122971/
	public static void main(String[] args) {
		ReversePairs test = new ReversePairs();
		System.out.println(test.reversePairs(new int[] { 1, 3, 2, 3, 1 }));
		System.out.println(test.reversePairs(new int[] { 2, 4, 3, 5, 1 }));
	}

	public int reversePairs(int[] nums) {
		return this.mergeSort(nums, 0, nums.length - 1);
	}

	private int mergeSort(int[] nums, int start, int end) {
		if (start >= end) {
			return 0;
		}
		int mid = (start + end) / 2;
		int result = this.mergeSort(nums, start, mid) + this.mergeSort(nums, mid + 1, end);
		for (int i = start, j = mid + 1; i <= mid; i++) {
			while (j <= end && nums[i] / 2.0 > nums[j]) {
				j++;
			}
			result += j - (mid + 1);
		}
		Arrays.sort(nums, start, end + 1);
		return result;
	}

}
