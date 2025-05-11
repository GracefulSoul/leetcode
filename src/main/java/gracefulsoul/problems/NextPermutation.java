package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class NextPermutation {

	// https://leetcode.com/problems/next-permutation/submissions/1630898566/
	public static void main(String[] args) {
		NextPermutation test = new NextPermutation();
		int[] nums1 = new int[] { 1, 2, 3 };
		test.nextPermutation(nums1);
		PrintUtil.print(nums1);
		int[] nums2 = new int[] { 3, 2, 1 };
		test.nextPermutation(nums2);
		PrintUtil.print(nums2);
		int[] nums3 = new int[] { 1, 1, 5 };
		test.nextPermutation(nums3);
		PrintUtil.print(nums3);
	}

	public void nextPermutation(int[] nums) {
		int length = nums.length;
		if (1 < length) {
			int i = length - 2;
			while (0 <= i && nums[i] >= nums[i + 1]) {
				i--;
			}
			if (i >= 0) {
				int j = length - 1;
				while (nums[j] <= nums[i]) {
					j--;
				}
				this.swap(nums, i, j);
			}
			this.reverse(nums, i + 1, length - 1);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			this.swap(nums, i++, j--);
		}
	}

}
