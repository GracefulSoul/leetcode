package gracefulsoul.problems;

import java.util.Arrays;

public class SortColors {

	// https://leetcode.com/submissions/detail/512530762/
	public static void main(String[] args) {
		SortColors test = new SortColors();
		int[] nums1 = new int[] { 2, 0, 2, 1, 1, 0 };
		test.sortColors(nums1);
		print(nums1);
		int[] nums2 = new int[] { 2, 0, 1 };
		test.sortColors(nums2);
		print(nums2);
		int[] nums3 = new int[] { 0 };
		test.sortColors(nums3);
		print(nums3);
	}

	public void sortColors(int[] nums) {
		int start = 0;
		int end = nums.length - 1;
		int idx = 0;
		while (idx <= end) {
			switch (nums[idx]) {
				case 0:
					if (nums[start] != 0) {
						this.swap(nums, idx, start);
					}
					start++;
					idx++;
					break;
				case 2:
					if (nums[end] != 2) {
						this.swap(nums, idx, end);
					}
					end--;
					break;
				default:
					idx++;
					break;
			}
		}
	}

	private void swap(int[] nums, int idx1, int idx2) {
		int temp = nums[idx2];
		nums[idx2] = nums[idx1];
		nums[idx1] = temp;
	}

	private static void print(int[] array) {
		System.out.println(Arrays.toString(array));
	}

}
