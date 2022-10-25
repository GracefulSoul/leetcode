package gracefulsoul.problems;

public class BinarySearch {

	// https://leetcode.com/problems/binary-search/submissions/
	public static void main(String[] args) {
		BinarySearch test = new BinarySearch();
		System.out.println(test.search(new int[] { 1, 0, 3, 5, 9, 12 }, 9));
		System.out.println(test.search(new int[] { 1, 0, 3, 5, 9, 12 }, 2));
	}

	public int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + ((right - left) / 2);
			if (nums[mid] > target) {
				right = mid - 1;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

}
