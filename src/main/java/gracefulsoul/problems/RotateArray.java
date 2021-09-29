package gracefulsoul.problems;

import java.util.Arrays;

public class RotateArray {

	// https://leetcode.com/submissions/detail/562704277/
	public static void main(String[] args) {
		RotateArray test = new RotateArray();
		int[] nums1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		test.rotate(nums1, 3);
		System.out.println(Arrays.toString(nums1));
		int[] nums2 = new int[] { -1, -100, 3, 99 };
		test.rotate(nums2, 3);
		System.out.println(Arrays.toString(nums2));
	}

	public void rotate(int[] nums, int k) {
		k %= nums.length;
		this.reverse(nums, 0, nums.length - 1);
		this.reverse(nums, 0, k - 1);
		this.reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
	}

}
