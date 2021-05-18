package gracefulsoul.problems;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

	// https://leetcode.com/submissions/detail/494715184/
	public static void main(String[] args) {
		FindFirstAndLastPositionOfElementInSortedArray test = new FindFirstAndLastPositionOfElementInSortedArray();
		print(test.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
		print(test.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6));
		print(test.searchRange(new int[] {}, 0));
	}

	public int[] searchRange(int[] nums, int target) {
		int first = this.search(nums, target);
		if (first == nums.length || nums[first] != target) {
			return new int[] { -1, -1 };
		} else {
			return new int[] { first, this.search(nums, target + 1) - 1 };
		}
	}

	private int search(int[] nums, int target) {
		int low = 0;
		int high = nums.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (nums[mid] < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private static void print(int[] nums) {
		System.out.println(Arrays.toString(nums));
	}

}
