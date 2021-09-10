package gracefulsoul.problems;

public class FindMinimumInRotatedSortedArray {

	// https://leetcode.com/submissions/detail/552314868/
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray test = new FindMinimumInRotatedSortedArray();
		System.out.println(test.findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(test.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println(test.findMin(new int[] { 11, 13, 15, 17 }));
	}

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = (left + right) / 2;
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return nums[left];
	}

}
