package gracefulsoul.problems;

public class CreateMaximumNumber {

	// https://leetcode.com/submissions/detail/609637188/
	public static void main(String[] args) {
		CreateMaximumNumber test = new CreateMaximumNumber();
		print(test.maxNumber(new int[] { 3, 4, 6, 5 }, new int[] { 9, 1, 2, 5, 8, 3 }, 5));
		print(test.maxNumber(new int[] { 6, 7 }, new int[] { 6, 0, 4 }, 5));
		print(test.maxNumber(new int[] { 3, 9 }, new int[] { 8, 9 }, 3));
	}

	public int[] maxNumber(int[] nums1, int[] nums2, int k) {
		int[] result = new int[k];
		for (int i = Math.max(0, k - nums2.length); i <= Math.min(nums1.length, k); i++) {
			int[] maxNums1 = this.findMax(nums1, i);
			int[] maxNums2 = this.findMax(nums2, k - i);
			int[] merge = this.merge(maxNums1, maxNums2);
			if (this.isGreater(merge, result, 0, 0)) {
				result = merge;
			}
		}
		return result;
	}

	private boolean isGreater(int[] nums1, int[] nums2, int i, int j) {
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] > nums2[j]) {
				return true;
			} else if (nums1[i] < nums2[j]) {
				return false;
			} else {
				i++;
				j++;
			}
		}
		return i < nums1.length;
	}

	private int[] merge(int[] nums1, int[] nums2) {
		int i = 0;
		int j = 0;
		int length = nums1.length + nums2.length;
		int[] result = new int[length];
		for (int k = 0; k < length; k++) {
			if (this.isGreater(nums1, nums2, i, j)) {
				result[k] = nums1[i++];
			} else {
				result[k] = nums2[j++];
			}
		}
		return result;
	}

	private int[] findMax(int[] nums, int k) {
		int j = 0;
		int length = nums.length;
		int[] result = new int[k];
		for (int i = 0; i < length; i++) {
			while (j > 0 && result[j - 1] < nums[i] && j + length - i > k) {
				j--;
			}
			if (j < k) {
				result[j++] = nums[i];
			}
		}
		return result;
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
