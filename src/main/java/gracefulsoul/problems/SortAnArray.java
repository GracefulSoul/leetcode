package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class SortAnArray {

	// https://leetcode.com/problems/sort-an-array/submissions/943153540/
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
		if (left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		this.mergeSort(nums, left, mid);
		this.mergeSort(nums, mid + 1, right);
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid || j <= right) {
			if (i > mid || j <= right && nums[i] > nums[j]) {
				temp[k++] = nums[j++];
			} else {
				temp[k++] = nums[i++];
			}
		}
		System.arraycopy(temp, 0, nums, left, right - left + 1);
	}

}
