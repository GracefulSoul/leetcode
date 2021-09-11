package gracefulsoul.problems;

public class FindMinimumInRotatedSortedArrayII {

	// https://leetcode.com/submissions/detail/552978633/
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArrayII test = new FindMinimumInRotatedSortedArrayII();
		System.out.println(test.findMin(new int[] { 1, 3, 5 }));
		System.out.println(test.findMin(new int[] { 2, 2, 2, 0, 1 }));
	}

	public int findMin(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left < right) {
			int mid = left + ((right - left) / 2);
			if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else if (nums[mid] < nums[right]) {
				right = mid;
			} else {
				right--;
			}
		}
		return nums[left];
	}

}
