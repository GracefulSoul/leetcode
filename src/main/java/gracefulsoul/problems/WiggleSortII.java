package gracefulsoul.problems;

import java.util.Arrays;

public class WiggleSortII {

	// https://leetcode.com/submissions/detail/610662377/
	public static void main(String[] args) {
		WiggleSortII test = new WiggleSortII();
		int[] nums1 = new int[] { 1, 5, 1, 1, 6, 4 };
		test.wiggleSort(nums1);
		print(nums1);
		int[] nums2 = new int[] { 1, 3, 2, 2, 3, 1 };
		test.wiggleSort(nums2);
		print(nums2);
	}

	public void wiggleSort(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return;
		}
		int[] count = new int[5001];
		for (int num : nums) {
			count[num]++;
		}
		int j = 1;
		for (int i = 5000; i >= 0; i--) {
			while (count[i] > 0) {
				nums[j] = i;
				count[i]--;
				j += 2;
				if (j >= length) {
					j = 0;
				}
			}
		}
	}

	private static void print(int[] nums) {
		for (int idx = 0; idx < nums.length; idx++) {
			System.out.print(nums[idx]);
			if (idx < nums.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}

}
