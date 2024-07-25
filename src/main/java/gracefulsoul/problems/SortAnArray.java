package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SortAnArray {

	// https://leetcode.com/problems/sort-an-array/submissions/1332808320/
	public static void main(String[] args) {
		SortAnArray test = new SortAnArray();
		PrintUtil.print(test.sortArray(new int[] { 5, 2, 3, 1 }));
		PrintUtil.print(test.sortArray(new int[] { 5, 1, 1, 2, 0, 0 }));
	}

	public int[] sortArray(int[] nums) {
		this.mergeSort(nums, 0, nums.length - 1);
		return nums;
	}

	private void mergeSort(int[] nums, int left, int right) {
		if (left < right) {
			int diff = right - left;
			int mid = left + (diff / 2);
			this.mergeSort(nums, left, mid);
			this.mergeSort(nums, mid + 1, right);
			int[] temp = new int[diff + 1];
			for (int i = left, j = mid + 1, k = 0; i <= mid || j <= right; k++) {
				if (i > mid || (j <= right && nums[i] > nums[j])) {
					temp[k] = nums[j++];
				} else {
					temp[k] = nums[i++];
				}
			}
			System.arraycopy(temp, 0, nums, left, diff + 1);
		}
	}

}
