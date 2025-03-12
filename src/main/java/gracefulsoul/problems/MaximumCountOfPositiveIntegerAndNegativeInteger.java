package gracefulsoul.problems;

public class MaximumCountOfPositiveIntegerAndNegativeInteger {

	// https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/submissions/1571249642/
	public static void main(String[] args) {
		MaximumCountOfPositiveIntegerAndNegativeInteger test = new MaximumCountOfPositiveIntegerAndNegativeInteger();
		System.out.println(test.maximumCount(new int[] { -2, -1, -1, 1, 2, 3 }));
		System.out.println(test.maximumCount(new int[] { -3, -2, -1, 0, 0, 1, 2 }));
		System.out.println(test.maximumCount(new int[] { 5, 20, 66, 1314 }));
	}

	public int maximumCount(int[] nums) {
		return Math.max(this.binarySearch(nums, 0), nums.length - this.binarySearch(nums, 1));
	}

	private int binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return right;
	}

}
