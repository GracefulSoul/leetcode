package gracefulsoul.problems;

public class FindPeakElement {

	// https://leetcode.com/submissions/detail/554511647/
	public static void main(String[] args) {
		FindPeakElement test = new FindPeakElement();
		System.out.println(test.findPeakElement(new int[] { 1, 2, 3, 1 }));
		System.out.println(test.findPeakElement(new int[] { 1, 2, 1, 3, 5, 6, 4 }));
	}

	public int findPeakElement(int[] nums) {
		int length = nums.length;
		if (length == 1) {
			return 0;
		}
		int left = 0;
		int right = length - 1;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] < nums[mid + 1]) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return nums[left] > nums[right] ? left : right;
	}

}
